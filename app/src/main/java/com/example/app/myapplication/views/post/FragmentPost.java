package com.example.app.myapplication.views.post;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.myapplication.R;
import com.example.app.myapplication.component.RecyclerViewDivider;
import com.example.app.myapplication.model.entity.HelpEntity;
import com.example.app.myapplication.model.response.PostResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentPost extends Fragment implements PostView {

    @BindView(R.id.rcvList)
    RecyclerView rcvList;
    private final List<Object> objectList = new ArrayList<>();
    private PostAdapter postAdapter;
    private LinearLayoutManager layoutManager;

   List<PostResponse.DataEntity> postResponse = new ArrayList<>();
    public FragmentPost() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        init();

    }

    private void init() {
        postAdapter = new PostAdapter(this, getContext());
        objectList.add(new HelpEntity(0, ""));
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rcvList.setLayoutManager(layoutManager);
        rcvList.setItemAnimator(new DefaultItemAnimator());
        rcvList.addItemDecoration(new RecyclerViewDivider(getContext()));
        rcvList.setAdapter(postAdapter);
        loadList();
        loadList();
        loadList();
        loadList();
        loadList();
        loadList();
        postAdapter.load(objectList);
        postAdapter.notifyDataSetChanged();

        Log.v("lol","d "+postAdapter.getItemCount());
    }

    private void loadList() {
        PostResponse.DataEntity item = new PostResponse.DataEntity();
        item.setClientImg("https://www.portafolio.co/files/article_multimedia/uploads/2018/05/01/5ae8d5210e8c3.jpeg");
        item.setNumComments(10);
        item.setClientName("Ytalo");

        item.setPostImg("http://www.alegsa.com.ar/Imagen/gears-1236578_960_720.jpg");
        item.setPostText("Zuckerberg, que solo está detrás del fundador de Amazon.com Inc. Jeff Bezos y del cofundador de Microsoft Corp. Bill Gates, eclipsó a Buffett el viernes ");
        item.setPostTime("10 min");
        item.setNumShares(10);
        objectList.add(item);
    }


}
