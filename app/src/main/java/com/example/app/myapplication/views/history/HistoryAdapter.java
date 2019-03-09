package com.example.app.myapplication.views.history;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.app.myapplication.R;
import com.example.app.myapplication.model.entity.HelpEntity;
import com.example.app.myapplication.model.entity.LoadingEntity;
import com.example.app.myapplication.model.response.HistoryResponse;
import com.example.app.myapplication.model.response.PostResponse;
import com.example.app.myapplication.util.Constant;
import com.example.app.myapplication.util.image.ImageBuilder;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ricardo Bravo on 14/01/17.
 */

class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> objectList;
    private LayoutInflater inflater = null;
    private final Context context;
    private final HistoryView historyView;

    HistoryAdapter(HistoryView historyView, Context context) {
        this.context = context;
        this.historyView = historyView;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        objectList = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (objectList.get(position) instanceof HistoryResponse.DataEntity) {
            return Constant.TAG_ITEM;
        } else if (objectList.get(position) instanceof LoadingEntity) {
            return Constant.TAG_LOADING;
        } else {
            return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == Constant.TAG_ITEM) {
            view = inflater.inflate(R.layout.item_history, parent, false);
            return new HistoryViewHolder(view);
        } else {
            view = inflater.inflate(R.layout.item_recycler_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (objectList.get(position) instanceof HistoryResponse.DataEntity) {

            HistoryViewHolder itemHolder = (HistoryViewHolder) holder;

            final HistoryResponse.DataEntity data = (HistoryResponse.DataEntity) objectList.get(position);

            itemHolder.nameAvatar.setText(data.getClientName());
            itemHolder.date.setText(data.getDate());
            itemHolder.money.setText(data.getMoney());

            ImageBuilder.with(context)
                    .load(data.getClientImg())
                    .transform(ImageBuilder.TRANSFORMATION_CIRCLE)
                    .error(R.drawable.ic_ac_unit)
                    .placeholder(R.drawable.ic_ac_unit)
                    .into(itemHolder.imgAvatar);

        } else if (objectList.get(position) instanceof LoadingEntity) {
            ((LoadingViewHolder) holder).pbLoading.setIndeterminate(true);
        }

    }

    public void load(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

   public class HistoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vgeneral)
        CardView vgeneral;

        @BindView(R.id.imgAvatar)
        AppCompatImageView imgAvatar;

        @BindView(R.id.nameAvatar)
        TextView nameAvatar;

        @BindView(R.id.date)
        TextView date;

        @BindView(R.id.money)
        TextView money;


        HistoryViewHolder(View view) {
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

}