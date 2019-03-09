package com.example.app.myapplication.views.post;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.app.myapplication.R;
import com.example.app.myapplication.model.entity.HelpEntity;
import com.example.app.myapplication.model.entity.LoadingEntity;
import com.example.app.myapplication.model.response.PostResponse;
import com.example.app.myapplication.util.Constant;
import com.example.app.myapplication.util.image.ImageBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ricardo Bravo on 14/01/17.
 */

class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> objectList;
    private LayoutInflater inflater = null;
    private final Context context;
    private final PostView postView;

    PostAdapter(PostView postView, Context context) {
        this.context = context;
        this.postView = postView;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        objectList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof PostResponse.DataEntity) {
            return Constant.TAG_ITEM;
        } else if (objectList.get(position) instanceof LoadingEntity) {
            return Constant.TAG_LOADING;
        } else if (objectList.get(position) instanceof HelpEntity) {
            return Constant.TAG_HELP;
        } else {
            return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == Constant.TAG_ITEM) {
            view = inflater.inflate(R.layout.item_post, parent, false);
            return new ClubViewHolder(view);
        } else if (viewType == Constant.TAG_LOADING) {
            view = inflater.inflate(R.layout.item_recycler_loading, parent, false);
            return new LoadingViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.item_help, parent, false);
            return new HelpViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (objectList.get(position) instanceof PostResponse.DataEntity) {

            ClubViewHolder itemHolder = (ClubViewHolder) holder;

            final PostResponse.DataEntity data = (PostResponse.DataEntity) objectList.get(position);

            itemHolder.nameAvatar.setText(data.getClientName());
            itemHolder.time.setText(data.getPostTime());
            itemHolder.time.setText(data.getPostTime());
            itemHolder.textPost.setText(data.getPostText());

            ImageBuilder.with(context)
                    .load(data.getClientImg())
                    .transform(ImageBuilder.TRANSFORMATION_CIRCLE)
                    .error(R.drawable.ic_ac_unit)
                    .placeholder(R.drawable.ic_ac_unit)
                    .into(itemHolder.imgAvatar);

            ImageBuilder.with(context)
                    .load(data.getPostImg())
                    .error(R.drawable.ic_ac_unit)
                    .placeholder(R.drawable.ic_ac_unit)
                    .into(itemHolder.imgPost);


        } else if (objectList.get(position) instanceof LoadingEntity) {
            ((LoadingViewHolder) holder).pbLoading.setIndeterminate(true);
        } else if (objectList.get(position) instanceof HelpEntity) {

            HelpViewHolder itemHolder = (HelpViewHolder) holder;
//            itemHolder.txtSearch.setText(((SearchEntity) objectList.get(position)).getSearch());

            ImageBuilder.with(context)
                    .load("https://www.conceptosydefiniciones.com/wp-content/uploads/2018/01/sermejorpersona2-280x200.jpg")
                    .transform(ImageBuilder.TRANSFORMATION_CIRCLE)
                    .error(R.drawable.ic_ac_unit)
                    .placeholder(R.drawable.ic_ac_unit)
                    .into(itemHolder.imgAvatar);
        }
    }

    public void load(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class ClubViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vgeneral)
        CardView vgeneral;

        @BindView(R.id.imgAvatar)
        AppCompatImageView imgAvatar;

        @BindView(R.id.nameAvatar)
        TextView nameAvatar;

        @BindView(R.id.time)
        TextView time;

        @BindView(R.id.textPost)
        TextView textPost;

        @BindView(R.id.imgPost)
        AppCompatImageView imgPost;

        ClubViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

//        @OnClick(R.id.linGeneral)
//        void onClickLinear() {
//
//            if (objectList.get(getAdapterPosition()) instanceof ClubResponse.DataBean) {
//                ClubResponse.DataBean data = (ClubResponse.DataBean) objectList.get(getAdapterPosition());
//                clubView.showCompany(data.getLinks().getSelf(),
//                        data.getAttributes().getCompany().getData().getAttributes().getName(),
//                        imgLogo, data.getAttributes().getCompany().getData().getAttributes().getLogo(),
//                        data.getAttributes().getTotalPoints()
//                );
//            }
//
//        }
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        final ProgressBar pbLoading;

        LoadingViewHolder(View v) {
            super(v);
            pbLoading = (ProgressBar) v.findViewById(R.id.pbLoading);
        }
    }

    public class HelpViewHolder extends RecyclerView.ViewHolder {

        //         AppCompatEditText txtSearch;
//         RelativeLayout imgClose;
//         RelativeLayout linearLayout;
        @BindView(R.id.imgAvatar)
        AppCompatImageView imgAvatar;

        HelpViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }
}