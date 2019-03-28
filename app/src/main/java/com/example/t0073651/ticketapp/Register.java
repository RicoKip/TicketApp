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

public class Register extends AppCompatActivity {
    //set attributes
    private final AppCompatActivity activity = Register.this;
    private DatabaseHelper databaseHelper;
    private UserDatabase userDatabase;

    //set attributes
    private Button btnLogin2;
    private Button btnRegister2;
    private TextView fName;
    private TextView lName;
    private TextView uName2;
    private TextView pWord2;
    private TextView eMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //method to set attributes to userinterface elements
        setElements();

        //initiate database handshake
        databaseHelper = new DatabaseHelper(activity);
        userDatabase =  new UserDatabase();
        //set click listener
        btnRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //perform user registration
                registerUser();
            }
        });
        btnLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
    private void setElements(){
        //set attributes to user elements
        btnLogin2 = findViewById(R.id.loginBTN2);
        btnRegister2 = findViewById(R.id.submitBTN);
        fName = findViewById(R.id.fnameTXT);
        lName = findViewById(R.id.lnameTXT);
        uName2 = findViewById(R.id.usernameTXT2);
        pWord2 = findViewById(R.id.passwordTXT2);
        eMail = findViewById(R.id.emailTXT);
    }
    //perform user registration method
    private void registerUser(){
        //set new attribute names
        String FName = fName.getText().toString().trim();
        String LName = lName.getText().toString().trim();
        String UName2 = uName2.getText().toString().trim();
        String PWord2 = pWord2.getText().toString().trim();
        String EMail = eMail.getText().toString().trim();

        //condition to verify if there is any input
        if (FName.length() == 0 ||
                LName.length() == 0 ||
                UName2.length() == 0 ||
                PWord2.length() == 0 ||
                EMail.length() == 0){
            Toast.makeText(getApplicationContext(),"Fill in missing space.", Toast.LENGTH_LONG).show();
        }else {
            //veify is user detail already
            if (!databaseHelper.checkUserName(UName2)) {
                //set user data to userdatabase table columns
                userDatabase.setFirstName(FName);
                userDatabase.setLastName(LName);
                userDatabase.setUserName(UName2);
                userDatabase.setPassWord(PWord2);
                userDatabase.setEmail(EMail);
                //add results into database
                databaseHelper.insertData(userDatabase);
                Toast.makeText(getApplicationContext(), "Registration successful.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Register.this, Home.class);
                startActivity(intent);

            } else {
                Toast.makeText(getApplicationContext(), "User Exists.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
