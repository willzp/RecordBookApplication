package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Student> students = new ArrayList();

    public void addStudent(Student student){
        students.add(student);
    }

    public void RunApplication(RecordBook recordBook){
        System.out.println("Studenter:");
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getName());
        }
        System.out.println("Skriv ett studentnamn eller: \n (1) För högsta betyg \n (2) För lägsta betyg \n (3) För genomsnittliga betyg");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String userInput = scanner.nextLine();
            if(userInput.equals("1")){
                System.out.println("Högsta betyget: " + recordBook.HighestGrade(students));
            }
            else if(userInput.equals("2")){
                System.out.println("Lägsta betyget: " + recordBook.LowestGrade(students));
            }
            else if(userInput.equals("3")){
                System.out.println("Genomsnittliga betyget: " + recordBook.AverageGrade(students));
            }
            else {
                for(int i = 0; i < students.size(); i++){
                    Student student = students.get(i);
                    String studentName = student.getName();
                    if(studentName.equals(userInput)){
                        System.out.println(studentName + " har betyget: " + recordBook.GetRecord(student));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Main main = new Main();
        RecordBook recordBook = new RecordBook();
        File textFile = new File("/Users/williampihl/IdeaProjects/Projekt/src/com/company/TextFile.txt");
        Scanner reader = new Scanner(textFile);

        while (reader.hasNextLine()){
            String name = reader.nextLine();
            String record = reader.nextLine();
            Student student = new Student(name);
            main.addStudent(student);
            recordBook.AddRecord(student, Integer.parseInt(record));
        }

        main.RunApplication(recordBook);
    }
}
