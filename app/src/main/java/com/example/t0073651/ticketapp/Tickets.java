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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.TicketsAdapter;

public class Tickets extends AppCompatActivity {
    //set attributes
    private List<String> ticketsList = new ArrayList<>();
    private ListView listView;
    private Button button;
    String eName;
    String eImage;
    String ePrice;
    String UserName;
    String newImage;
    private ArrayList<String> eventsImages = new ArrayList<>();
    private ArrayList<String> eventsName = new ArrayList<>();
    private ArrayList<String> eventsUser = new ArrayList<>();
    private ArrayList<String> eventsPrice = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        //call method
        setTicketDetails();
    }
    //retrieve intent and set data to attributes
    public void setTicketDetails(){
        if (getIntent().hasExtra("eventName") &&getIntent().hasExtra("eventImage")&&getIntent().hasExtra("eventPrice")&&getIntent().hasExtra("UserName")){
            eName =  getIntent().getStringExtra("eventName");
            eImage =  getIntent().getStringExtra("eventImage");
            ePrice =  getIntent().getStringExtra("eventPrice");
            UserName =  getIntent().getStringExtra("UserName");
            eventsName.add(eName);
            eventsImages.add("https://internationalbarcodes.net/wp-content/uploads/2017/04/QR%20code%20example.jpg");
            newImage = "https://internationalbarcodes.net/wp-content/uploads/2017/04/QR%20code%20example.jpg";
            eventsUser.add(UserName);
            eventsPrice.add(ePrice);
            ticketList(eventsName, eventsImages, eventsUser, eventsPrice);
            setButton(eName,UserName, newImage, ePrice);

        }
    }
    //adapter set view of ticket by accessing intent data
    public void ticketList(ArrayList<String> tname, ArrayList<String> timage, ArrayList<String> tuser, ArrayList<String> tprice){
        listView = (ListView)findViewById(R.id.ticket_details);
        TicketsAdapter ticketsAdapter = new TicketsAdapter(tname, timage, tuser, tprice, this);
        listView.setAdapter(ticketsAdapter);
    }
    //set intent to  back button
    //intent is passed to home screen and retrieved when class is accessed back through menu
    public void setButton(final String name, final String Uname, final String image, final String price){
        button = (Button)findViewById(R.id.exitBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tickets.this, Home.class);
                intent.putExtra("Image", image);
                intent.putExtra("Name", name);
                intent.putExtra("UName", Uname);
                intent.putExtra("Price", price);
                startActivity(intent);
            }
        });
    }
}
