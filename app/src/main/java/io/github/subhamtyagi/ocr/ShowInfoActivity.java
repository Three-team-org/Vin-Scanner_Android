package io.github.subhamtyagi.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowInfoActivity extends AppCompatActivity {

    WebView view_show;
    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_info);

        Intent intent = getIntent();
        String message_vin = intent.getStringExtra("VIN");

        view_show = (WebView) findViewById(R.id.webview_show_info);
//        view_show.loadUrl("https://csps.con.rcmp-grc.gc.ca/queryVehicles?vin="+message_vin);
        view_show.loadUrl("https://csps.con.rcmp-grc.gc.ca");
    }
}
