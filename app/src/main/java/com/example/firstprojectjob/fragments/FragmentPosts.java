package com.example.firstprojectjob.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.firstprojectjob.IChange;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.activities.MainActivity;
import com.example.firstprojectjob.activities.SecondMainActivity;
import com.example.firstprojectjob.adapters.PostAdapter;
import com.example.firstprojectjob.model.Post;
import com.example.firstprojectjob.model.PostsContainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentPosts extends Fragment implements IChange {
    private PostAdapter adapter;
    private boolean isAllPostVersion;
    private List<Post> dataSet = new ArrayList<>();

    private PostsContainer postsContainer = PostsContainer.get();

    public static FragmentPosts newInstance(boolean isAllPostVersion) {
        FragmentPosts fragment = new FragmentPosts();
        fragment.isAllPostVersion = isAllPostVersion;
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_posts,container,false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);

        if(isAllPostVersion){
            Log.d("FragmentPosts","getALLPosts");
            dataSet.addAll(postsContainer.getAllPosts());
        }
        else{
            dataSet.addAll(postsContainer.getLikedPosts());
        }
        adapter = new PostAdapter(dataSet,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        return v;

    }
    public void onPostLike() {
       ((SecondMainActivity)getActivity()).onPostLike();
    }

    public void updateLike(){
        dataSet.clear();
        dataSet.addAll(postsContainer.getLikedPosts());
        adapter.notifyDataSetChanged();
    }
    public void updatePage(){
        dataSet.clear();
        dataSet.addAll(postsContainer.getAllPosts());
        adapter.notifyDataSetChanged();
    }
}
