package io.github.subhamtyagi.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VinShowActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton btn_get_pics;
    ImageButton btn_get_more_info;
    EditText text_VIN;
    String str_VIN = "";
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String message_result = intent.getStringExtra("Result_VIN");
//        Log.d("result_vin", message_result);
        btn_get_pics = (ImageButton)this.findViewById(R.id.btn_scan_pic);
        btn_get_more_info = (ImageButton)this.findViewById(R.id.btn_go_info_site);
        text_VIN = (EditText)this.findViewById(R.id.vin_text);
        btn_get_more_info.setOnClickListener(this);
        btn_get_pics.setOnClickListener(this);
        String[] separated = message_result.split(" ");

        for (String s : separated) {
            if (s.length() >= 17) {
                Log.d("result_vin", s);
                str_VIN = s;
                break;
            }
        }
        text_VIN.setText(str_VIN.toUpperCase());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_go_info_site:
                Intent show_info_intent = new Intent(this, ShowInfoActivity.class);
                show_info_intent.putExtra("VIN", str_VIN);
                startActivity(show_info_intent);
                break;
            case R.id.btn_scan_pic:
                Intent get_pics = new Intent(this, MainActivity.class);
                startActivity(get_pics);
                break;
        }
    }
}
