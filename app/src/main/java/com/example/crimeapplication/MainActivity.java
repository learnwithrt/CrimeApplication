package com.example.crimeapplication;

import androidx.fragment.app.Fragment;


public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        //which fragment is supposed to be created
        return new CrimeFragment();
    }
}
