package com.example.personalassignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public class SignUp extends AppCompatActivity {



    EditText editText_UserID;
    EditText editText_UserPW;
    EditText editText_UserPWCheck;
    EditText editText_UserName;
    EditText editText_UserAddress;
    EditText editText_UserPhoneNumber;

    RadioGroup rdgGroup;
    RadioButton rdoButton;
    RadioButton agreeBt;

    String abcd;



    ArrayAdapter<String> adpater;
    ArrayList<String> array = new ArrayList<>();

    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button overlapCheck = (Button) findViewById(R.id.OverlapCheck);
        Button checkAndGotoMain = (Button) findViewById(R.id.CheckAndGoToMain);

        editText_UserID = (EditText) findViewById(R.id.UserID);
        editText_UserPW = (EditText) findViewById(R.id.UserPW);
        editText_UserPWCheck = (EditText) findViewById(R.id.UserPWCheck);
        editText_UserName =  (EditText) findViewById(R.id.UserName);
        editText_UserAddress = (EditText) findViewById(R.id.UserEmail);
        editText_UserPhoneNumber = (EditText) findViewById(R.id.UserPhoneNumber);

        rdgGroup = findViewById( R.id.radioGroup);
        rdoButton = findViewById( rdgGroup.getCheckedRadioButtonId() );
        agreeBt = findViewById(R.id.Agree);














        checkAndGotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),MainActivity.class);

                Boolean IsPWFitTheRule = PWFitTheRule(editText_UserPW.getText().toString());
                Boolean IsIDFitTheRule = IDFitTheRule(editText_UserID.getText().toString());



                if(editText_UserName.getText().toString().length() == 0 ||editText_UserID.getText().toString().length() == 0 || editText_UserPW.getText().toString().length() == 0||editText_UserPhoneNumber.getText().toString().length() == 0||editText_UserAddress.getText().toString().length() == 0){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("빈 칸 있음")
                            .setMessage("빈 칸을 채워주세요.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    editText_UserName.setInputType();
                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();


                }
                else if(editText_UserAddress.getText().toString().indexOf("@")==-1){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("이메일 형식 오류")
                            .setMessage("이메일의 형식을 다시 확인해주세요.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();


                }
                else if(editText_UserID.getText().toString().length() < 6 || editText_UserID.getText().toString().length()>20||!IsIDFitTheRule){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("아이디 형식 오류")
                            .setMessage("아이디는 6~20자의 영어 소문자와 숫자로만 구성돼야 합니다.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }

                 else if(!IsPWFitTheRule){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("비밀번호 형식 오류")
                            .setMessage("비밀번호 형식을 다시 확인해주세요.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {







                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }
                else if(!(editText_UserPW.getText().toString().equals(editText_UserPWCheck.getText().toString()))){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("비밀번호가 일치하지 않습니다")
                            .setMessage("비밀번호를 확인해주세요")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    editText_UserPW.setText("");
                                    editText_UserPWCheck.setText("");


                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();


                }
                else if(!agreeBt.isChecked()){
                     AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                             .setTitle("약관 확인")
                             .setMessage("약관에 동의해주세요")
                             .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                 @Override
                                 public void onClick(DialogInterface dialogInterface, int i) {

                                 }
                             });

                     AlertDialog msgDlg = msgBuilder.create();
                     msgDlg.show();



                 }

                else{

                     ArrayList<String> list = new ArrayList<String>();
                     list.add(editText_UserPW.getText().toString());
                     list.add(editText_UserName.getText().toString());
                     list.add(editText_UserAddress.getText().toString());
                     list.add(editText_UserPhoneNumber.getText().toString());

                     setStringArrayPref(editText_UserID.getText().toString(), list);




                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("가입 완료")
                            .setMessage("회원가입이 완료됐습니다.")
                            .setNeutralButton("로그인 하러 가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    startActivity(intent);
                                    finish();
                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();


                }
            }


        });


        overlapCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Boolean IsPWFitTheRule = PWFitTheRule(editText_UserPW.getText().toString());
                Boolean IsIDFitTheRule = IDFitTheRule(editText_UserID.getText().toString());
                if(getStringArrayPref(editText_UserID.getText().toString()).indexOf(null)== -1){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("아이디 중복")
                            .setMessage("같은 아이디가 존재합니다")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();


                }
                else if(!IsIDFitTheRule){
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("아이디 형식 오류")
                            .setMessage("아이디는 6~20자의 영어 소문자와 숫자로만 구성돼야 합니다.")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }
                else{
                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                            .setTitle("사용 가능한 아이디")
                            .setMessage("사용 가능한 아이디입니다")
                            .setNeutralButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog.Builder msgBuilder = new AlertDialog.Builder(SignUp.this)
                                            .setTitle("아이디 선택")
                                            .setMessage("이 아이디로 하시겠습니까?")
                                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    editText_UserID.setClickable(false);
                                                    editText_UserID.setFocusable(false);
                                                    editText_UserID.setBackgroundColor(Color.GRAY);
                                                    checkAndGotoMain.setEnabled(true);



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
                            });

                    AlertDialog msgDlg = msgBuilder.create();
                    msgDlg.show();

                }

            }
        });


    }





    boolean PWFitTheRule(String s) {
        boolean rtn = true;

        if(s.length()<8 || s.length()> 15){
            rtn = false;
            return rtn;
        }
        for(int i = 0; i<s.length(); i++){
            int idx =s.charAt(i);
            if(47>=idx||(58<=idx&&idx<=92)||122<=idx){
                rtn=false;

            }
        }

    return(rtn);
    };
    boolean IDFitTheRule(String s) {
        boolean rtn = true;

        if(s.length()<6 || s.length()> 20){
            rtn = false;
            return rtn;
        }else{
            for(int i = 0; i<s.length(); i++){
                int idx =s.charAt(i);
                if(47>=idx||(58<=idx&&idx<=92)||122<=idx){
                    rtn = false;
                    return rtn;
                }
            }
        }
        return rtn;
    };
    private void setStringArrayPref(String key, ArrayList<String> values) {
        SharedPreferences prefs = getSharedPreferences("user_info", 0);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }
    private ArrayList<String> getStringArrayPref( String key) {
        SharedPreferences prefs = getSharedPreferences("user_info", 0);
        String json = prefs.getString(key, null);
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

        return urls;
    }










}