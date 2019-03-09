package com.example.app.myapplication.util.image;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by diegoveloper on 10/1/17.
 */
@IntDef({
        ImageBuilder.TRANSFORMATION_NONE,
        ImageBuilder.TRANSFORMATION_CIRCLE,
        ImageBuilder.TRANSFORMATION_SQUARE})
@Retention(RetentionPolicy.SOURCE)
public @interface ImageTransformation {
}
