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
import com.example.model.CrimeLab;

import java.util.UUID;

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleText;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;
    private static final String ARG_CRIME_ID="crime_id";
    //Add arguments when the object of crime fragment is created
    public static CrimeFragment createInstance(String crimeId){
        Bundle args=new Bundle();
        args.putString(ARG_CRIME_ID,crimeId);

        CrimeFragment fragment=new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//onCreate method of super class
        String title=getArguments().getString(ARG_CRIME_ID);
        //instantiate an object of Crime
        //mCrime=new Crime();//Default constructor
        mCrime= CrimeLab.get(getActivity()).findCrimeByTitle(title);
        //find the crime with this title
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
        mTitleText.setText(mCrime.getTitle());
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
        mSolvedCheckbox.setChecked(mCrime.isSolved());
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
