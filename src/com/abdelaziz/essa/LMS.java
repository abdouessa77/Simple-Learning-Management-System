package com.abdelaziz.essa;

public class LMS extends FileOperations {

   final public static String filesPath= "D:\\Workspaces\\Training\\Java\\LMS\\src\\com\\abdelaziz\\essa\\res\\";
    public static void main(String[] st){
        LMS lm= new LMS();
        Student st1= new Student(1,filesPath,"output.CSV");
        String str= lm.textFileReader(filesPath,"student-data.txt");
         lm.fileWriter(filesPath,"output.CSV",str);
    System.out.println(str);
       lm.xmlReder(filesPath,"coursedata.xml");
        lm.printStudents(filesPath,"output.CSV");
        st1.isStudent();
    }
    public LMS() {
    }
}
