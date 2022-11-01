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
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class PopUp extends AppCompatActivity {
    ArrayList<String> urls = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        Intent intentfronShopping = getIntent();
        String IDinPopUp =intentfronShopping.getStringExtra("ID");

        TextView nameTextPopUp = (TextView) findViewById(R.id.popupName);
        TextView idTextPopUp = (TextView) findViewById(R.id.popupID);
        TextView phoneNumberTextPopUp = (TextView) findViewById(R.id.popupPhoneNumber);
        TextView addressTextPopUp = (TextView) findViewById(R.id.popupAddress);
        Button back = (Button) findViewById(R.id.backToShopping);

        SharedPreferences prefs = getSharedPreferences("user_info", MODE_PRIVATE);
        String json = prefs.getString(IDinPopUp, null);
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

        nameTextPopUp.setText(nameTextPopUp.getText().toString() +urls.get(1)   );
        idTextPopUp.setText(idTextPopUp.getText().toString() + IDinPopUp  );
        phoneNumberTextPopUp.setText(phoneNumberTextPopUp.getText().toString() + urls.get(3)  );
        addressTextPopUp.setText(addressTextPopUp.getText().toString() + urls.get(2)  );


        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplication(), Shopping.class);
               intent.putExtra("ID", IDinPopUp);
               intent.putExtra("정보", json );
               if(json != null){
                   intent.putExtra("isUser","ISUSER" );
               }
               else{
                   intent.putExtra("isUser","ISNOTUSER" );
               }

               startActivity(intent);
               finish();
            }
        });


    }
}