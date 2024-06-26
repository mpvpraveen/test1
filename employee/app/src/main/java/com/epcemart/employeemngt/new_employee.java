package com.epcemart.employeemngt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epcemart.employeemngt.Room.EmployeeDatabase;
import com.epcemart.employeemngt.Room.Employee_model;

import java.util.ArrayList;
import java.util.Calendar;

public class new_employee extends AppCompatActivity {

    EditText edt_employee_name,edt_date,edt_emp_type,
            edt_email_id,edt_contact_number,
            edt_desc;

    String str_edt_employee_name,str_edt_date,str_edt_emp_type,
            str_edt_email_id,str_edt_contact_number,str_edt_desc;

    Button btn_next_new_bv,btn_cancel_new_bv;
    ArrayList<String> list_emp_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_employee);

        list_emp_type=new ArrayList<>();
        list_emp_type.add("HR");
        list_emp_type.add("Admin");
        list_emp_type.add("Software testing");
        list_emp_type.add("Business development");
        list_emp_type.add("Marketing");

        edt_emp_type = (EditText) findViewById(R.id.edt_emp_type);
        edt_emp_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog emp_type_dialog=new Dialog(new_employee.this);
                emp_type_dialog.setContentView(R.layout.searchable_spinner_dialog);
                emp_type_dialog.getWindow().setLayout(600,600);
                emp_type_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                emp_type_dialog.show();
                TextView txt_header=emp_type_dialog.findViewById(R.id.txt_header);
                EditText edt_search=emp_type_dialog.findViewById(R.id.edt_search);
                edt_search.setHint("select employee type");
                ListView recycler_items=emp_type_dialog.findViewById(R.id.recycler_items);

                ArrayAdapter<String> emp_type_list=new ArrayAdapter<>(new_employee.this,
                        android.R.layout.simple_list_item_1,list_emp_type);
                recycler_items.setAdapter(emp_type_list);
                edt_search.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        emp_type_list.getFilter().filter(s);
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
                recycler_items.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        edt_emp_type.setText(emp_type_list.getItem(position));
                        emp_type_dialog.dismiss();
                    }
                });
            }
        });

        edt_date = (EditText) findViewById(R.id.edt_date);
        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar visited_date = Calendar.getInstance();
                int day = visited_date.get(Calendar.DAY_OF_MONTH);
                int month = visited_date.get(Calendar.MONTH);
                int year = visited_date.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog bv_date = new DatePickerDialog(new_employee.this,R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //edt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                edt_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, year, month, day);

                bv_date.show();
            }
        });

        edt_email_id = (EditText) findViewById(R.id.edt_email_id);
        edt_contact_number = (EditText) findViewById(R.id.edt_contact_number);
        edt_desc = (EditText) findViewById(R.id.edt_desc);
        edt_employee_name = (EditText) findViewById(R.id.edt_employee_name);

        btn_next_new_bv = (Button) findViewById(R.id.btn_next_new_bv);
        btn_next_new_bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewEmp();
            }
        });

        btn_cancel_new_bv = (Button) findViewById(R.id.btn_cancel_new_bv);
        btn_cancel_new_bv.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View view) {
            }
        });

    }

    private void saveNewEmp() {

        str_edt_employee_name = edt_employee_name.getText().toString().trim();
        str_edt_date = edt_date.getText().toString().trim();
        str_edt_emp_type = edt_emp_type.getText().toString().trim();
        str_edt_email_id = edt_email_id.getText().toString().trim();
        str_edt_contact_number = edt_contact_number.getText().toString().trim();
        str_edt_desc = edt_desc.getText().toString().trim();

        if (str_edt_employee_name.isEmpty()) {
            edt_employee_name.setError("name required");
            edt_employee_name.requestFocus();
            return;
        }

        if (str_edt_email_id.isEmpty()) {
            edt_email_id.setError("email id required");
            edt_email_id.requestFocus();
            return;
        }

        if (str_edt_desc.isEmpty()) {
            edt_desc.setError("description required");
            edt_desc.requestFocus();
            return;
        }

        class saveNewEmp extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a mngt
                Employee_model emp_model = new Employee_model();

                emp_model.setEmployee_name(str_edt_employee_name);
                emp_model.setDate(str_edt_date);
                emp_model.setEmp_type(str_edt_emp_type);
                emp_model.setEmail_id(str_edt_email_id);
                emp_model.setContact_number(str_edt_contact_number);
                emp_model.setEdt_desc(str_edt_desc);

                EmployeeDatabase.getInstance(getApplicationContext())
                        .onDataBaseEmployeeDAO().insert(emp_model);

                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }
        saveNewEmp st = new saveNewEmp();
        st.execute();
    }
}
