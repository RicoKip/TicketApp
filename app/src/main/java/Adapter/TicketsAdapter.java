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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t0073651.ticketapp.R;

import java.util.ArrayList;
import java.util.List;

public class TicketsAdapter extends BaseAdapter {

    private ArrayList<String> eventsImages;
    private ArrayList<String> eventsName;
    private ArrayList<String> eventsUser;
    private ArrayList<String> eventsPrice;
    private Context context;

    public TicketsAdapter(ArrayList<String> tname, ArrayList<String> timage, ArrayList<String> tuser, ArrayList<String> tprice, Context context) {

        eventsName = tname;
        eventsImages = timage;
        eventsUser = tuser;
        eventsPrice = tprice;
        this.context = context;
    }

    @Override
    public int getCount() {

        return this.eventsName.size();
    }

    @Override
    public Object getItem(int position) {
        return this.eventsName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_ticket_card, null);
            holder = new ViewHolder();
            holder.eventTckImg = convertView.findViewById(R.id.ticket_image);
            holder.eventTckName = convertView.findViewById(R.id.name);
            holder.eventTckUser = convertView.findViewById(R.id.user);
            holder.eventTckPrice = convertView.findViewById(R.id.price);
            convertView.setTag(holder);
        }else {holder = (ViewHolder)convertView.getTag();}


        Glide.with(context).asBitmap().load(eventsImages.get(position)).into(holder.eventTckImg);
        holder.eventTckName.setText(eventsName.get(position));
        holder.eventTckUser.setText(eventsUser.get(position));
        holder.eventTckPrice.setText(eventsPrice.get(position));


        return convertView;
    }

    static class ViewHolder{
        public TextView eventTckName;
        public TextView eventTckUser;
        public TextView eventTckPrice;
        public ImageView eventTckImg;
    }


}
