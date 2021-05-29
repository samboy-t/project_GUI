package com.example.proj_gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class StaffPage extends AppCompatActivity {
    TextView idView;
    EditText itemNameBox;
    EditText itemCostBox;
    EditText itemStockBox;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_page);

        idView = (TextView) findViewById(R.id.i_id);
        itemNameBox= (EditText) findViewById(R.id.i_name);
        itemCostBox = (EditText) findViewById(R.id.i_cost);
        itemStockBox = (EditText) findViewById(R.id.i_stock);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_return, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.menu_returnbt){
            Intent i = new Intent(StaffPage.this, ModePage.class);
            startActivity(i);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void newItem(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(idView.getText().toString());
        int itemCost = Integer.parseInt(itemCostBox.getText().toString());
        int itemStock = Integer.parseInt(itemStockBox.getText().toString());
        // public Item(int id, String itemName, int itemCost, int itemStock)
        Item item = new Item(id, itemNameBox.getText().toString(), itemCost, itemStock);
        dbHandler.addItem(item);
        idView.setText("");
        itemNameBox.setText("");
        itemCostBox.setText("");
        itemStockBox.setText("");

    }

    public void lookupItem(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Item item = dbHandler.findItem(idView.getText().toString());
        //Student student = dbHandler.findStudent(studentEmailBox.getText().toString());

        if(item != null) {
            idView.setText(String.valueOf(item.getID()));
            //idView.setText()
            itemNameBox.setText(String.valueOf(item.getItemName()));
            itemCostBox.setText(String.valueOf(item.getItemCost()));
            itemStockBox.setText(String.valueOf(item.getItemStock()));

        } else {
            idView.setText("No Match Found");
        }
    }

    public void removeItem(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        boolean result = dbHandler.deleteItem(idView.getText().toString());
        if (result) {
            idView.setText("Record Deleted");
            itemNameBox.setText("");
            itemCostBox.setText("");
            itemStockBox.setText("");
        } else idView.setText("No Match Found");
    }
}