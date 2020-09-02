package com.example.roomdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface EmployeeDao {              //имя таблице равно имени Entity класса (Employee) но в SQL не важен регистр в имени таблицы

    @Query("SELECT * FROM employee")                    //забрать всё
    LiveData<List<Employee>> getAll();

    @Query("SELECT * FROM employee WHERE name = :name")        //найти по id
    Employee getById(String name);

    @Insert
    void insertAll (List<Employee> employees);  //вставить всё

    @Insert
    void insert(Employee employee);             //вставить одно

    @Update
    void update (Employee employee);            //обновить

    @Delete
    void delete(Employee employee);         //удалить


}
