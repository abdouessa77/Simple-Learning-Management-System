package com.abdelaziz.essa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends FileOperations {
    private int stID;
    private static String filePath;
    private static String fieName;
    private static String studenCoursDB;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    private String studentName,studentGrade,studentEmail;

    public Student(String filePath, String fieName, String studenCoursDB) {
        this.filePath = filePath;
        this.fieName = fieName;
        this.studenCoursDB=studenCoursDB;

    }

    public int getStID() {
        return stID;
    }

    public void setStID(int stID) {
        if (stID <= 0)
            System.out.println("Invalid Student ID " + stID + " Should grater than 0");

        this.stID = stID;

    }
    public void printStudentData(int studentId)
    {
        setStID(studentId);
        if(isStudent())
        {
            System.out.println("====================================================================================");
            System.out.println("     Student Details page  ");
            System.out.println("====================================================================================");
            System.out.println("     Name: "+ getStudentName() +"   Grad: "+getStudentGrade()+"  Email "+getStudentEmail());
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("     Enrolled courses.  ");
            if(hasCourses())
            System.out.println("     Name: "+ getStudentName() +"   Grad: "+getStudentGrade()+"  Email "+getStudentEmail());
            else
                System.out.println("   This student hasn't enrolled in any courses");
            System.out.println("------------------------------------------------------------------------------------");


        }

    }
    private boolean hasCourses()
    {
        return true;
    }
public boolean isStudent()
{
  //  String[] stDb=this.textFileReader(filePath,fieName).split("\n");
    File sourceFile= new File(filePath+fieName);
    try {
        Scanner scr=new Scanner(sourceFile);
        int i =0;
        while (scr.hasNext()) {

            String[] data = scr.nextLine().split("\n");
            String[] row=data[0].split(",");

          //  for (int k = 0; k < row.length; k++) {
                if(i>0) // Scape header row
                if(Integer.parseInt(row[0])==getStID())
                {
                   setStudentName(row[1]);
                   setStudentGrade(row[2]);
                   setStudentEmail(row[3]);

                    scr.close();
                    return true;
                }

            //}
            i++;
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
//stDb.split("\n")

    System.out.println("The Entered number is not valid Student ID");
    return false;

}

    public void jsonReader() {
        String output = "";

        File sourceFile = new File(filePath + studenCoursDB);
        Scanner scr = null;
        try {
            scr = new Scanner(sourceFile);
            while (scr.hasNext()) {
                output += scr.nextLine();
            }
          String[] courses=  output.split(":");
            for(int i=0;i<courses.length;i++)
            {System.out.println(courses[i]);}


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            scr.close();
        }


    }
}

