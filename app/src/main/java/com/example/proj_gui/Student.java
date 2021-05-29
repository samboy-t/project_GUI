package com.example.proj_gui;

public class Student {
    private int id;
    private String studentName;
    private String studentMobile;
    private String studentEmail;
    private int itemID;
    private int studentQuantity;

    public Student(){

    }

//    public Student(int id, String studentName, String studentMobile, String studentEmail) {
//        this.id = id;
//        this.studentName = studentName;
//        this.studentMobile = studentMobile;
//        this.studentEmail = studentEmail;
//    }

    public Student(String studentName, String studentEmail, String studentMobile, int itemID, int studentQuantity) {
        this.studentName = studentName;
        this.studentMobile = studentMobile;
        this.studentEmail = studentEmail;
        this.itemID = itemID;
        this.studentQuantity = studentQuantity;
    }

//    public Student(String studentName, String studentEmail) {
//        this.studentEmail = studentEmail;
//        this.studentName = studentName;
//    }

    public void setID(int id){
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentMobile() {
        return this.studentMobile;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentEmail() {
        return this.studentEmail;
    }

    public void setItemID(int itemID) {this.itemID = itemID;}

    public int getItemID() {return this.itemID;}

    public void setStudentQuantity(int studentQuantity) {this.studentQuantity = studentQuantity;}

    public int getStudentQuantity() {return this.studentQuantity;}
}

