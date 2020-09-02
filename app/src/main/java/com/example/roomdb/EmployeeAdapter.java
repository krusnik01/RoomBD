package com.example.roomdb;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//для связывания списка employee и рейсайклвью нам нужен адаптер
public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employees;

    public EmployeeAdapter(ArrayList<Employee> employees) {this.employees = employees;}

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_employee_view, parent ,false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employees.get(position);
        holder.textViewNameEmployee.setText(employee.getName());
        holder.textViewIdEmployee.setText(String.format("%s",employee.getId()));
        holder.textViewSalaryEmployee.setText(String.format("%s",employee.getSalary()));
    }

    @Override
    public int getItemCount() {return employees.size();    }


    class EmployeeViewHolder extends RecyclerView.ViewHolder {
       private TextView textViewNameEmployee;
        private TextView textViewSalaryEmployee;
        private TextView textViewIdEmployee;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewNameEmployee = itemView.findViewById(R.id.textViewNameEmployee);
            textViewSalaryEmployee = itemView.findViewById(R.id.textViewSalaryEmployee);
            textViewIdEmployee = itemView.findViewById(R.id.textViewIdEmployee);
        }
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    public List<Employee> getEmployees() {return employees;}
}
