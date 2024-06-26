package com.epcemart.employeemngt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.epcemart.employeemngt.Room.Employee_model;

import java.util.List;

public class NewEmpAdapter extends RecyclerView.Adapter<NewEmpAdapter.ViewHolder>{

    private Context mCtx;
    private List<Employee_model> empList;

    public NewEmpAdapter(Context mCtx, List<Employee_model> empList) {
        this.mCtx = mCtx;
        this.empList = empList;
    }

    @NonNull
    @Override
    public NewEmpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_emp, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NewEmpAdapter.ViewHolder holder, int position) {

        Employee_model t = empList.get(position);
        holder.txt_employee_name.setText(t.getEmployee_name());
       /* holder.txt_date.setText(t.getDate());
        holder.txt_emp_type.setText(t.getEmp_type());
        holder.txt_email_id.setText(t.getEmail_id());
        holder.txt_contact_number.setText(t.getContact_number());*/
        holder.txt_desc.setText(t.getEdt_desc());

        holder.click_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mCtx, EmployeeDetails.class);
                intent.putExtra("employee_name",t.getEmployee_name());
                intent.putExtra("employee_added_date",t.getDate());
                intent.putExtra("employee_type",t.getEmp_type());
                intent.putExtra("employee_email_id",t.getEmail_id());
                intent.putExtra("employee_contact_number",t.getContact_number());
                intent.putExtra("employee_description",t.getEdt_desc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_employee_name, txt_date, txt_emp_type, txt_email_id,txt_contact_number,txt_desc;
        LinearLayout click_emp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_employee_name = itemView.findViewById(R.id.txt_employee_name);
           /* txt_date = itemView.findViewById(R.id.txt_date);
            txt_emp_type = itemView.findViewById(R.id.txt_emp_type);
            txt_email_id = itemView.findViewById(R.id.txt_email_id);
            txt_contact_number = itemView.findViewById(R.id.txt_contact_number);*/
            txt_desc = itemView.findViewById(R.id.txt_desc);
            click_emp = itemView.findViewById(R.id.click_emp);

        }
    }
}
