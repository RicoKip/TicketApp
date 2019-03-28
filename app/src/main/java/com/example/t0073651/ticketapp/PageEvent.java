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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PageEvent extends AppCompatActivity {
    //set attributes
    private TextView eventNme;
    private TextView eventDte;
    private TextView eventLoc;
    private ImageView eventImg;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_page);
        //call method
        getDetails();
    }

    //call adapter and set details to view
    private void getDetails(){
        if (getIntent().hasExtra("eventName")
                &&getIntent().hasExtra("eventDate")
                &&getIntent().hasExtra("eventImage")
                &&getIntent().hasExtra("eventLoc")){
            String eName =  getIntent().getStringExtra("eventName");
            String eImage =  getIntent().getStringExtra("eventImage");
            String eDate = getIntent().getStringExtra("eventDate");
            String eLoc =  getIntent().getStringExtra("eventLoc");
            setDetails(eName,eDate,eLoc,eImage);
        }
    }
    //set attributes to user interface elements
    private void setDetails(String name, String date, String loct, String img){
        eventNme = findViewById(R.id.eventName2);
        eventLoc = findViewById(R.id.eventLocation);
        eventDte = findViewById(R.id.eventDate2);
        eventImg = findViewById(R.id.eventImgaeView);
        eventNme.setText(name);
        eventLoc.setText(loct);
        eventDte.setText(date);
        Glide.with(this).asBitmap().load(img).into(eventImg);
    }

}
