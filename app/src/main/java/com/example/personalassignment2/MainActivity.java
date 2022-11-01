package com.example.personalassignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button LogInButton = (Button) findViewById(R.id.LogInButton);
        Button SignUpButton = (Button) findViewById(R.id.SignUpButton);
        Button WithoutSingUpButton = (Button) findViewById(R.id.WithoutSignUpButton);

        EditText IDText = (EditText) findViewById(R.id.IDEdit);
        EditText PWText = (EditText) findViewById(R.id.PWEdit);

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("user_info", MODE_PRIVATE);
                String json = prefs.getString(IDText.getText().toString(), null);
                ArrayList<String> urls = new ArrayList<String>();
                if (json != null) {
                    try {
                        JSONArray a = new JSONArray(json);
                        for (int i = 0; i < a.length(); i++) {
                            String url = a.optString(i);
                            urls.add(url);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    urls.add(null);
                }

                if(IDText.getText().toString().length() == 0){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this);
                    msgBuilder  .setTitle("")
                            .setMessage("아이디를 입력해주세요")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();
                }

                else if (json == null){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this);
                    msgBuilder  .setTitle("")
                            .setMessage("없는 아이디입니다")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    IDText.setText("");
                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }
                else if(PWText.getText().toString().length() == 0){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this);
                    msgBuilder  .setTitle("")
                            .setMessage("비밀번호를 입력해주세요")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }

                else if(urls.indexOf(PWText.getText().toString()) != 0){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this);
                    msgBuilder  .setTitle("")
                            .setMessage("비밀번호가 일치하지 않습니다")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                PWText.setText("");
                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }
                else{
                    Intent intent = new Intent(getApplication(),Shopping.class);
                    intent.putExtra("ID",IDText.getText().toString());
                    intent.putExtra("isUser", "ISUSER");
                    startActivity(intent);
                    finish();

                }

            }
        });

        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(),SignUp.class);
                startActivity(intent);
                finish();

            }
        });

        WithoutSingUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this);
                msgBuilder  .setTitle("비회원으로 상품 보기")
                            .setMessage("회원 가입 없이 보시겠습니까? ")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(getApplication(),Shopping.class);
                                    intent.putExtra("isUser", "ISNOTUSER");
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });

                AlertDialog msgDlg = msgBuilder.create();
                msgDlg.show();


            }
        });


    }
}