package com.epcemart.employeemngt.Room;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee_model.class}, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {


    // below line is to create instance
    // for our database class.
    public static EmployeeDatabase instance;
    // abstract variable for dao.
    public abstract EmployeeDao onDataBaseEmployeeDAO();

    public static EmployeeDatabase getInstance(final Context context) {
        if (instance == null) {
            synchronized (EmployeeDatabase.class) {

                instance = Room.databaseBuilder(context.getApplicationContext(),
                                EmployeeDatabase.class, "Emp_VerifiedDataList")
                        .allowMainThreadQueries()
                        .build();
                Log.d(TAG, "New instance created...");
            }
        }
        return instance;
        // .addCallback(roomCallback)
    }
}
