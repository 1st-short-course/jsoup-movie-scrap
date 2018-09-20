package com.example.rany.moviescrapdemo;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate;
import com.akexorcist.localizationactivity.core.OnLocaleChangedListener;

import java.util.Locale;

public class MultilingualActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multilingual);
        Log.e("oooo", "onCreate: "+ getCurrentLanguage());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.eng:
                setLanguage("en");
                break;
            case R.id.kh:
                setLanguage("km");
                break;
            case R.id.ko:
                setLanguage("ko");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
