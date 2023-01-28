package com.abdelaziz.essa;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Student extends FileOperations {
    private int stID;
    private static String filePath;
    private static String fieName;
    private static String studenCoursDB;

    public Student() {

    }

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
    public boolean isStudent(int stID)
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
                    if(Integer.parseInt(row[0])==stID)
                    {

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
    public void printCoursesList()
    {
        //  String[] stDb=this.textFileReader(filePath,fieName).split("\n");
        File sourceFile= new File(filePath+"Courses.CSV");
        try {
            Scanner scr=new Scanner(sourceFile);
            int i =0;
            while (scr.hasNext()) {

                String[] data = scr.nextLine().split("\n");
                System.out.println(data[0]);
                //}
                i++;
            }
            scr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isStudentCourse(int courseID)
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
        System.out.println("The Entered number "+ courseID+" is not valid Course ID");
        return  false;

    }
    public void jsonReader(int stID) {


        try {
            File sourceFile = new File(filePath + studenCoursDB);
            //==================== //
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(sourceFile));
            JSONObject jsonObject = (JSONObject) obj;
            //jsonObject.get("");
            Iterator<String> keys = jsonObject.keySet().iterator();

            while (keys.hasNext()) {
                String key = keys.next();
                if (Integer.parseInt(key) == stID) {
                    // this student is exist
                    studentCourseList.clear();
                    if (jsonObject.get(key) instanceof JSONArray) {
                        JSONArray arr = (JSONArray) jsonObject.get(key);
                        for (int i = 0; i < arr.size(); i++) {
                            studentCourseList.add(Integer.parseInt(arr.get(i).toString()));

                        }
                    }
                return;
                }

            }
            System.out.println("this Student has no courses");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }


    }

    public boolean addStudentCourse(int stID, int courseId)
    {
        if(isStudent(stID) && isStudentCourse(courseId)) {
            try {
                File sourceFile = new File(filePath + studenCoursDB);
                //==================== //
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(sourceFile));
                JSONObject jsonObject = (JSONObject) obj;
                //jsonObject.get("");
                Iterator<String> keys = jsonObject.keySet().iterator();

                while (keys.hasNext()) {
                    String key = keys.next();
                    if (Integer.parseInt(key) == stID) {
                        // this student is exist

                        if (jsonObject.get(key) instanceof JSONArray) {
                            JSONArray arr = (JSONArray) jsonObject.get(key);


                        for (int i = 0; i < arr.size(); i++) {
                            if (Integer.parseInt(arr.get(i).toString())==courseId) {
                                System.out.println("The student is already enrolment in this course");
                                return false;
                            }
                            if(i>=5) {
                                System.out.println("The student has maximum number of course");
                                return false;
                            }
                        }
                            ((JSONArray) jsonObject.get(key)).add(arr.size(), courseId);
                            fileWriter(filePath, studenCoursDB, jsonObject.toJSONString());
                        }
                        return true;
                    }

                }

                System.out.println("this Student has no courses");
                JSONArray ob= new JSONArray();
                ob.add(0,courseId);
                jsonObject.put(stID,ob);
                fileWriter(filePath, studenCoursDB, jsonObject.toJSONString());
               return true;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }

return false;

    }


    public boolean removeStudentCourse(int stID, int courseId)
    {
        if(isStudent(stID) && isStudentCourse(courseId)) {
            try {
                File sourceFile = new File(filePath + studenCoursDB);
                //==================== //
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(sourceFile));
                JSONObject jsonObject = (JSONObject) obj;
                //jsonObject.get("");
                Iterator<String> keys = jsonObject.keySet().iterator();

                while (keys.hasNext()) {
                    String key = keys.next();
                    if (Integer.parseInt(key) == stID) {
                        // this student is exist

                        if (jsonObject.get(key) instanceof JSONArray) {
                            JSONArray arr = (JSONArray) jsonObject.get(key);
                            for (int i = 0; i < arr.size(); i++) {
                                        if (Integer.parseInt(arr.get(i).toString())==courseId) {
                                           if(i!=0) {
                                               ((JSONArray) jsonObject.get(key)).remove(i);
                                               fileWriter(filePath, studenCoursDB, jsonObject.toJSONString());
                                               System.out.println("The course is removed from enrolment successfully");
                                               return true;
                                           } else {
                                               System.out.println("The course can not removed from enrolment where this student has only this course");
                                               return false;
                                           }

                                                }
                                           }
                                        }
                        System.out.println("This student is not registered in this course");
                        return false;
                    }

                }

                System.out.println("this Student has no courses");


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }

        }

        return false;

    }

    public void switchStudentCourse(int stID, int course1Id, int course2Id )
    {
        if(isStudent(stID) && isStudentCourse(course1Id)) {
            try {
                File sourceFile = new File(filePath + studenCoursDB);
                //==================== //
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(new FileReader(sourceFile));
                JSONObject jsonObject = (JSONObject) obj;
                //jsonObject.get("");
                Iterator<String> keys = jsonObject.keySet().iterator();

                while (keys.hasNext()) {
                    String key = keys.next();
                    if (Integer.parseInt(key) == stID) {
                        // this student is exist

                        if (jsonObject.get(key) instanceof JSONArray) {
                            JSONArray arr = (JSONArray) jsonObject.get(key);
                            for (int i = 0; i < arr.size(); i++) {
                                if (Integer.parseInt(arr.get(i).toString())==course1Id) {
                                    if(i!=0) {
                                        ((JSONArray) jsonObject.get(key)).remove(i);
                                        fileWriter(filePath, studenCoursDB, jsonObject.toJSONString());
                                        addStudentCourse(stID,course2Id);
                                        System.out.println("The course "+course1Id+" and "+course2Id+" are Switched successfully");
                                        return;
                                    } else {
                                        System.out.println("The course can not removed from enrolment where this student has only this course");
                                        return;
                                    }

                                }
                            }
                        }
                        System.out.println("This student is not registered in this course");
                        return;
                    }

                }

                System.out.println("this Student has no courses");


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }


    }
}

