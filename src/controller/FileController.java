package controller;

import model.PhoneNumberList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    public static ArrayList<PhoneNumberList> readPhoneNumberListFromFile(String phoneNumberlistFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(phoneNumberlistFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object phoneList = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return (ArrayList<PhoneNumberList>) phoneList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writePhoneNumberListToFile(ArrayList<PhoneNumberList> phoneNumberLists, String phoneNumberlistFile) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(phoneNumberlistFile);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(phoneNumberLists);
            outputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
