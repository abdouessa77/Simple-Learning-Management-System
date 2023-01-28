package com.abdelaziz.essa;

import java.io.File;

public class LMS extends FileOperations {

  // final public static String filesPath= "D:\\Workspaces\\Training\\Java\\LMS\\src\\com\\abdelaziz\\essa\\res\\";
    final public static String filesPath= new File("").getAbsolutePath().concat("\\src\\com\\abdelaziz\\essa\\res\\");
    public static void main(String[] st){
        LMS lm= new LMS();




        String str= lm.textFileReader(filesPath,"student-data.txt");
         lm.fileWriter(filesPath,"output.CSV",str);
    System.out.println(str);
       lm.xmlReder(filesPath,"coursedata.xml");
        lm.printStudents(filesPath,"output.CSV");

        Student st1= new Student(filesPath,"output.CSV","Student_course_details.json");
       //st1.setStID(101);
       st1.printStudentData(1);
     //  st1.addStudentCourse(4,2);
     //   st1.removeStudentCourse(4,2);
        st1.switchStudentCourse(1,3,7);
    }
    public LMS() {
    }
}
