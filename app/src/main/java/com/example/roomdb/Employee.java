package com.example.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee")                 //определяет что это таблица и даём ей имя, если шо она создаётся с именем класса
public class Employee {

    @PrimaryKey(autoGenerate = true)              //показывет что это первичный ключ id
    private int id;
    public String name;
    public int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Ignore
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
