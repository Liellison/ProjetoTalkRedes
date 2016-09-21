package com.liellison.projetotalkredes;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends Activity {
    private TableLayout tabLayout;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TableLayout) findViewById(R.id.tabLayout);

    }


}
