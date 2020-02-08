package com.example.nutritionscanner.api;

import com.example.nutritionscanner.NutritionScannerUsers.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class UserAPI {
    /**
     * Adds or updates the user to database
     * @param user Takes in user object
     */
    public void addUser(User user){
        try {
            FileOutputStream fileOut = new FileOutputStream("NutritionScanner");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(user);
            outputStream.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns saved user object from the database
     * @return user object
     */
    public User readUser(){
        try {
            FileInputStream fis = new FileInputStream("NutritionScanner");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User)ois.readObject();
            ois.close();
            fis.close();
            return user;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

