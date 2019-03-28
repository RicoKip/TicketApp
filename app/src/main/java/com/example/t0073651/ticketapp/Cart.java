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

import Adapter.CartNewAdapter;

public class Cart extends AppCompatActivity {

    //set attributes
    private ListView listView;
    private ArrayList<String> evntNme = new ArrayList<>();
    private ArrayList<String> evntImg = new ArrayList<>();
    private ArrayList<String> evntPrc = new ArrayList<>();

    //set attributes
    private TextView sum;
    private Button cart;
    private Button checkout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        setNewListItems();
    }
    //get intent from the book button in home an retrieve intent
    //set attributes to hold intents
    //pass to adapter to display on activity
    public void setNewListItems(){
        if (getIntent().hasExtra("eventName") &&getIntent().hasExtra("eventImage")&&getIntent().hasExtra("eventPrice")){
            String eName =  getIntent().getStringExtra("eventName");
            String eImage =  getIntent().getStringExtra("eventImage");
            String ePrice =  getIntent().getStringExtra("eventPrice");
            evntImg.add(eImage);
            evntNme.add(eName);
            evntPrc.add(ePrice);
            setTotal(ePrice);
            setDetails();
            setContinueShoppingBtn(eName,eImage,ePrice);
            setCheckoutBtn(eName,eImage,ePrice);
        }
    }

    //ListView
    public void setDetails(){
        listView = findViewById(R.id.list_items);
        CartNewAdapter cartNewAdapter = new CartNewAdapter(this, evntImg, evntNme, evntPrc);
        listView.setAdapter(cartNewAdapter);
    }
    //set intent on details on current view to the home screen. Ticket details. Not to loose information previous held in cart
    //hardcoded
    public void setContinueShoppingBtn(final String name, final String image, final String price){
        cart = findViewById(R.id.continue_shopping);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, Home.class);
                intent.putExtra("eventImage", image);
                intent.putExtra("eventName", name);
                intent.putExtra("eventPrice", price);
                startActivity(intent);
            }
        });
    }
    //set price of ticket in text view
    public void setTotal(String price){
        sum = findViewById(R.id.display_sum);
        sum.setText(price);
    }
    //proceed to checkout
    //pass intent of ticket details
    public void setCheckoutBtn(final String name, final String image, final String price){
        checkout = findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cart.this, Checkout.class);
                intent.putExtra("eventImage", image);
                intent.putExtra("eventName", name);
                intent.putExtra("eventPrice", price);
                startActivity(intent);
            }
        });
    }

}
