package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd;
    Button buttonSearch;
    TextView textViewName;
    TextView textViewSalary;
    EditText editTextName;
    EditText editTextSalary;
    EditText editTextId;
private MainViewModelEmployee viewModelEmployee;
private RecyclerView recyclerViewEmployee;
private final ArrayList<Employee> employees= new ArrayList<>();
public EmployeeAdapter employeeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModelEmployee = ViewModelProviders.of(this).get(MainViewModelEmployee.class);
        recyclerViewEmployee =findViewById(R.id.viewEmployees);
        employeeAdapter = new EmployeeAdapter(employees);
        recyclerViewEmployee.setLayoutManager(new LinearLayoutManager(this));
        getData();
        recyclerViewEmployee.setAdapter(employeeAdapter);
            }

    private void getData(){
         LiveData <List<Employee>> employeeFromDB = viewModelEmployee.getEmployees();
        employeeFromDB.observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
                employeeAdapter.setEmployees(employees);
            }
        });
    }

 /*   public void InsertEmployee(String name, int salary){
        employee.name = name;
        employee.salary= salary;
        employeeDao.insert(employee);
    }

    public void GetAllEmployee(){
        List<Employee> employees= employeeDao.getAll();
    }

    public Employee GetByIdEmployee(int id){
        employee = employeeDao.getById(id);
        return (employee);
    }

    public void UpdateEmployee(int id, int newSalary){
        Employee employee = GetByIdEmployee(id);
        employee.salary = newSalary;
        employeeDao.update(employee);
    }

    public void DeleteEmployee(int id){
        employeeDao.delete(GetByIdEmployee(id));
    }

    public void OnClickButtonAdd(View view) {
        InsertEmployee(editTextName.getText().toString(),Integer.parseInt(editTextSalary.getText().toString()));
    }

    public void OnClickButtonSearch(View view) {
        Employee employee =GetByIdEmployee(Integer.parseInt(editTextId.getText().toString()));
        textViewName.setText(employee.name);
        textViewSalary.setText(employee.salary);
    }

    public void searchItem(){
        editTextId = findViewById(R.id.editTextIdEmployee);
        editTextName = findViewById(R.id.editTextEmployeeName);
        editTextSalary = findViewById(R.id.editTextEmployeeSalary);
        textViewName = findViewById(R.id.textViewNameEmployee);
        textViewSalary = findViewById(R.id.textViewSalary);
    }*/
}