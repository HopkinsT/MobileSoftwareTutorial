package com.examples.tylerhopkins.hopkinsapp;


import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Tyler Hopkins on 9/13/2017.
 */

public class Bulldog extends RealmObject {
    private String id;
    private String name;
    private String age;
    public RealmList<Vote> votes;
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Bulldog()
    {
        name = "Generic Dog";
        age = "NULL";
        image = null;
        id = null;
    }

     public Bulldog(String name, String age, String id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
        image = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<Vote> getVotes() {
        return votes;
    }

    public void setVotes(RealmList<Vote> votes) {
        this.votes = votes;
    }

    public void appendVotes(Vote vote)
    {
        this.votes.add(vote);
    }
}
