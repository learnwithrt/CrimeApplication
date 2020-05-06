package com.example.crimeapplication;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;


public class MainActivity extends SingleFragmentActivity {

    //I want to add information
    // Extras- contain the information
    public static final String CRIME_ID="com.example.Crime.crime_id";
    public static Intent newIntent(Context context, String crimeId){
        Intent intent=new Intent(context,MainActivity.class);
        intent.putExtra(CRIME_ID,crimeId);
        return intent;
    }
    @Override
    protected Fragment createFragment() {
        //which fragment is supposed to be created
        //return new CrimeFragment();
        String crime=getIntent().getExtras().getString(MainActivity.CRIME_ID);
        return CrimeFragment.createInstance(crime);
    }
}
