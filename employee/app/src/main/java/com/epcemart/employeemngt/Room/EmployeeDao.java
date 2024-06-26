package com.epcemart.employeemngt.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM emp_mngt")
    List<Employee_model> getAll();

    @Insert
    void insert(Employee_model employee);

    @Delete
    void delete(Employee_model employee);

    @Update
    void update(Employee_model employee);

}
