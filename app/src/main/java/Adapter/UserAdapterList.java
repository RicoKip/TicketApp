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
import android.widget.TextView;

import com.example.t0073651.ticketapp.R;
import Database.UserDatabase;

import java.util.List;

public class UserAdapterList extends BaseAdapter {
    private List<UserDatabase> usersList;
    private Context context;
    public UserAdapterList(List<UserDatabase> uLst, Context c){
        this.usersList = uLst;
        this.context = c;
    }
    @Override
    public int getCount() {
        return this.usersList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.usersList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;

        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_row_details, null);
            holder = new ViewHolder();
            holder.FirstNameDT = view.findViewById(R.id.firstNameDetails);
            holder.LastNameDT = view.findViewById(R.id.lastNameDetails);
            holder.UserNameDT = view.findViewById(R.id.userNameDetails);
            holder.PassWordDT = view.findViewById(R.id.passwordDetails);
            holder.EmailDT = view.findViewById(R.id.emailDetails);
            view.setTag(holder);
        }else {holder = (ViewHolder)view.getTag();}

        UserDatabase userDatabase = usersList.get(i);
        holder.FirstNameDT.setText(userDatabase.getFirstName());
        holder.LastNameDT.setText(userDatabase.getLastName());
        holder.UserNameDT.setText(userDatabase.getUserName());
        holder.PassWordDT.setText(userDatabase.getPassWord());
        holder.EmailDT.setText(userDatabase.getEmail());

        return view;
    }
    static class ViewHolder{
        public TextView FirstNameDT;
        public TextView LastNameDT;
        public TextView UserNameDT;
        public TextView PassWordDT;
        public TextView EmailDT;


    }
}
