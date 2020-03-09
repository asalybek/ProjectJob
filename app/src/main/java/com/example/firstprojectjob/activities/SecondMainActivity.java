package com.example.firstprojectjob.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.firstprojectjob.IChange;
import com.example.firstprojectjob.R;
import com.example.firstprojectjob.adapters.ViewPagerFragmentAdapter;
import com.example.firstprojectjob.fragments.FragmentPosts;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
public class SecondMainActivity extends AppCompatActivity implements IChange {
    TabLayout tabLayout;
    FragmentPosts fragmentPage;
    FragmentPosts fragmentLiked;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ViewPager viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabLayout);

        viewPager.setAdapter(new ViewPagerFragmentAdapter(getSupportFragmentManager(), 0, getFragments()));
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();

        fragmentPage = FragmentPosts.newInstance(true);
        fragmentLiked = FragmentPosts.newInstance(false);

        fragments.add(fragmentPage);
        fragments.add(fragmentLiked);

        return fragments;
    }
    public void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_page);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_tab_liked);
    }
    @Override
    public void onPostLike() {
        fragmentPage.updatePage();
        fragmentLiked.updateLike();
    }
}

