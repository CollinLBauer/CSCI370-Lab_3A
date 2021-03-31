package com.example.advancedadapterlab;

// It's pronounced POJO
public class Student {

    private String firstName;
    private String lastName;
    private String major;

    public Student(String first,String last,String m) {
        firstName = first;
        lastName = last;
        major = m;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }
}
