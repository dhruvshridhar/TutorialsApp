package in.blogspot.tecnopandit.tutorialsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;

public class SqlHelperClass extends SQLiteOpenHelper {
    public SqlHelperClass(Context context) {
        super(context,"logindb",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE LOGINDETAILS( NAME TEXT NOT NULL, ID TEXT PRIMARY KEY, PIN INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists LOGINDETAILS");
        onCreate(sqLiteDatabase);
    }
    public long register(String name,String id,int pin)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("NAME",name);
        cv.put("ID",id);
        cv.put("PIN",pin);
        long isdone=db.insert("LOGINDETAILS",null,cv);
        return isdone;
    }
    public HashMap verify()
    {
        HashMap<String,Integer> mp=new HashMap<>();
        String selectQuery = "SELECT * FROM " + "LOGINDETAILS";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            //Loop through the table rows
            do {String name=cursor.getString(0);
                String id=cursor.getString(1);
                int capi=Integer.parseInt(cursor.getString(2));

                //Add movie details to list
                mp.put(id,capi);
            } while (cursor.moveToNext());
        }
        db.close();
        return mp;
    }
}
