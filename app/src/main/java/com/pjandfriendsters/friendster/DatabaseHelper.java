package com.pjandfriendsters.friendster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jayem on 4/14/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context, "friendster.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE Friends " + "(id INTEGER PRIMARY KEY, name TEXT);");
    }

    public void onUpgrade(SQLiteDatabase db, int prevVersion, int newVersion){
        db.execSQL("DROP TABLE Friends");
        onCreate(db);
    }

    public boolean insertFriend(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        db.insert("Friends", null, contentValues);
        return true;
    }

    public void deleteFriend(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Friends", "id = ? ", new String[] {Integer.toString(id)});
    }

    public boolean editFriend(Integer id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        db.update("Friends", contentValues, "id = ? ", new String[] {Integer.toString(id)});
        return true;
    }

    public ArrayList<Friend> getAllFriends(List<Friend> src) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Friend> friends = new ArrayList<Friend>();
        Friend friend = new Friend();

        Cursor res = db.rawQuery("SELECT * FROM Friends", null);
        res.moveToFirst();

        while (res.isAfterLast() == false){
            if(src.isEmpty()){
                friend = new Friend(1, res.getString(res.getColumnIndex("name")));
            }else {
                friend = new Friend(src.get(src.size()-1).getId()+1, res.getString(res.getColumnIndex("name")));
            }


            friends.add(friend);
            res.moveToNext();
        }
        return friends;
    }
}
