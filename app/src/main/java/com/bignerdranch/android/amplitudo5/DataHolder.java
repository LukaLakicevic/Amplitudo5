package com.bignerdranch.android.amplitudo5;

public class DataHolder {

    private String Email;
    private String Password;
    public static DataHolder holder = new DataHolder();


    public DataHolder() {

    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public static DataHolder getInstance() { return holder; }
}
