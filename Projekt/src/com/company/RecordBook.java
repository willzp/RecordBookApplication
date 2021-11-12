package com.company;

import java.util.HashMap;
import java.util.List;

public class RecordBook {
    private HashMap<Student, Integer> recordBook = new HashMap<>();

    public void AddRecord(Student student, int record){
        recordBook.put(student, record);
    }

    public int GetRecord(Student student){
        int record = recordBook.get(student);
        return record;
    }

    public int HighestGrade(List<Student> students){
      int highestGrade = 0;
      for(int i = 0; i < students.size(); i++){
          int record = GetRecord(students.get(i));
          if(record > highestGrade){
              highestGrade = record;
          }
      }
      return highestGrade;
    }

    public int LowestGrade(List<Student> students){
        int lowestGrade = 5;
        for(int i = 0; i < students.size(); i++){
            int record = GetRecord(students.get(i));
            if(record < lowestGrade){
                lowestGrade = record;
            }
        }
        return lowestGrade;
    }

    public int AverageGrade(List<Student> students){
        int totalGrade = 0;
        for(int i = 0; i < students.size(); i++){
            totalGrade = totalGrade + GetRecord(students.get(i));
        }
        int averageGrade = totalGrade/ students.size();
        return averageGrade;
    }
}
