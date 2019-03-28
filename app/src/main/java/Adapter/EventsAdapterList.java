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
package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t0073651.ticketapp.Cart;
import com.example.t0073651.ticketapp.PageEvent;
import com.example.t0073651.ticketapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;

public class EventsAdapterList extends RecyclerView.Adapter<EventsAdapterList.ViewHolder> {

    private Context context;
    private ArrayList<String> eventsListImages;
    private ArrayList<String> eventsListName;
    private ArrayList<String> eventsListLocation;
    private ArrayList<String> eventsListDate;
    private ArrayList<String> eventsListPrice;

    public EventsAdapterList(ArrayList<String> eLst, ArrayList<String> dDt, ArrayList<String> imGes, ArrayList<String> loCat, ArrayList<String> evPrice, Context cont){

        eventsListName = eLst;
        eventsListImages = imGes;
        eventsListDate = dDt;
        eventsListLocation = loCat;
        eventsListPrice = evPrice;

        context = cont;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        return new ViewHolder(view);
    }
    //new item added to list
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(context).asBitmap().load(eventsListImages.get(i)).into(viewHolder.eventViewImage);
        viewHolder.textViewName.setText(eventsListName.get(i));
        viewHolder.textViewLoc.setText(eventsListLocation.get(i));
        viewHolder.textViewDate.setText(eventsListDate.get(i));
        viewHolder.textViewPrice.setText(eventsListPrice.get(i));
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = new Intent(context, PageEvent.class);
                intent.putExtra("eventImage", eventsListImages.get(i));
                intent.putExtra("eventName", eventsListName.get(i));
                intent.putExtra("eventLoc", eventsListLocation.get(i));
                intent.putExtra("eventDate", eventsListDate.get(i));

                context.startActivity(intent);
            }
        });
        viewHolder.bookEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Cart.class);
                intent.putExtra("eventImage", eventsListImages.get(i));
                intent.putExtra("eventLoc", eventsListLocation.get(i));
                intent.putExtra("eventDate", eventsListDate.get(i));
                intent.putExtra("eventName", eventsListName.get(i));
                intent.putExtra("eventPrice", eventsListPrice.get(i));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return eventsListName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView eventViewImage;
        public TextView textViewName;
        public TextView textViewDate;
        public TextView textViewLoc;
        public TextView textViewPrice;
        public Button bookEvent;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.event_title);
            eventViewImage = itemView.findViewById(R.id.eventImageCard);
            textViewDate = itemView.findViewById(R.id.event_Date);
            textViewLoc = itemView.findViewById(R.id.event_name);
            textViewPrice = itemView.findViewById(R.id.ticket_price);
            bookEvent = itemView.findViewById(R.id.book_event);

            relativeLayout = itemView.findViewById(R.id.card_image);
        }
    }


}
