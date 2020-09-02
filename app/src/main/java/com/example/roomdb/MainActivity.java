package com.example.roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    EditText editTextNameSearch;
private MainViewModelEmployee viewModelEmployee;
private RecyclerView recyclerViewEmployee;
private final ArrayList<Employee> employees= new ArrayList<>();
public EmployeeAdapter employeeAdapter;
public Employee employee = new Employee();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchItem();
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

    public void InsertEmployee(String name, int salary){
        employee.name = name;
        employee.salary= salary;
        viewModelEmployee.insertEmployee(employee);
    }

    public Employee GetByIdEmployee(){
        String  name = editTextNameSearch.getText().toString();
        viewModelEmployee.getEmployeesById(name);
        return (employee);
    }

    public void OnClickButtonAdd(View view) {
        InsertEmployee(editTextName.getText().toString(),Integer.parseInt(editTextSalary.getText().toString()));
    }

    public void OnClickButtonSearch(View view) {
        Employee employee = GetByIdEmployee();
        textViewName.setText(employee.name);
        textViewSalary.setText(employee.salary);
    }

    public void searchItem(){
        editTextNameSearch = findViewById(R.id.editTextNameSearch);
        editTextName = findViewById(R.id.editTextName);
        editTextSalary = findViewById(R.id.editTextSalary);
        textViewName = findViewById(R.id.textViewNameEmployee);
        textViewSalary = findViewById(R.id.textViewSalary);
    }
}