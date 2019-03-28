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

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Adapter.UserAdapterList;
import Database.DatabaseHelper;
import Database.UserDatabase;



public class Account extends AppCompatActivity {
    //set attributes
    private final AppCompatActivity activity = Account.this;
    private DatabaseHelper databaseHelper;
    private Button upDate;
    ListView userLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        usersLst();
        setBackButton();
    }
    //adapter sets details into a list
    //user details retrieved from database
    public void usersLst(){
        databaseHelper = new DatabaseHelper(this);
        List<UserDatabase> userDatabaseList = databaseHelper.getAllUsers();
        userLV = findViewById(R.id.user_details);

        UserAdapterList userAdapterList = new UserAdapterList(userDatabaseList, this);
        userLV.setAdapter(userAdapterList);
    }
    //exit account page
    public void setBackButton(){
        upDate = (Button)findViewById(R.id.updateBTN);
        upDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Account.this, Home.class);
                startActivity(intent);
            }
        });
    }

}
