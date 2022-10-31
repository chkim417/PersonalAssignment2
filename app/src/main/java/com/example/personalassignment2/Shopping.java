package com.example.personalassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        myRecyclerViewAdapter adapter;
        RecyclerView recyclerView;

        //데이터 모델리스트
        ArrayList<GoodsModel> dataModels = new ArrayList();

        dataModels.add(new GoodsModel("015B ,오왠 : 세월의 흔적 다 버리고", R.drawable.man));
        dataModels.add(new GoodsModel("새벽공방 : 다섯밤", R.drawable.man));
        dataModels.add(new GoodsModel("폴킴 : 우리 만남이", R.drawable.man));
        dataModels.add(new GoodsModel("안녕하신가영 : 니가 좋아", R.drawable.man));
        dataModels.add(new GoodsModel("넬 : 멀어지다", R.drawable.man));
        dataModels.add(new GoodsModel("꽃잠프로젝트 : 그대는 어디 있나요", R.drawable.man));
        dataModels.add(new GoodsModel("검정치마 : 기다린 만큼 ,더", R.drawable.man));
        dataModels.add(new GoodsModel("어쿠루브 : 그게 뭐라고", R.drawable.man));
        dataModels.add(new GoodsModel("우효 : Grace", R.drawable.man));
        dataModels.add(new GoodsModel("브로콜리너마저 : 보편적인 노래", R.drawable.man));


        recyclerView = findViewById(R.id.recyclerview);
        adapter = new myRecyclerViewAdapter(this, dataModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}