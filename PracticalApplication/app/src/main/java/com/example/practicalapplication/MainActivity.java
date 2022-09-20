package com.example.practicalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnSave, btnUpdate, btnDelete;
    private EmployeeAdapter employeeAdapter;
    private ListView lvEmployee;
    private List<Employee> employees;
    private SQLiteHelper sqLiteHelper;
    private EditText editName, editDesignation, editSalary;
    private long employeeItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        lvEmployee = findViewById(R.id.lvEmployee);
        editName = findViewById(R.id.editName);
        editDesignation = findViewById(R.id.editDesignation);
        editSalary = findViewById(R.id.editSalary);
        sqLiteHelper = new SQLiteHelper(this);
        employees = sqLiteHelper.findAllEmployee();
        employeeAdapter = new EmployeeAdapter(this, employees, sqLiteHelper);
        lvEmployee.setAdapter(employeeAdapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String designation = editDesignation.getText().toString();
                Double salary = Double.parseDouble(editSalary.getText().toString());
                Employee employee = new Employee(name, designation, salary);
                sqLiteHelper.createEmployee(employee);
                employees.add(employee);
                employeeAdapter.notifyDataSetChanged();
                resetForm();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String designation = editDesignation.getText().toString();
                Double salary = Double.parseDouble(editSalary.getText().toString());
                Employee employee = new Employee(employeeItemId, name, designation, salary);
                sqLiteHelper.updateEmployee(employee);
                employees = sqLiteHelper.findAllEmployee();
                employeeAdapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        lvEmployee.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                employeeItemId = id;
                Employee employee = employees.get(position);
                editName.setText(employee.getName());
                editDesignation.setText(employee.getDesignation());
                editSalary.setText(String.valueOf(employee.getSalary()));
                btnUpdate.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.GONE);
            }
        });
    }

    public void resetForm() {
        editName.setText("");
        editDesignation.setText("");
        editSalary.setText("");
    }
}