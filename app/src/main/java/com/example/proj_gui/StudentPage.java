package com.example.proj_gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class StudentPage extends AppCompatActivity {
    TextView idView;
    EditText studentNameBox;
    EditText studentEmailBox;
    EditText studentMobileBox;
    EditText studentItemBox;
    EditText studentQuantityBox;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);

        // database stuff
        idView = (TextView) findViewById(R.id.textView);
        studentNameBox = (EditText) findViewById(R.id.s_name);
        //quantityBox = (EditText) findViewById(R.id.pr_quantity);
        studentEmailBox = (EditText) findViewById(R.id.s_email);
        studentMobileBox = (EditText) findViewById(R.id.s_mobile);
        studentItemBox = (EditText) findViewById(R.id.s_item);
        studentQuantityBox = (EditText) findViewById(R.id.s_quantity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_return, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.menu_returnbt){
            Intent i = new Intent(StudentPage.this, ModePage.class);
            startActivity(i);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void newStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int item = Integer.parseInt(studentItemBox.getText().toString());
        int quantity = Integer.parseInt(studentQuantityBox.getText().toString());
        Student student = new Student(studentNameBox.getText().toString(), studentEmailBox.getText().toString(), studentMobileBox.getText().toString(),
                                    item, quantity);
        dbHandler.addStudent(student);
        studentNameBox.setText("");
        studentEmailBox.setText("");
        studentMobileBox.setText("");
        studentItemBox.setText("");
        studentQuantityBox.setText("");

        CheckBox emailChk = (CheckBox) findViewById(R.id.email_chk);
        if(!emailChk.isChecked()){
            Toast borrow_toast = Toast.makeText(getApplicationContext(), "Borrow request confirmed.", Toast.LENGTH_SHORT);
            borrow_toast.setGravity(Gravity.CENTER, 0, 0);
            borrow_toast.show();
        } else {
            Toast email_toast = Toast.makeText(getApplicationContext(), "Borrow request confirmed. Sending e-mail..", Toast.LENGTH_SHORT);
            email_toast.setGravity(Gravity.CENTER, 0, 0);
            email_toast.show();
        }
    }

    public void lookupStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Student student = dbHandler.findStudent(studentNameBox.getText().toString());
        //Student student = dbHandler.findStudent(studentEmailBox.getText().toString());

        if(student != null) {
            idView.setText(String.valueOf(student.getID()));
            //idView.setText()
            studentEmailBox.setText(String.valueOf(student.getStudentEmail()));
            studentMobileBox.setText(String.valueOf(student.getStudentMobile()));
            studentItemBox.setText(String.valueOf(student.getItemID()));
            studentQuantityBox.setText(String.valueOf(student.getStudentQuantity()));
        } else {
            idView.setText("No Match Found");
        }
    }

    public void removeStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        boolean result = dbHandler.deleteStudent(studentNameBox.getText().toString());
        if (result) {
            idView.setText("Record Deleted");
            studentNameBox.setText("");
            studentEmailBox.setText("");
            studentMobileBox.setText("");
            studentItemBox.setText("");
            studentQuantityBox.setText("");
        } else idView.setText("No Match Found");
    }
}