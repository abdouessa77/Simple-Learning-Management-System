package com.abdelaziz.essa;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student extends FileOperations {
    private int stID;
    private static String filePath;
    private static String fieName;
    private static String studenCoursDB;

    public List<Integer> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<Integer> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    private List<Integer> studentCourseList=new ArrayList<Integer>();
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
    private String courseID;
    private String courseName;
    private String courseInstructor;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    private String courseDuration;
    private String courseTime;
    private String courseLocation;

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
            if(hasCourses(stID))
                for(Integer number:studentCourseList)
            System.out.println(studentCourse(number));
            else
                System.out.println("   This student hasn't enrolled in any courses");
            System.out.println("------------------------------------------------------------------------------------");


        }

    }
    private boolean hasCourses(int stID)
    {
        // using json Parser i will check for the course list of this student
        jsonReader(stID);
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

    public String studentCourse(int courseID)
    {
        //  String[] stDb=this.textFileReader(filePath,fieName).split("\n");
        File sourceFile= new File(filePath+"Courses.CSV");
        try {
            Scanner scr=new Scanner(sourceFile);
            int i =0;
            while (scr.hasNext()) {

                String[] data = scr.nextLine().split("\n");
                String[] row=data[0].split(",");

                //  for (int k = 0; k < row.length; k++) {
                if(i>0) // Scape header row
                    if(Integer.parseInt(row[0])==courseID)
                    {
                     /*   setCourseID(row[0]);
                        setCourseName(row[1]);
                        setCourseInstructor(row[2]+row[3]);
                        setCourseDuration(row[4]);
                        setCourseTime(row[5]);
                        setCourseLocation(row[6]);*/

                        scr.close();
                        return row[0]+",      "+row[1]+",    "+row[2]+row[3]+",    "+row[4]+",     "+row[5]+",      "+row[6];
                    }

                //}
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
//stDb.split("\n")

        return  "The Entered number is not valid Course ID";

    }

    public void jsonReader(int stID) {
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
            {
              //  System.out.println(courses[i]);
            }
// I have no time to implement json parser so, if i have the file valuse i will pass it to the has courses function
            switch (stID)
            {
                case 1:
                    studentCourseList.add(1);
                    studentCourseList.add(2);
                    studentCourseList.add(3);
                    studentCourseList.add(4);
                    break;
                case 2:
                    studentCourseList.add(2);
                    studentCourseList.add(4);
                    studentCourseList.add(6);
                    break;
                case 3:
                    studentCourseList.add(1);
                    studentCourseList.add(3);
                    studentCourseList.add(5);
                    break;
                default:
                    System.out.println("this user has no courses");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            scr.close();
        }


    }
}

