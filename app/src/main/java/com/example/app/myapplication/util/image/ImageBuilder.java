package com.example.app.myapplication.util.image;

import android.content.Context;
import android.widget.ImageView;

import com.example.app.myapplication.R;
import com.example.app.myapplication.component.picasso.CircleTransform;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;


/**
 * Created by diegoveloper on 10/1/17.
 */

public class ImageBuilder {

    public final static int TRANSFORMATION_NONE = 0;
    public final static int TRANSFORMATION_CIRCLE = 1;
    public final static int TRANSFORMATION_SQUARE = 2;

    private final Context context;
    private String url;
    private int errorDrawable;
    private int placeHolderDrawable;
    private
    @ImageTransformation
    int imageTransformation;
    boolean fit;
    boolean centerInside;

    private ImageBuilder(Context context) {
        this.context = context;
    }


    public static ImageBuilder with(Context context) {
        return new ImageBuilder(context);
    }

    public ImageBuilder load(String url) {
        this.url = url;
        return this;
    }

    public ImageBuilder error(int errorDrawable) {
        this.errorDrawable = errorDrawable;
        return this;
    }

    public ImageBuilder fit() {
        this.fit = true;
        return this;
    }

    public ImageBuilder centerInside() {
        this.centerInside = true;
        return this;
    }

    public ImageBuilder placeholder(int placeHolderDrawable) {
        this.placeHolderDrawable = placeHolderDrawable;
        return this;
    }

    public ImageBuilder transform(@ImageTransformation int imageTransformation) {
        this.imageTransformation = imageTransformation;
        return this;
    }

    public void into(Target target) {
        into(null, null, target);
    }

    public void into(ImageView imageView) {
        into(imageView, null, null);
    }

    public void into(ImageView imageView, final ImageListener imageListener) {
        into(imageView, imageListener, null);
    }

    public void into(ImageView imageView, final ImageListener imageListener, Target target) {
        RequestCreator request = Picasso.with(context)
                .load(url);

        if (errorDrawable > 0) {
            request.error(errorDrawable);
        } else {
            request.error(R.drawable.ic_ac_unit);
        }

        if (placeHolderDrawable > 0) {
            request.placeholder(placeHolderDrawable);
        } else {
            request.placeholder(R.drawable.ic_ac_unit);
        }

        if (imageTransformation == TRANSFORMATION_CIRCLE) {
            request.transform(new CircleTransform());
        }

        if (fit) {
            request.fit();
        }

        if (fit && centerInside) {
            // request.centerInside();
            request.centerCrop();
        }

        if (imageView != null) {
            if (imageListener != null) {
                request.into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        imageListener.onImageLoaded();
                    }

                    @Override
                    public void onError() {
                        imageListener.onImageError();
                    }
                });
            } else {
                request.into(imageView);
            }
        } else if (target != null) {
            System.out.println("setting image into target : " + url);
            request.into(target);
        }
    }
}
