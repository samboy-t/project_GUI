package com.example.proj_gui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHandler dbHandler = new MyDBHandler(this, null);

        Spinner tb_drop = findViewById(R.id.equipment_drop);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.table_select, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tb_drop.setAdapter(adapter);

        TableLayout dbTable = findViewById(R.id.equipment_table);

        TextView c1 = findViewById(R.id.c1_head);
        TextView c2 = findViewById(R.id.c2_head);
        TextView c3 = findViewById(R.id.c3_head);
        TextView c4 = findViewById(R.id.c4_head);
        TextView c5 = findViewById(R.id.c5_head);

        c1.setPadding(10, 0, 10, 0);
        c2.setPadding(10, 0, 10, 0);
        c3.setPadding(10, 0, 10, 0);
        c4.setPadding(10, 0, 10, 0);
        c5.setPadding(10, 0, 10, 0);

        tb_drop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){

                dbTable.removeViews(1, Math.max(0, dbTable.getChildCount() - 1));

                switch (pos){
                    case 1:
                        c1.setText(getString(R.string.c1_head1));
                        c2.setText(getString(R.string.c2_head1));
                        c3.setText(getString(R.string.c3_head1));
                        c4.setText(getString(R.string.c4_head1));
                        c5.setText(getString(R.string.c5_head1));

                        Student student;
                        for (int row = 0; row < 20; row++) {
                            student = dbHandler.readStudent(String.valueOf(row));

                            if (student != null){

                                TableRow tb_row = new TableRow(dbTable.getContext());
                                //tb_row.setId(row);
                                tb_row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                                TextView c1 = new TextView(tb_row.getContext());
                                //c1.setId(row);
                                c1.setText(String.valueOf(student.getStudentName()));
                                c1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c1);

                                TextView c2 = new TextView(tb_row.getContext());
                                //c2.setId(row);
                                c2.setText(String.valueOf(student.getStudentEmail()));
                                c2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c2);

                                TextView c3 = new TextView(tb_row.getContext());
                                //c3.setId(row);
                                c3.setText(String.valueOf(student.getStudentMobile()));
                                c3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c3);

                                TextView c4 = new TextView(tb_row.getContext());
                                //c4.setId(row);
                                c4.setText(String.valueOf(student.getItemID()));
                                c4.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c4);

                                TextView c5 = new TextView(tb_row.getContext());
                                //c5.setId(row);
                                c5.setText(String.valueOf(student.getStudentQuantity()));
                                c5.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c5);

                                dbTable.addView(tb_row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

                                c1.setPadding(10, 0, 10, 0);
                                c2.setPadding(10, 0, 10, 0);
                                c3.setPadding(10, 0, 10, 0);
                                c4.setPadding(10, 0, 10, 0);
                                c5.setPadding(10, 0, 10, 0);
                            }
                        }
                        break;

                    case 2:
                        c1.setText(getString(R.string.c1_head2));
                        c2.setText(getString(R.string.c2_head2));
                        c3.setText(getString(R.string.c3_head2));
                        c4.setText(getString(R.string.c4_head2));
                        c5.setText(getString(R.string.c5_head2));

                        Item item;
                        for (int row = 0; row < 20; row++) {
                            item = dbHandler.findItem(String.valueOf(row));

                            if (item != null){

                                TableRow tb_row = new TableRow(dbTable.getContext());
                                tb_row.setId(row);
                                tb_row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                                TextView c1 = new TextView(tb_row.getContext());
                                c1.setId(row);
                                c1.setText(item.getID());
                                c1.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c1);

                                TextView c2 = new TextView(tb_row.getContext());
                                c2.setId(row);
                                c2.setText(String.valueOf(item.getItemName()));
                                c2.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c2);

                                TextView c3 = new TextView(tb_row.getContext());
                                c3.setId(row);
                                c3.setText(String.valueOf(item.getItemCost()));
                                c3.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c3);

                                TextView c4 = new TextView(tb_row.getContext());
                                c4.setId(row);
                                c4.setText(String.valueOf(item.getItemStock()));
                                c4.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c4);

                                TextView c5 = new TextView(tb_row.getContext());
                                c5.setId(row);
                                c5.setText(String.valueOf(item.getItemLab()));
                                c5.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.border2));

                                tb_row.addView(c5);

                                dbTable.addView(tb_row, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

                                c1.setPadding(10, 0, 10, 0);
                                c2.setPadding(10, 0, 10, 0);
                                c3.setPadding(10, 0, 10, 0);
                                c4.setPadding(10, 0, 10, 0);
                                c5.setPadding(10, 0, 10, 0);
                            }
                        }
                        break;

                    case 0:
                        c1.setText("");
                        c2.setText("");
                        c3.setText("");
                        c4.setText("");
                        c5.setText("");
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent){
            }
        });

        // database stuff

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