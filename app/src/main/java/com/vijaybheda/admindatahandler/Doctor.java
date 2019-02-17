package com.vijaybheda.admindatahandler;

class Doctor {
    private String name;
    private int doctorcode;

    public Doctor() {
        //empty constructor needed
    }

    public Doctor(String name, int doctorcode) {
        this.name = name;
        this.doctorcode = doctorcode;
    }

    public String getDrName() {
        return name;
    }

    public int getDrCode() {
        doctorcode=doctorcode+1;
        return doctorcode;
    }
}
