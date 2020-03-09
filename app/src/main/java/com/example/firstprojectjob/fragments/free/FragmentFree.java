package com.example.firstprojectjob.fragments.free;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstprojectjob.adapters.FreeAdapter;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.model.Knp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentFree extends Fragment {
    RecyclerView recyclerView;
    private FreeAdapter freeAdapter;
    private List<Knp> mKnpList = new ArrayList<>();
    FreePresenter freePresenter = new FreePresenter(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_free,container,false);
        recyclerView = v.findViewById(R.id.recyclerView);
        freeAdapter = new FreeAdapter(mKnpList);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(freeAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),LinearLayoutManager.VERTICAL));

        freePresenter.getKnps();

        return v;
    }

    public void modifyKnps(Knp[] knps){
        mKnpList.addAll(Arrays.asList(knps));
        freeAdapter.notifyDataSetChanged();
    }
}
