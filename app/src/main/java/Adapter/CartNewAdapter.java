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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t0073651.ticketapp.Home;
import com.example.t0073651.ticketapp.R;

import java.util.ArrayList;
import java.util.List;

public class CartNewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> eventsImages;
    private ArrayList<String> eventsName;
    private ArrayList<String> eventsPrice;


    public CartNewAdapter(Context context, ArrayList<String> eventsImages, ArrayList<String> eventsName, ArrayList<String> eventsPrice) {
        this.context = context;
        this.eventsImages = eventsImages;
        this.eventsName = eventsName;
        this.eventsPrice = eventsPrice;
    }

    @Override
    public int getCount() {
        return eventsName.size();
    }

    @Override
    public Object getItem(int position) {
        return eventsName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_cart_item, null);
            holder = new ViewHolder();
            holder.cartImage = convertView.findViewById(R.id.cart_image);
            holder.cartEventName = convertView.findViewById(R.id.cart_event_name);
            holder.cartEventPrice = convertView.findViewById(R.id.cart_event_price);
            holder.selectCart = convertView.findViewById(R.id.checkItem);
            convertView.setTag(holder);
        }else {holder = (ViewHolder)convertView.getTag();}

        Glide.with(context).asBitmap().load(eventsImages.get(position)).into(holder.cartImage);
        holder.cartEventName.setText(eventsName.get(position));
        holder.cartEventPrice.setText(eventsPrice.get(position));

        holder.selectCart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){

                }else{

                }
            }
        });

        return convertView;
    }
    public class ViewHolder {
        public ImageView cartImage;
        public TextView cartEventName;
        public TextView cartEventPrice;
        public CheckBox selectCart;
    }


}
