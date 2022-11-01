package com.example.personalassignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity {
    String id;
    String info;
    String isUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);



        myRecyclerViewAdapter adapter;
        RecyclerView recyclerView;
        Button UserInfo = (Button) findViewById(R.id.bt_UserInfo);

        UserInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentFromLogIn = getIntent();
                id = intentFromLogIn.getStringExtra("ID");
                info = intentFromLogIn.getStringExtra("정보");
                isUser = intentFromLogIn.getStringExtra("isUser");
                if(isUser.equals("ISNOTUSER")){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(Shopping.this)
                            .setTitle("회원이 아닙니다")
                            .setMessage("회원가입 하시겠습니까?")
                            .setPositiveButton("예", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent intentShoppingToSignUp = new Intent(getApplication(), SignUp.class);
                                            startActivity(intentShoppingToSignUp);
                                            finish();


                                        }
                                    }


                            )
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {


                                        }
                                    }


                            );

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();



                }
               else{
                    Intent intentShoppingToPopUP = new Intent(getApplication(), PopUp.class);

                    intentShoppingToPopUP.putExtra("ID", id);
                    intentShoppingToPopUP.putExtra("정보", info);

                    startActivity(intentShoppingToPopUP);
                    finish();
               }


            }
        });

        //데이터 모델리스트
        ArrayList<GoodsModel> dataModels = new ArrayList();

        dataModels.add(new GoodsModel("하빈저벨트", R.drawable.harbingerbelt));
        dataModels.add(new GoodsModel("레그익스텐션기계", R.drawable.legextensionmachine));
        dataModels.add(new GoodsModel("여성용 레깅스", R.drawable.leggings));
        dataModels.add(new GoodsModel("남성용 헬스 나시", R.drawable.nashi));
        dataModels.add(new GoodsModel("핑크덤벨", R.drawable.pinkdumbell));
        dataModels.add(new GoodsModel("가정용 턱걸이기계", R.drawable.pullupmachine));
        dataModels.add(new GoodsModel("턱걸이 보조밴드", R.drawable.pullupsupportband));
        dataModels.add(new GoodsModel("손보호장갑", R.drawable.shieldglove));
        dataModels.add(new GoodsModel("무게조절덤벨", R.drawable.weightcontroldumbel));
        dataModels.add(new GoodsModel("wsf헬스스트랩", R.drawable.wsfgrip));


        recyclerView = findViewById(R.id.recyclerview);
        adapter = new myRecyclerViewAdapter(this, dataModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}