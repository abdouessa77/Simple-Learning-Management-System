package com.abdelaziz.essa;

import java.io.File;
import java.util.Scanner;

public class LMS extends Student {

  // final public static String filesPath= "D:\\Workspaces\\Training\\Java\\LMS\\src\\com\\abdelaziz\\essa\\res\\";
    final public static String filesPath=new File("").getAbsolutePath().concat("\\src\\com\\abdelaziz\\essa\\res\\");
    public static void main(String[] st){
        LMS lm= new LMS();

        //System.out.println(str);
// Preparing the students and courses data

        String str= lm.textFileReader(filesPath,"student-data.txt");
         lm.fileWriter(filesPath,"output.CSV",str);
        lm.xmlReder(filesPath,"coursedata.xml");
        String menu2="\nPlease make one of the following:\nEnter the course id that you want to enroll the student to\nEnter b to go back to the home page\nPlease select the required action:";
        String menu1="\n Please choose from the following:\na - Enroll in a course\nd - Unenrollfrom an existing course \nr - Replacing an existing course\nb - Back to the main page\nplease select the required action:";
      //  String menu3="\nPlease make one of the following:\nEnter the course id that you want to Unenroll from  the student to\nEnter b to go back to the home page\nPlease select the required action:";

        //System.out.println(str);
        System.out.println("\n\n Welcome to LMS ");
        System.out.println(" Created by Abd Elaziz Mahmoud Essa_ 21-1-2023");
        System.out.println("====================================================================================");
        System.out.println(" Home page");
        System.out.println("====================================================================================");
       lm.printStudents(filesPath,"output.CSV");
        Student st1= new Student(filesPath,"output.CSV","Student_course_details.json");
        System.out.println(" Please select the required student: ");
        Scanner scr=new Scanner(System.in);
        st1.printStudentData(Integer.parseInt(scr.next()));
        System.out.println(menu1);

        String chr="";
        chr=scr.next();


        switch(chr)
        {
            case "a":
                System.out.println(" Enrollment page");
                System.out.println("====================================================================================");
                System.out.println(" Courses List");
                System.out.println("------------------------------------------------------------------------------------1");
                st1.printCoursesList();
              //  lm.printStudents(filesPath,"output.CSV");

                System.out.println(menu2);

                if(st1.addStudentCourse(st1.getStID(), Integer.parseInt(scr.next())))
                    System.out.println("The student is Enrolled Successfully in the  course");
                System.out.println(menu2);
                scr.next();
                break;
            case "d":
                System.out.println(" Enrollment page");
                System.out.println("====================================================================================");
                System.out.println(" Courses List");
                System.out.println("------------------------------------------------------------------------------------1");
                st1.printCoursesList();
                System.out.println(menu2);

                st1.removeStudentCourse(st1.getStID(), Integer.parseInt(scr.next()));
                st1.printStudentData(st1.getStID());
                System.out.println(menu1);
                scr.next();
                break;
            case "r":
                System.out.println(" Enrollment page");
                System.out.println("====================================================================================");
                System.out.println(" Courses List");
                System.out.println("------------------------------------------------------------------------------------1");
                st1.printCoursesList();
                System.out.println(menu2);

                st1.switchStudentCourse(st1.getStID(), Integer.parseInt(scr.next()),Integer.parseInt(scr.next()));
                st1.printStudentData(st1.getStID());
                System.out.println(menu1);
                scr.next();
                break;

            default:
                System.out.println(menu1);
        }

     //  st1.addStudentCourse(4,2);
     //   st1.removeStudentCourse(4,2);
      //  st1.switchStudentCourse(1,3,7);
        scr.close();


    }
    private void homePage()
    {}
    public LMS() {
    }
}
