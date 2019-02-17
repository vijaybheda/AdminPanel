package com.vijaybheda.admindatahandler;

class FS {
    private String name;
    private int FSCode;

    public FS() {
        //empty constructor needed
    }

    public FS(String name, int FSCode) {
        this.name = name;
        this.FSCode = FSCode;
    }

    public String getName() {
        return name;
    }

    public int getFSCode() {
        FSCode=FSCode+1;
        return FSCode;
    }
}
