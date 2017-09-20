package com.examples.tylerhopkins.hopkinsapp;

import io.realm.RealmObject;

/**
 * Created by Tyler Hopkins on 9/18/2017.
 */

public class Vote extends RealmObject {

    private User owner;
    private int rating;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
