package com.myrssreader;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by Tong on 2015/11/21.
 */
public class ActionBarActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
