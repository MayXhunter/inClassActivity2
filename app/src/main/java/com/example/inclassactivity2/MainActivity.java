package com.example.inclassactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String DATA = "DATA";
    public static final String Title = "Title";public static final String Author = "Author";
    public static final String Pages = "Pages";


    private EditText edtTitle;
    private EditText edtAuthor;
    private EditText edtPages;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setupSharedPrefs();



    }
    private void setUpViews() {
        edtTitle= findViewById(R.id.edtTitle);
        edtAuthor= findViewById(R.id.edtAuthor);
        edtPages= findViewById(R.id.edtPages);
    }
    private void setupSharedPrefs(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
    }


    public void btnAddOnclick(View view) {

        String title = edtTitle.getText().toString();
        String author = edtAuthor.getText().toString();
        String pages = edtPages.getText().toString();


        editor.putString(Title,title);
        editor.putString(Author,author);
        editor.putString(Pages,pages);



    }

    public void btnSaveOnClick(View view) {
        String title = edtTitle.getText().toString();
        String author = edtAuthor.getText().toString();
        String pages = edtPages.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        Book[] books = new Book[2];
        books[0] = new Book(title,author,pages);
        String bookString = gson.toJson(books);
        editor.putString(DATA,bookString);
        editor.commit();


    }
}