package com.rogerlemmonapps.testprofilerapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Main extends Activity {
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = getSharedPreferences("TestAppPrefs", Context.MODE_PRIVATE);
        if(!prefsSet()){
            setPref(0);
        }
        setContentView(R.layout.activity_main);
        TextView num = ((TextView)this.findViewById(R.id.number));
        if(num!=null){
            String number = getPref() + "";
            num.setText(number);
        }
    }

    private boolean prefsSet(){
        return settings.contains("Number");
    }

    private void setPref(int num){
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("Number", num);
        editor.commit();
    }

    private int getPref(){
        return settings.getInt("Number", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            int number = getPref();
            setPref(number+1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
