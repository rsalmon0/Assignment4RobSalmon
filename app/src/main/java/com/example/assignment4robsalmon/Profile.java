/*
   Assignment 2
   Assignment_2_Dylan_Sperry
   Group 20: Dylan Sperry, Robert Salmon
*/

package com.example.assignment4robsalmon;

import java.io.Serializable;

public class Profile implements Serializable {
    String name, age, moodNum;

    public Profile(String name, String age, String moodNum) {
        this.name = name;
        this.age = age;
        this.moodNum = moodNum;
    }

    public Profile(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMoodNum() {
        return moodNum;
    }

    public void setMoodNum(String moodNum) {
        this.moodNum = moodNum;
    }
}
