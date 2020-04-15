package com.example.crimeapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.model.Crime;

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleText;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//onCreate method of super class
        //instantiate an object of Crime
        mCrime=new Crime();//Default constructor
        //Random ID//id
        //Current Date//date
    }
    //onCreateView -> inflate(show) the fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        //v-> contains the fragment
        v=inflater.inflate(R.layout.crime_fragment,container,false);
        //attachToRoot is false because we will add the fragment to the activity using fragment manager ourselves
        mTitleText=v.findViewById(R.id.crime_title);
        mTitleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //what to do before the text is changed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //what to do when the text is changed
                mCrime.setTitle(s.toString());//set the title of the crime
            }

            @Override
            public void afterTextChanged(Editable s) {
                //waht to do after the text has been changed already
            }
        });
        mSolvedCheckbox=v.findViewById(R.id.solved_check);
        mSolvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);//set if the crime is solved already
            }
        });
        mDateButton=v.findViewById(R.id.date_button);
        mDateButton.setText(mCrime.getCrimeDate().toString());
        mDateButton.setEnabled(false);
        return v;
    }
}
