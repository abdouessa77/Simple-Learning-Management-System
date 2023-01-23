package com.abdelaziz.essa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends FileOperations {
    private int stID;
    private static String filePath;
    private static String fieName;
    public Student(int stID, String filePath, String fieName) {
        this.stID = stID;
        this.filePath = filePath;
        this.fieName = fieName;
    }

    public int getStID() {
        return stID;
    }

    public void setStID(int stID) {
        if (stID <= 0)
            System.out.println("Invalid Student ID " + stID + " Should grater than 0");
        this.stID = stID;
    }
public boolean isStudent()
{
  //  String[] stDb=this.textFileReader(filePath,fieName).split("\n");
    File sourceFile= new File(filePath+fieName);
    try {
        Scanner scr=new Scanner(sourceFile);
       // int i =0;
        while (scr.hasNext()) {

            String[] data = scr.nextLine().split(",");

            for (int i = 0; i < data.length; i++) {
                int stId;
                try {
                    stId = Integer.parseInt(data[0]);
                }
                catch (NumberFormatException e) {
                    stId = 0;
                }
                if ( stId == stID) {
                    System.out.print("The studint ID is " + data[0]);
                    //return true;
                }

            }
            System.out.print("\n");
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
//stDb.split("\n")


    return true;

}
    public void jsonReader(String filePath, String fileName) {
        String output = "";
        File sourceFile = new File(filePath + fileName);
        Scanner scr = null;
        try {
             scr = new Scanner(sourceFile);
            while (scr.hasNext()) {
                String data = scr.nextLine();



            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            scr.close();
        }


    }
}
