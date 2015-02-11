package com.example.amado.guesswho;

import java.util.ArrayList;

/**
 * Created by Amado on 31/01/2015.
 */
public class Guess{

    public static String sName;
    public static String sSkin;
    public static String sBody;
    public static String sFace;
    public static int sImage;

    public static String getName() {
        return sName;
    }

    public static void setName(String name) {
        sName = name;
    }

    public static String getFace() {
        return sFace;
    }

    public static void setFace(String face) {
        sFace = face;
    }

    public static String getSkin() {
        return sSkin;
    }

    public static void setSkin(String skin) {
        sSkin = skin;
    }

    public static String getBody() {
        return sBody;
    }

    public static void setBody(String body) {
        sBody = body;
    }

    public static int getImage() {
        return sImage;
    }

    public static void setImage(int image) {
        sImage = image;
    }
    public static void clearGuess(){
        setImage(0);
        setName("");
        setBody("");
        setFace("");
        setSkin("");
    }
}
