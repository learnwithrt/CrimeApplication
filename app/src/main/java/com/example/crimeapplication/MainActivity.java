package com.example.crimeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager=getSupportFragmentManager();
        Fragment fragment=manager.findFragmentById(R.id.crime_container);
        if(fragment==null){//if no fragment is available
            fragment=new CrimeFragment();//Parent class reference can point to child class object
            //start a transaction
            FragmentTransaction transact=manager.beginTransaction();
            transact.add(R.id.crime_container,fragment);
            transact.commit();
        }
    }
}
