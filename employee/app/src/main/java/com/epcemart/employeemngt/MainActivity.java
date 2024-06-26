package com.epcemart.employeemngt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.epcemart.employeemngt.Room.EmployeeDatabase;
import com.epcemart.employeemngt.Room.Employee_model;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private FloatingActionButton buttonAddemp;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddemp = findViewById(R.id.floatingActionButton);
        buttonAddemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, new_employee.class);
                startActivity(intent);
            }
        });
        
        recyclerView = findViewById(R.id.recyclerview_new_emp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        getEmpData();
    }

    private void getEmpData() {

        class GetTasks extends AsyncTask<Void, Void, List<Employee_model>> {

            @Override
            protected List<Employee_model> doInBackground(Void... voids) {
                List<Employee_model> empList = EmployeeDatabase
                        .getInstance(getApplicationContext())
                        .onDataBaseEmployeeDAO()
                        .getAll();

                return empList;

            }

            @Override
            protected void onPostExecute(List<Employee_model> emp_model) {
                super.onPostExecute(emp_model);
                NewEmpAdapter adapter = new NewEmpAdapter(MainActivity.this, emp_model);
                recyclerView.setAdapter(adapter);
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }
}