package com.example.indrabhurtel.first_screen;

public class Artist {

    String NameID;
    String UserName;

    public Artist() {

    }

    public Artist(String nameID, String userName) {
        NameID = nameID;
        UserName = userName;
    }

    public String getNameID() {
        return NameID;
    }

    public String getUserName() {
        return UserName;
    }
}


