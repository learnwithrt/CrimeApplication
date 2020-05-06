package com.example.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    //List of crimes
    private List<Crime> mCrimeList;
    private static CrimeLab sCrimeLab;//I have s is because this is a static member
    //Class name
    //Create a public method for creating the object
    public static CrimeLab get(Context ctx){
        if(sCrimeLab==null){//That the single object doesn't exist
            sCrimeLab=new CrimeLab(ctx);
        }
        return sCrimeLab;//Don't create the object, just return the object
    }
    private CrimeLab(Context ctx){//I will tell that for which context is the CrimeLab object needed
        //create a new object of ArrayList
        mCrimeList=new ArrayList<>();
        //Initialize the list with crimes
        for(int i=1;i<=100;i++){
            Crime crime=new Crime();
            crime.setTitle("Crime No. "+i);
            crime.setSolved(i%2==0);//set alternate crimes as solved
            mCrimeList.add(crime);//ad the crime to the list
        }
    }
    public List<Crime> getCrimeList(){
        return mCrimeList;
    }
    //find a crime from the list
    public Crime findCrimeById(String id){
        for(Crime c:mCrimeList){
            if(c.getID().toString().equals(id)){
                return c;
            }
        }
        return null;//The crime with this ID doesn't exist
    }
    //find a crime from the list
    public Crime findCrimeByTitle(String title){
        for(Crime c:mCrimeList){
            if(c.getTitle().equals(title)){
                return c;//crime found
            }
        }
        return null;//The crime with this ID doesn't exist
    }
    //No other class can create an object of CrimeLab without get method
}
