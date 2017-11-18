package com.example.ehuang.hackwestern;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.thalmic.myo.*;
import com.thalmic.myo.scanner.ScanActivity;

import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    //Need this because TAG is private otherwise
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the hub to be used by the myo device
        Hub hub = Hub.getInstance();
        if (!hub.init(this)) {
            Log.e(TAG, "Could not initialize the Hub.");
            finish();
            return;
        }

        // Will connect with a myo device that is very close to phone
        Hub.getInstance().attachToAdjacentMyo();
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
