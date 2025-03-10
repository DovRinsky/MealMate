package com.example.mealmate;

import java.io.Serializable;

public class Meal implements Serializable {

    private int Avatar;
    private String Name;
    private String Description;


    public Meal(String name, int avatar, String description) {
        Name = name;
        Avatar = avatar;
        Description = description;
    }

    public int getAvatar() {
        return Avatar;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }
}
