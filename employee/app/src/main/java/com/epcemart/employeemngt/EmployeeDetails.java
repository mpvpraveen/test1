package com.epcemart.employeemngt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmployeeDetails extends AppCompatActivity {

    TextView edt_employee_name,edt_date,edt_emp_type,
            edt_email_id,edt_contact_number,
            edt_desc;

    String str_edt_employee_name,str_edt_date,str_edt_emp_type,
            str_edt_email_id,str_edt_contact_number,str_edt_desc;

    Button btn_update_bv,btn_cancel_new_bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        Intent DCD = getIntent();
        str_edt_employee_name= DCD.getExtras().getString("employee_name");
        str_edt_date=DCD.getExtras().getString("employee_added_date");
        str_edt_emp_type=DCD.getExtras().getString("employee_type");
        str_edt_email_id=DCD.getExtras().getString("employee_email_id");
        str_edt_contact_number=DCD.getExtras().getString("employee_contact_number");
        str_edt_desc=DCD.getExtras().getString("employee_description");

        edt_emp_type = (TextView) findViewById(R.id.edt_emp_type);
        edt_emp_type.setText(str_edt_emp_type);
        edt_date = (TextView) findViewById(R.id.edt_date);
        edt_date.setText(str_edt_date);
        edt_email_id = (TextView) findViewById(R.id.edt_email_id);
        edt_email_id.setText(str_edt_email_id);
        edt_contact_number = (TextView) findViewById(R.id.edt_contact_number);
        edt_contact_number.setText(str_edt_contact_number);
        edt_desc = (TextView) findViewById(R.id.edt_desc);
        edt_desc.setText(str_edt_desc);
        edt_employee_name = (TextView) findViewById(R.id.edt_employee_name);
        edt_employee_name.setText(str_edt_employee_name);

        btn_update_bv = (Button) findViewById(R.id.btn_update_bv);
        btn_update_bv.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
            }
        });

        btn_cancel_new_bv = (Button) findViewById(R.id.btn_cancel_new_bv);
        btn_cancel_new_bv.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
            }
        });
    }
}