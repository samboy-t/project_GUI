package com.example.proj_gui;


import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner tb_drop = (Spinner) findViewById(R.id.equipment_drop);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.table_select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tb_drop.setAdapter(adapter);


        TableLayout dbTable = (TableLayout) findViewById(R.id.equipment_table);

        TableRow tb_head = (TableRow) findViewById(R.id.tb_headings);
        /*tb_head.setId(1);
        tb_head.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));*/

        TextView c1 = (TextView) findViewById(R.id.c1_head);
        //c1.setId(10);
        //c1.setText("Equipment Id");

        //tb_head.addView(c1);

        TextView c2 = (TextView) findViewById(R.id.c2_head);
        //c2.setId(11);
        //c2.setText("Equipment Name");

        //tb_head.addView(c2);

        TextView c3 = (TextView) findViewById(R.id.c2_head);
        //c3.setId(11);
        //c3.setText("Equipment Name");

        //tb_head.addView(c3);

        TextView c4 = (TextView) findViewById(R.id.c2_head);
        //c4.setId(11);
        //c4.setText("Equipment Name");

        //tb_head.addView(c4);

        TextView c5 = (TextView) findViewById(R.id.c2_head);
        //c5.setId(11);
        //c5.setText("Equipment Name");

        //tb_head.addView(c5);

        //dbTable.addView(tb_head, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT));
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
                if (x1 > x2){
                    Intent i = new Intent(MainActivity.this, ModePage.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}