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

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {
    //set attributes
    private TextView cardName;
    private TextView total;
    private Button pay;

    String eName;
    String eImage;
    String ePrice;
    String UserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        setTicketDetails();
    }
    //get intent from cart
    //retrieve intent and set to attributes
    public void setTicketDetails(){
        if (getIntent().hasExtra("eventName") &&getIntent().hasExtra("eventImage")&&getIntent().hasExtra("eventPrice")){
            eName =  getIntent().getStringExtra("eventName");
            eImage =  getIntent().getStringExtra("eventImage");
            ePrice =  getIntent().getStringExtra("eventPrice");
            cardName = (TextView)findViewById(R.id.cardNameTXT);
            UserName = cardName.getText().toString();
            setTotal(ePrice);
            setPayBtn(UserName,eName,eImage,ePrice);
        }
    }
    //pass ticket detail in intent to the tickets page
    //set intent
    public void setPayBtn(final String Uname, final String name, final String image, final String price){
        pay = findViewById(R.id.btnPay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Checkout.this, Tickets.class);
                intent.putExtra("eventImage", image);
                intent.putExtra("eventName", name);
                intent.putExtra("eventPrice", price);
                intent.putExtra("UserName", Uname);
                startActivity(intent);
            }
        });
    }
    //set total price in text view
    public void setTotal(String price){
        total = (TextView)findViewById(R.id.totalDisplayTXT);
        total.setText(price);

    }
}
