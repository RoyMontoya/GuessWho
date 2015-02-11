package com.example.amado.guesswho;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Amado on 31/01/2015.
 */
public class Person {
    private String mName;
    private String mSkin;
    private String mBody;
    private String mFace;
    private int mImage;
    private static ArrayList<Person> sPersons;


    public Person(){

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getFace() {
        return mFace;
    }

    public void setFace(String face) {
        mFace = face;
    }

    public String getSkin() {
        return mSkin;
    }

    public void setSkin(String skin) {
        mSkin = skin;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public static void CreatePersons(){
        sPersons =new ArrayList<Person>();
        sPersons.add(new Person());
        sPersons.get(0).setName("Daniel");
        sPersons.get(0).setSkin("Mild");
        sPersons.get(0).setBody("Skinny");
        sPersons.get(0).setFace("Sharp");
        sPersons.get(0).setImage(R.drawable.daniel);
        sPersons.add(new Person());
        sPersons.get(1).setName("Paul");
        sPersons.get(1).setSkin("White");
        sPersons.get(1).setBody("Muscle");
        sPersons.get(1).setFace("Normal");
        sPersons.get(1).setImage(R.drawable.paul);
        sPersons.add(new Person());
        sPersons.get(2).setName("Ele");
        sPersons.get(2).setSkin("Mild");
        sPersons.get(2).setBody("Fit");
        sPersons.get(2).setFace("Bold");
        sPersons.get(2).setImage(R.drawable.ele);
        sPersons.add(new Person());
        sPersons.get(3).setName("Manuel");
        sPersons.get(3).setSkin("Black");
        sPersons.get(3).setBody("Muscle");
        sPersons.get(3).setFace("Normal");
        sPersons.get(3).setImage(R.drawable.manuel);
        sPersons.add(new Person());
        sPersons.get(4).setName("Jaime");
        sPersons.get(4).setSkin("Black");
        sPersons.get(4).setBody("Fit");
        sPersons.get(4).setFace("Bold");
        sPersons.get(4).setImage(R.drawable.jaime);
        sPersons.add(new Person());
        sPersons.get(5).setName("Roy");
        sPersons.get(5).setSkin("Mild");
        sPersons.get(5).setBody("Fit");
        sPersons.get(5).setFace("Normal");
        sPersons.get(5).setImage(R.drawable.roy);

    }

    public static ArrayList<Person> getPersons() {
        return sPersons;
    }
}
