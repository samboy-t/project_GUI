package com.example.proj_gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ModePage extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.menu_searchbt){
            Intent i = new Intent(ModePage.this, SearchPage.class);
            startActivity(i);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2){
                    Intent i = new Intent(ModePage.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    public void stud_click(View stud_view){
        Intent i = new Intent(ModePage.this, StudentPage.class);
        startActivity(i);
    }

    public void staff_click(View staff_view){
        EditText staffPass = (EditText) findViewById(R.id.staff_pass);
        if(staffPass.getText().toString().trim().equals("1234")){
            Intent k = new Intent(ModePage.this, StaffPage.class);
            startActivity(k);
        } else {
            Toast pass_toast = Toast.makeText(getApplicationContext(), "Incorrect password, try again..", Toast.LENGTH_SHORT);
            pass_toast.setGravity(Gravity.CENTER, 0, 0);
            pass_toast.show();
        }
    }
}