package com.example.crimeapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Crime;
import com.example.model.CrimeLab;

import java.util.List;

public class CrimeListFragment extends Fragment {
    //Implementation for CrimeListFragment
    private RecyclerView mCrimeRecycler;
    private CrimeViewAdapter mCrimeViewAdapter;
    //An object for storing crime information before being shown on the views
    private Crime mCrime;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.crime_list_fragment,container,false);
        mCrimeRecycler=view.findViewById(R.id.crime_list_recycler);
        mCrimeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUserInterface();//method is responsible for providing adapter to the recycler view
        return view;
    }

    private void updateUserInterface() {
        //I need an object of CrimeLab
        CrimeLab lab= CrimeLab.get(getActivity());
        //I need the list of crimes
        List<Crime> crimes=lab.getCrimeList();
        //Provide adapter to the recycler view
        mCrimeViewAdapter=new CrimeViewAdapter(crimes);
        mCrimeRecycler.setAdapter(mCrimeViewAdapter);
    }

    private class CrimeViewHolder extends RecyclerView.ViewHolder{
        private TextView mTitle;
        private TextView mDate;
        private ImageView mCrimeSolved;
        public CrimeViewHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime,parent,false));
            mTitle=itemView.findViewById(R.id.crime_title_view);
            mDate=itemView.findViewById(R.id.crime_date_view);
            mCrimeSolved=itemView.findViewById(R.id.solved_image);
        }
        //method which is supposed to be called everytime binding is required
        public void bind(Crime crime){
            mCrime=crime;
            mTitle.setText(crime.getTitle());
            mDate.setText(crime.getCrimeDate().toString());
            //change the image
            if(!mCrime.isSolved()){//check if the crime is NOT solved
                mCrimeSolved.setImageResource(R.mipmap.unsolved_icon_foreground);
            }
        }
    }
    private class CrimeViewAdapter extends  RecyclerView.Adapter<CrimeViewHolder>{
        private List<Crime> mCrimes;
        public CrimeViewAdapter(List<Crime> crimes){
            mCrimes=crimes;
        }

        @NonNull
        @Override
        public CrimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=LayoutInflater.from(getActivity());
            return new CrimeViewHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeViewHolder holder, int position) {
            //responsible for binding the data to the view holder
            //get the index of crime
            Crime crime=mCrimes.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount() {
            //size of the list
            return mCrimes.size();//NUmber of items in the list
        }
    }
}
