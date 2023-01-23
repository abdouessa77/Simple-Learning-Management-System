package com.abdelaziz.essa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileOperations {
        public FileOperations() {
    }
public String textFileReader(String filePath, String fileName)
    {
        String output="";
        File sourceFile= new File(filePath+fileName);
        //Scanner scr=new Scanner();
       // final String coloneSimpole ="|";
        try {
            Scanner scr= new Scanner(sourceFile);
             while (scr.hasNext()){

                 String data = scr.nextLine().replace("#", ",");
                // data= data.replace("#", ",");
                 data= data.replace("$","\n");
                 String[] newData=data.split("\n");

                 for (int i = 0; i < newData.length; i++) {
                     if(i==0)
                     {
                         output+="ID ,"+ newData[i];
                     }else {
                         output+="\n"+i+","+ newData[i];
                     }
                 }
             }
            scr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {

        }
        return output;
    }
    public void fileWriter(String filePath, String fileName, String outPut)
    {
        byte[] b=outPut.getBytes();
        FileOutputStream fo=null;

        try {
            fo=new FileOutputStream(filePath+fileName);
            fo.write(b);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    /*******************************************/

public void xmlReder(String filePath, String fileName)
{
    try {
preparerXml(filePath, fileName);
        File root = new File(filePath+fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(root);
        doc.getDocumentElement().normalize();

        NodeList nodes = doc.getElementsByTagName("row");

        String headerData="", finalData ="", outPut= "";

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            NodeList childNodes = node.getChildNodes();
            for (int k = 0; k < childNodes.getLength(); k++) {
                Node childNode = childNodes.item(k);
                if(k%2 !=0) {
                    if (i == 0 && k % 2 != 0) {
                                    headerData += childNode.getNodeName() + ", ";
                                }
                            finalData += childNode.getTextContent() + ", ";
                        }
            }
            finalData=finalData+"\n";
        }
        outPut=headerData.replace("_"," ") +"\n"+finalData;
        System.out.println(outPut);
        fileWriter(filePath,"Courses.CSV", outPut);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
       private void preparerXml(String filePath, String fileName){

        String output="";
        File sourceFile= new File(filePath+fileName);
        //Scanner scr=new Scanner();
        try {
            Scanner scr= new Scanner(sourceFile);
            while (scr.hasNext()) {
                String data = scr.nextLine().replace("Course Name", "Course_Name");
                data = data.replace("Course duration", "Course_duration");
                data = data.replace("Course time", "Course_time");
                output+=data+"\n";
            }
                scr.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }finally {

            }
        fileWriter(filePath,fileName,output);
       // return output;
    }
    /*******************************/
    public void  printStudents(String filePath, String fileName)
    {
        String output="";
        File sourceFile= new File(filePath+fileName);
        //Scanner scr=new Scanner();
        try {
            Scanner scr= new Scanner(sourceFile);
            System.out.println("-------------------------------");
            System.out.println("      Current Student List     ");
            System.out.println("-------------------------------");
            int i=0;
            while (scr.hasNext()){
                String data = scr.nextLine();
                String[] dataRows=data.split("\n");

               // System.out.println(dataRows.length);
              //  for (int i = 0; i < dataRows.length; i++) {
                    String[] row=dataRows[0].split(",");
                    String filed="";
                    int j=row.length,l=j-7;
                   // System.out.println(i);
                                for (int k = 0; k < row.length; k++) {

                                    if(l>=0 && k>=4 && i!=0)   // for address (index k= 4) when has ,
                                    {
                                        if(k>4)
                                            filed +=", ";
                                        filed += row[k];
                                        l--;
                                        if(l<0) {
                                            System.out.print(filed);

                                            for (int s = 0; s < 30; s++) {
                                                System.out.print(" ");
                                               if (30-filed.length()<s)
                                                    break;
                                            }

                                                 }
                                    }else
                                    {
                                        if(k>0 && j-k-1>0) //
                                        {
                                            System.out.print(row[k]);
                                            if(i!=0)
                                            System.out.print(",");
                                        }
                                        else
                                        {System.out.print(row[k]);}

                                        //================ printing spaces
                                        for (int s = 0; s < 30; s++) {
                                                                System.out.print(" ");
                                                                if ((k==0 || k==2) && i==0 )
                                                                    break;
                                                                if ((k==0 || k==2 || 30-row[k].length()<s) && i!=0 )
                                                                    break;
                                                                }
                                                            }

                                        }
                            System.out.println();

                            //}
                i++;
            }
            scr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {

        }

    }
    /*********************************/
    public String csvFileReader(String filePath, String fileName)
    {
        String output = null;
        File sourceFile= new File(filePath+fileName);
        Scanner scr=null;
        try {
            scr= new Scanner(sourceFile);
            while (scr.hasNext()){
                output = scr.nextLine();
             //   output=data.split("\n");


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            scr.close();
        }
        return output;
    }
}


