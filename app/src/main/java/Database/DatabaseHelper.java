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
package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



public class DatabaseHelper extends SQLiteOpenHelper {
    //When database schema changes increment version
    //set attributes
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TicketApp.db";
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_1 = "Id";
    private static final String COLUMN_2 = "FirstName";
    private static final String COLUMN_3 = "LastName";
    private static final String COLUMN_4 = "Username";
    private static final String COLUMN_5 = "Password";
    private static final String COLUMN_6 = "Email";

    //constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_2 + " FNAME," + COLUMN_3 + " LNAME," + COLUMN_4 + " UNAME," + COLUMN_5 + " PASS," + COLUMN_6 + " EMAIL)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //discards data and starts over
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void insertData(UserDatabase userDatabase){
        SQLiteDatabase db = this.getWritableDatabase();
        //write values retrieved from user into the database
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, userDatabase.getFirstName());
        values.put(COLUMN_3, userDatabase.getLastName());
        values.put(COLUMN_4, userDatabase.getUserName());
        values.put(COLUMN_5, userDatabase.getPassWord());
        values.put(COLUMN_6, userDatabase.getEmail());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //retrieve all user accounts stored on device
    //androidtutorials hub reference approached
    //adding users to a list
    public List<UserDatabase> getAllUsers(){
        //array of columns
        String[] columns = {COLUMN_1, COLUMN_2, COLUMN_3, COLUMN_4, COLUMN_5, COLUMN_6};

        List<UserDatabase> userList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        //query to get data from table
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);

        //adding to list from table
        if (cursor.moveToFirst()){
            do {
                UserDatabase userDatabase = new UserDatabase();
                userDatabase.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_1))));
                userDatabase.setFirstName(cursor.getString(cursor.getColumnIndex(COLUMN_2)));
                userDatabase.setLastName(cursor.getString(cursor.getColumnIndex(COLUMN_3)));
                userDatabase.setUserName(cursor.getString(cursor.getColumnIndex(COLUMN_4)));
                userDatabase.setPassWord(cursor.getString(cursor.getColumnIndex(COLUMN_5)));
                userDatabase.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_6)));

                userList.add(userDatabase);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return userList;
    }

    //updating user data
    /*public void update(UserDatabase userDatabase){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2, userDatabase.getFirstName());
        values.put(COLUMN_3, userDatabase.getLastName());
        values.put(COLUMN_4, userDatabase.getUserName());
        values.put(COLUMN_5, userDatabase.getPassWord());
        values.put(COLUMN_6, userDatabase.getEmail());
        db.update(TABLE_NAME, values, COLUMN_1 + " = ?", new String[]{String.valueOf(userDatabase.getId())});
        db.close();
    }

    //delete data
    public void delete(UserDatabase userDatabase){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_1 + " = ?", new String[]{String.valueOf(userDatabase.getId())});
    }*/

    //check existing user during loging. user validation
    public boolean check(String username, String password){
        //fetch columns
        String[] columns = {COLUMN_1};

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_4 + " = ?" + " AND " + COLUMN_5 + " = ?";
        String[] selectionArgs = {username, password};

        //create a query with conditon for checking database
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
    }

    //check username in registration activity
    public boolean checkUserName(String username){
        //fetch columns
        String[] columns = {COLUMN_1};

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_4 + " = ?";
        String[] selectionArgs = {username};

        //create a query with conditon for checking database
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
    }

}
