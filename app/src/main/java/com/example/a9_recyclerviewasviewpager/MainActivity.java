package com.example.a9_recyclerviewasviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.a9_recyclerviewasviewpager.adapter.CustomAdapter;
import com.example.a9_recyclerviewasviewpager.medel.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }
    private  void initView(){
        recyclerView = findViewById(R.id.recycleViewMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        SnapHelper snapHelper = new PagerSnapHelper(); /* bu  funksiya gorizontal o`tkazganimizda qotib
        qolmaydi ikkinchi o'tkazib yuboradi */
        snapHelper.attachToRecyclerView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int activityPosition = layoutManager.findFirstVisibleItemPosition();
                if (activityPosition == RecyclerView.NO_POSITION) return;
            }

        });
    }
    private  void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(members,context);
        recyclerView.setAdapter(adapter);
    }
    private List<Member> prepareMemberList(){
     List<Member> members = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            members.add(new Member("Sherzod","Jurabekov"));
        }
        return members;
    }

}