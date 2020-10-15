package model;

import java.io.Serializable;

public class PhoneNumberList implements Serializable {
    String phoneNumber;
    String phoneNumberGroup;
    String name;
    String gender;
    String address;
    String birthday;
    String email;

    public PhoneNumberList() {
    }

    public PhoneNumberList(String phoneNumber, String phoneNumberGroup, String name, String gender, String address,
                           String birthday, String email) {
        this.phoneNumber = phoneNumber;
        this.phoneNumberGroup = phoneNumberGroup;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberGroup() {
        return phoneNumberGroup;
    }

    public void setPhoneNumberGroup(String phoneNumberGroup) {
        this.phoneNumberGroup = phoneNumberGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "phoneNumberList{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", phoneNumberGroup='" + phoneNumberGroup + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
