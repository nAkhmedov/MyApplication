package com.example.ulugbek.myapplication.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ulugbek.myapplication.R;
import com.example.ulugbek.myapplication.fragment.ProgressDialogFragment;

/**
 * Created by Ulugbek on 09.02.2015.
 */
public class BaseActivity extends ActionBarActivity {

    protected ProgressDialogFragment progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (progressDialog == null) {
            progressDialog = new ProgressDialogFragment();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home: break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void showDialog() {
        progressDialog.show(getSupportFragmentManager(), "progress");

    }

    protected void dismissDialog(){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("progress");
        if (fragment != null) {
            ((ProgressDialogFragment) fragment).dismiss();
        }
    }
}
