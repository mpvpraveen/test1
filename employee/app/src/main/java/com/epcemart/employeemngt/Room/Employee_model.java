package com.epcemart.employeemngt.Room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "emp_mngt")
public class Employee_model implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "eId")
    private int id;

    @ColumnInfo(name = "employee_name")
    private String employee_name;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "emp_type")
    private String emp_type;

    @ColumnInfo(name = "email_id")
    private String email_id;

    @ColumnInfo(name = "contact_number")
    private String contact_number;

    @ColumnInfo(name = "edt_desc")
    private String edt_desc;

    public Employee_model(int id, String employee_name, String date, String emp_type, String email_id, String contact_number, String edt_desc) {
        this.id = id;
        this.employee_name = employee_name;
        this.date = date;
        this.emp_type = emp_type;
        this.email_id = email_id;
        this.contact_number = contact_number;
        this.edt_desc = edt_desc;
    }

    public Employee_model() {

    }

    /*
     * Getters and Setters
     * */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmp_type() {
        return emp_type;
    }

    public void setEmp_type(String emp_type) {
        this.emp_type = emp_type;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEdt_desc() {
        return edt_desc;
    }

    public void setEdt_desc(String edt_desc) {
        this.edt_desc = edt_desc;
    }
}
