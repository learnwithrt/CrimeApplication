package com.example.model;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mCrimeDate;
    private boolean mSolved;
    //Getters and Setters and a constructor

    public Crime() {
        //I will assign the Unique UUID
        mID=UUID.randomUUID();//get a random UUID
        //get the current Date
        mCrimeDate=new Date();//your local date
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getCrimeDate() {
        return mCrimeDate;
    }

    public void setCrimeDate(Date crimeDate) {
        mCrimeDate = crimeDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
