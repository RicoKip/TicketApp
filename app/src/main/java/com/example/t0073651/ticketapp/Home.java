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
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Adapter.EventsAdapterList;
import Database.DatabaseHelper;

import Database.EventsDatabase;
import Database.UserDatabase;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //set attributes
    private RecyclerView recyclerView;
    //set array list to store event details
    //substitution to use of a database
    //set attributes
    private ArrayList<String> evntNames = new ArrayList<>();
    private ArrayList<String> evntDates = new ArrayList<>();
    private ArrayList<String> evntLoc = new ArrayList<>();
    private ArrayList<String> evntImages = new ArrayList<>();
    private ArrayList<String> evntPrice = new ArrayList<>();


    //set attributes
    private DrawerLayout drawerLayout;

    //set attributes
    String eName, eTName;
    String eImage, eTImage;
    String ePrice, eTPrice;
    String uTName;

    //@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getEventInfo();
        //get details from the cart
        getCartData();
        //get details from the tickets activity
        gettICKETData();

        //set Navigation drawer menu
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }
    //open and close drawer menu
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();}
    }

    //initiate classes by selecting from the drawer menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_account:
                Intent intentAcc = new Intent(this, Account.class);
                startActivity(intentAcc);
                break;
            case R.id.nav_events:
                Intent intentEvt = new Intent(this, Home.class);
                //Toast.makeText(getApplicationContext(),"Coming Soon", Toast.LENGTH_LONG).show();
                startActivity(intentEvt);
                break;

                //pass details gotten from the tickets page back to tickets page to set up ticket
            case R.id.nav_tickets:
                Intent intentTck = new Intent(this, Tickets.class);
                intentTck.putExtra("eventName", eTName);
                intentTck.putExtra("eventImage", eTImage);
                intentTck.putExtra("eventPrice", eTPrice);
                intentTck.putExtra("UserName", uTName);
                startActivity(intentTck);
                break;

                //pass details gotten from the tickets page back to tickets page to set up ticket
            case R.id.nav_cart:
                Intent intentCart = new Intent(this, Cart.class);
                intentCart.putExtra("eventName", eName);
                intentCart.putExtra("eventImage", eImage);
                intentCart.putExtra("eventPrice", ePrice);
                startActivity(intentCart);

                break;
            case R.id.nav_logout:
                Intent intentLgt = new Intent(this, Login.class);
                startActivity(intentLgt);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    //recycler view to be populated by hardcoded event details
    //set details into array lists
    public void getEventInfo(){
        evntImages.add("https://www.telegraph.co.uk/content/dam/science/2016/04/08/Moonbase-xlarge_trans_NvBQzQNjv4Bqq4lxibWmEEb2kqxptI1DA8pqEhBuhFWYNRLcHxArFzo.jpg");
        evntNames.add("JOURNEY TO THE MOON");
        evntLoc.add("Junk Yard");
        evntDates.add("JULY 13");
        evntPrice.add("6.50");

        evntImages.add("https://i.ytimg.com/vi/EUCrBkqcLDw/maxresdefault.jpg");
        evntNames.add("MARS ESCAPE");
        evntLoc.add("Escape Room");
        evntDates.add("SEPT 15");
        evntPrice.add("5.50");

        evntImages.add("https://previews.123rf.com/images/noravector/noravector1802/noravector180200164/96147403-cool-culture-comic-book-style-phrase-on-abstract-background-.jpg");
        evntNames.add("CULTURE BEYOND");
        evntLoc.add("Old Warehouse");
        evntDates.add("SEPT 16");
        evntPrice.add("5.00");

        evntImages.add("https://typedrift.com/wp-content/uploads/2018/02/firestorm-hero.png");
        evntNames.add("NIGHT OF THE FIRE STORM");
        evntLoc.add("Car Lounge");
        evntDates.add("OCT 19");
        evntPrice.add("3.00");

        evntImages.add("https://www.edmsauce.com/wp-content/uploads/2017/02/Firestorm-e1487108683143.jpg");
        evntNames.add("SPEED FREAK. EXCLUSIVE MEET");
        evntLoc.add("Speed Arena");
        evntDates.add("NOV 22");
        evntPrice.add("6.00");

        evntImages.add("https://1.bp.blogspot.com/-6KY3vb55ZI0/T7u3sYQs8MI/AAAAAAAAEsY/JTvAlQkD7QY/s1600/army_colors_54.JPG");
        evntNames.add("TRENT ARMY");
        evntLoc.add("Aqua");
        evntDates.add("DEC 01");
        evntPrice.add("5.50");

        setEventInfo();
    }

    //call adapter to set the details onto card view into a recycler view
    public void setEventInfo(){
        recyclerView = findViewById(R.id.main_recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        EventsAdapterList eventsAdapterList = new EventsAdapterList(evntNames, evntDates, evntImages, evntLoc, evntPrice,this);
        recyclerView.setAdapter(eventsAdapterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //method to retrieve intent from the cart
    //cart can hold max one ticket
    public void getCartData(){
        if (getIntent().hasExtra("eventName") &&getIntent().hasExtra("eventImage")&&getIntent().hasExtra("eventPrice")){
            eName =  getIntent().getStringExtra("eventName");
            eImage =  getIntent().getStringExtra("eventImage");
            ePrice =  getIntent().getStringExtra("eventPrice");
        }
    }
    //method to retrieve data from the tickets window
    //only details of one ticket can be passed
    public void gettICKETData(){
        if (getIntent().hasExtra("Name") &&getIntent().hasExtra("Image")&&getIntent().hasExtra("UName")&&getIntent().hasExtra("Price")){
            eTName =  getIntent().getStringExtra("Name");
            eTImage =  getIntent().getStringExtra("Image");
            eTPrice =  getIntent().getStringExtra("Price");
            uTName = getIntent().getStringExtra("UName");
        }
    }



}
