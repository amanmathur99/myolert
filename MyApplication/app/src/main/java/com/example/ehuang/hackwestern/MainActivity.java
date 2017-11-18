package com.example.ehuang.hackwestern;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Button b;
    String num = "1234567890";
    public void addListenerOnButtonClick(){
        b = (Button)findViewById(R.id.button);
        b.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        Intent callintent = new Intent(Intent.ACTION_CALL);
                        callintent.setData(Uri.parse("tel:"+num));
                        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                            return;
                        }
                        startActivity(callintent);
                    }
                }
        );
    }
}
