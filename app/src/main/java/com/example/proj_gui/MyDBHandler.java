package com.example.proj_gui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="labStock.db";
    private static final String TABLE_STUDENTS = "students";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STUDENTNAME = "studentName";
    public static final String COLUMN_STUDENTEMAIL = "studentEmail";
    public static final String COLUMN_STUDENTMOBILE = "studentMobile";
    public static final String COLUMN_STUDENTITEMID = "itemID";
    public static final String COLUMN_STUDENTQUANTITY = "studentQuantity";

    private static final String TABLE_ITEMS = "items";


    public static final String COLUMN_ITEMNAME = "itemName";
    public static final String COLUMN_ITEMCOST = "itemCost";
    public static final String COLUMN_ITEMSTOCK = "itemStock";




    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " +
                TABLE_STUDENTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_STUDENTNAME + " TEXT,"
                + COLUMN_STUDENTEMAIL + " TEXT,"
                + COLUMN_STUDENTMOBILE + " TEXT,"
                + COLUMN_STUDENTITEMID + " INT,"
                + COLUMN_STUDENTQUANTITY + " INT"
                + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);

        String CREATE_ITEMS_TABLE = "CREATE TABLE " +
                TABLE_ITEMS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_ITEMNAME + " TEXT,"
                + COLUMN_ITEMCOST + " INTEGER,"
                + COLUMN_ITEMSTOCK + " INTEGER" + ")";
        db.execSQL(CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);

    }

    public void addStudent(Student student) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_STUDENTNAME, student.getStudentName());
        values.put(COLUMN_STUDENTEMAIL, student.getStudentEmail());
        values.put(COLUMN_STUDENTMOBILE, student.getStudentMobile());
        values.put(COLUMN_STUDENTITEMID, student.getItemID());
        values.put(COLUMN_STUDENTQUANTITY, student.getStudentQuantity());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }

    public Student findStudent(String studentName) {
        String query = "SELECT * FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_STUDENTNAME + " = \"" + studentName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();

        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setID(Integer.parseInt(cursor.getString(0)));
            student.setStudentName(cursor.getString(1));
            student.setStudentEmail(cursor.getString(2));
            student.setStudentMobile(cursor.getString(3));
            student.setItemID(Integer.parseInt(cursor.getString(4)));
            student.setStudentQuantity(Integer.parseInt(cursor.getString(5)));
            //product.setProductQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }
        else {
            student = null;
        }
        db.close();
        return student;
    }

    public Student readStudent(String col) {
        String query = "SELECT * FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_ID + " = \"" + col + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();

        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            student.setID(Integer.parseInt(cursor.getString(0)));
            student.setStudentName(cursor.getString(1));
            student.setStudentEmail(cursor.getString(2));
            student.setStudentMobile(cursor.getString(3));
            student.setItemID(Integer.parseInt(cursor.getString(4)));
            student.setStudentQuantity(Integer.parseInt(cursor.getString(5)));
            //product.setProductQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }
        else {
            student = null;
        }
        db.close();
        return student;
    }

    public boolean deleteStudent(String studentName) {
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_STUDENTS + " WHERE " + COLUMN_STUDENTNAME + " = \"" + studentName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Student student = new Student();

        if(cursor.moveToFirst()) {
            student.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_STUDENTS, COLUMN_ID + " = ?",
                    new String[]{String.valueOf(student.getID())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public void addItem(Item item) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEMNAME, item.getItemName());
        values.put(COLUMN_ITEMCOST, item.getItemCost());
        values.put(COLUMN_ITEMSTOCK, item.getItemStock());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public Item findItem(String itemID) {
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ID+ " = \"" + itemID + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Item item = new Item();

        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            item.setID(Integer.parseInt(cursor.getString(0)));
            item.setItemName(cursor.getString(1));
            item.setItemCost(Integer.parseInt(cursor.getString(2)));
            item.setItemStock(Integer.parseInt(cursor.getString(3)));
            //product.setProductQuantity(Integer.parseInt(cursor.getString(2)));
            cursor.close();
        }
        else {
            item = null;
        }
        db.close();
        return item;
    }

    public boolean deleteItem(String itemID) {
        boolean result = false;

        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE " + COLUMN_ID + " = \"" + itemID + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Item item = new Item();

        if(cursor.moveToFirst()) {
            item.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_STUDENTS, COLUMN_ID + " = ?",
                    new String[]{String.valueOf(item.getID())});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}
