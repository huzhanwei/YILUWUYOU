package com.example.yiluwuyou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewFlipper;

public class HomepageActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        viewFlipper=(ViewFlipper)this.findViewById(R.id.home_vflipper);
        viewFlipper.startFlipping();
    }
}
