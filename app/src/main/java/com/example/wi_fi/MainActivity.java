package com.example.wi_fi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Switch toogleWifi = findViewById(R.id.switch1);
        toogleWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    toogleWifiStatus(true);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Aktif", Toast.LENGTH_SHORT).show();
                }else {
                    toogleWifiStatus(false);
                    Toast.makeText(getApplicationContext(), "Wi-Fi Mati", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void toogleWifiStatus (boolean statusWifi){
        WifiManager wifiManager = (WifiManager)this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (statusWifi == true && !wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(true);
        }else if (statusWifi == false && wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(false);
        }
    }
}
