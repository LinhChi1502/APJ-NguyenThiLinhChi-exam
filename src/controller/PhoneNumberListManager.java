package controller;

import model.PhoneNumberList;

import java.util.ArrayList;

public class PhoneNumberListManager {
    public static ArrayList<PhoneNumberList> phoneNumberLists = new ArrayList<>();

    public static void showList() {
        for (PhoneNumberList phoneNumberList: phoneNumberLists) {
            System.out.println(phoneNumberList);
        }
    }

    public static void add(PhoneNumberList phoneNumberList) {
        phoneNumberLists.add(phoneNumberList);
    }

    public static boolean checkIsPhoneNumberExist(String phoneNumber) {
        for (PhoneNumberList phoneNumberList : phoneNumberLists) {
            if (phoneNumberList.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public static void edit(String phoneNumber, String phoneNumberGroup, String name, String gender, String address,
                            String birthday, String email) {
        for (PhoneNumberList phoneNumberList: phoneNumberLists) {
            if (phoneNumberList.getPhoneNumber().equals(phoneNumber)) {
                phoneNumberList.setPhoneNumberGroup(phoneNumberGroup);
                phoneNumberList.setName(name);
                phoneNumberList.setGender(gender);
                phoneNumberList.setAddress(address);
                phoneNumberList.setBirthday(birthday);
                phoneNumberList.setEmail(email);
            }
        }
    }

    public static void delete(String phoneNumber) {
        for (PhoneNumberList phoneNumberList: phoneNumberLists) {
            if (phoneNumberList.getPhoneNumber().equals(phoneNumber)) {
                phoneNumberLists.remove(phoneNumberList);
            }
        }
    }

    public static void searchByName(String name) {
        boolean isNameExist = false;
        for (PhoneNumberList phoneNumberList: phoneNumberLists) {
            String nameToSearch = phoneNumberList.getName().toLowerCase();
            if (nameToSearch.contains(name)) {
                isNameExist = true;
                System.out.println(phoneNumberList);
            }
        }
        if (!isNameExist) {
            System.err.println("Không tìm được tên này");
        }
    }

    public static void searchByPhoneNum(String phoneNumber) {
        boolean isPhoneExist = false;
        for (PhoneNumberList phoneNumberList: phoneNumberLists) {
            String phoneToSearch = phoneNumberList.getPhoneNumber();
            if (phoneToSearch.equals(phoneNumber)) {
                isPhoneExist = true;
                System.out.println(phoneNumberList);
            }
        }
        if (!isPhoneExist) {
            System.err.println("Không tìm được số điện thoại này");
        }
    }
}
