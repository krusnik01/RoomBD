package com.example.roomdb;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModelEmployee extends AndroidViewModel {

    private static AppDatabase database;
    private LiveData<List<Employee>> employees;
    private Employee employee;

    public MainViewModelEmployee(@NonNull Application application) {
        super(application);
        database = AppDatabase.getInstance(getApplication());
        employees = database.employeeDao().getAll();
    }

    public LiveData<List<Employee>> getEmployees() {return employees;    }

    public Employee getEmployeesById(String name){
        employee = database.employeeDao().getById(name);
        return employee;
    }

    public void insertEmployee(Employee employee) {
        new InsertTask().execute(employee);
    }

    private static class InsertTask extends AsyncTask<Employee, Void, Void> {

        @Override
        protected Void doInBackground(Employee... employees) {
            if (employees != null && employees.length > 0) {
                database.employeeDao().insert(employees[0]);
            }
            return null;
        }
    }


}



