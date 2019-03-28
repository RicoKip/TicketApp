/*
* This Mobile Application was developed with reference from external material as well as implementations
* Made by me the developer.
* Credit to outsourced implementations goes to :-
* Developers.android - Save data using SQLite $$ Creating a navigation drawer - https://developer.android.com/training/data-storage/sqlite#java
*                                                                                 - https://developer.android.com/training/implementing-navigation/nav-drawer
* Stackoverflow - Retrieving SQLite database data and displaying on textview - https://stackoverflow.com/questions/44876568/android-studio-retrieve-data-from-sqlite-database-and-display-it-into-textview
*               - Implementing ViewHolder - https://stackoverflow.com/questions/14087495/android-implementing-viewholder
*               - Displaying user data on listview - https://stackoverflow.com/questions/47954066/displaying-all-data-from-sqlite-database-into-listview-in-tabbed-activity
 * Androidtutorialshub - Android login and registration using SQLite - http://www.androidtutorialshub.com/android-login-and-register-with-sqlite-database-tutorial/
 * CodingwithMitch - Recyclerview tutorial - https://github.com/mitchtabian/Recyclerview
 * Codinginflow - Creating a nav drawer - https://codinginflow.com/tutorials/android/navigation-drawer/part-3-fragments
 * Code was modified to fit the functionality of the proposed system.
* */
package com.example.t0073651.ticketapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Database.DatabaseHelper;
import Database.UserDatabase;

public class Login extends AppCompatActivity {
    //set attributes
    private final AppCompatActivity activity = Login.this;
    private DatabaseHelper databaseHelper;
    private UserDatabase userDatabase;

    //set attributes
    private Button btnLogin;
    private Button btnRegister;
    private TextView uName;
    private TextView pWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //method to set attribute to elements
        setElements2();
        databaseHelper = new DatabaseHelper(activity);

        //set click listening activity
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform user validation
                checkUser();
            }
        });

        //start registration window activity
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    //set attributes to elements
    private void setElements2(){
        //identify buttons and text views
        btnLogin = findViewById(R.id.loginBTN);
        btnRegister = findViewById(R.id.registerBTN);
        uName = findViewById(R.id.usernameTXT);
        pWord = findViewById(R.id.passwordTXT);
    }
    //validate user method from databasehelper
    private void checkUser(){
        String UName = uName.getText().toString();
        String PWord = pWord.getText().toString();

        //user validation through imputed data with condition
        if (databaseHelper.check(UName, PWord)){
            Toast.makeText(getApplicationContext(),"Login successful", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Login.this, Home.class);
            intent.putExtra("userName", UName);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Login Error: Incorrect details.", Toast.LENGTH_LONG).show();
        }
    }
}
