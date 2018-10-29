package com.example.parent.Model;

import java.math.BigInteger;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Duy Anh on 10/22/2018
 **/
public class InforClass {
    static Integer count = 0;
    Integer Id;
    String Grade;
    String Typeclass;
    String Name;
    Date DateStart;
    Date DateEnd;
    Time TimeStart;
    Time TimeEnd;
    String Day;
    Integer Price;

    public InforClass(String grade, String typeclass, String name, Date dateStart, Date dateEnd, Time timeStart, Time timeEnd, String day, Integer price) {
        count++;
        this.Id = count;
        this.Grade = grade;
        this.Typeclass = typeclass;
        this.Name = name;
        this.DateStart = dateStart;
        this.DateEnd = dateEnd;
        this.TimeStart = timeStart;
        this.TimeEnd = timeEnd;
        this.Day = day;
        this.Price = price;
    }
}
