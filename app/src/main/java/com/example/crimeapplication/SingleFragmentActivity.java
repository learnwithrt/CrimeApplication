package com.example.crimeapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

//It will hold the code which we will need for every fragment in our application
//generic superclass for all of my fragments
//Abstract classes/ interfaces can hold abstract methods
public abstract class SingleFragmentActivity extends AppCompatActivity {
    //abstract method-> method without definition(method body)
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager=getSupportFragmentManager();
        Fragment fragment=manager.findFragmentById(R.id.crime_container);
        if(fragment==null){//if no fragment is available
            //change the implementation of createFragment to tell
            // Fragment of which class should be created
            fragment=createFragment();//Parent class reference can point to child class object
            //start a transaction
            FragmentTransaction transact=manager.beginTransaction();
            transact.add(R.id.crime_container,fragment);
            transact.commit();
        }
    }
}
