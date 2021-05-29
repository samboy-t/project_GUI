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
import android.widget.Toast;

public class StudentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_page);
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

    public void borrow_click(View borrow_view){
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
}