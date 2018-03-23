package com.hantse.addressbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by han-tsecheng on 3/20/18.
 */

public class AddressBookDAO {
    public static final String TABLE_NAME = "addressbook";
    public static final String KEY_ID = "_id";

    public static final String FIRSTNAME_COLUMN = "firstname";
    public static final String LASTNAME_COLUMN = "lastname";
    public static final String ADDRESS1_COLUMN = "address1";
    public static final String ADDRESS2_COLUMN = "address2";
    public static final String CITY_COLUMN = "city";
    public static final String STATE_COLUMN = "state";
    public static final String ZIPCODE_COLUMN = "zipcode";
    public static final String COUNTRY_COLUMN = "country";
    public static final String PHONENUMBER_COLUMN = "phonenumber";
    public static final String EMAIL_COLUMN = "email";


    private SQLiteDatabase db;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    KEY_ID 	+ 	" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FIRSTNAME_COLUMN 	+ 	" TEXT, " +
                    LASTNAME_COLUMN	+ 	" TEXT, " +
                    ADDRESS1_COLUMN	+ 	" TEXT, " +
                    ADDRESS2_COLUMN 	+ 	" TEXT, " +
                    CITY_COLUMN 	+ 	" TEXT, " +
                    STATE_COLUMN	+ 	" TEXT, " +
                    ZIPCODE_COLUMN	+ 	" INTEGER, " +
                    COUNTRY_COLUMN	+ 	" TEXT, " +
                    PHONENUMBER_COLUMN	+ 	" TEXT, " +
                    EMAIL_COLUMN	+ 	" TEXT)";


    // Get the DB resource
    public AddressBookDAO(Context context) {
        db = MyDBHelper.getDatabase(context);
    }

    public void close() {
        db.close();
    }

    public AddressBook insert(AddressBook addressBook) {
        ContentValues cv = new ContentValues();

        cv.put(	FIRSTNAME_COLUMN 	,addressBook.getFirstName());
        cv.put(	LASTNAME_COLUMN	,	addressBook.getLastName());
        cv.put(	ADDRESS1_COLUMN	,	addressBook.getAddress1());
        cv.put(	ADDRESS2_COLUMN 	,addressBook.getAddress2());
        cv.put(	CITY_COLUMN 	,	addressBook.getCity());
        cv.put(	STATE_COLUMN	,	addressBook.getState());
        cv.put(	ZIPCODE_COLUMN	,	addressBook.getZipCode());
        cv.put(	COUNTRY_COLUMN	,	addressBook.getCountry());
        cv.put(	PHONENUMBER_COLUMN	,addressBook.getPhoneNumber());
        cv.put(	EMAIL_COLUMN	,	addressBook.getEmail());

        long id = db.insert(TABLE_NAME, null, cv);
        addressBook.setId(id);
        return addressBook;
    }

    public boolean update(AddressBook addressBook) {
        ContentValues cv = new ContentValues();

        cv.put(	FIRSTNAME_COLUMN 	,addressBook.getFirstName());
        cv.put(	LASTNAME_COLUMN	,	addressBook.getLastName());
        cv.put(	ADDRESS1_COLUMN	,	addressBook.getAddress1());
        cv.put(	ADDRESS2_COLUMN 	,addressBook.getAddress2());
        cv.put(	CITY_COLUMN 	,	addressBook.getCity());
        cv.put(	STATE_COLUMN	,	addressBook.getState());
        cv.put(	ZIPCODE_COLUMN	,	addressBook.getZipCode());
        cv.put(	COUNTRY_COLUMN	,	addressBook.getCountry());
        cv.put(	PHONENUMBER_COLUMN	,addressBook.getPhoneNumber());
        cv.put(	EMAIL_COLUMN	,	addressBook.getEmail());

        String where = KEY_ID + "=" + addressBook.getId();
        return db.update(TABLE_NAME, cv, where, null) > 0;
    }

    public ArrayList<AddressBook> getAll() {
        ArrayList<AddressBook> result = new ArrayList<AddressBook>();
        Cursor cursor = db.query(
                TABLE_NAME, null, null, null, null, null, LASTNAME_COLUMN, null);

        while (cursor.moveToNext()) {
            result.add(getRecord(cursor));
        }
        cursor.close();
        return result;
    }

    public AddressBook getRecord(Cursor cursor) {
        AddressBook result = new AddressBook();

        result.setId(cursor.getLong(0));
        result.	setFirstName(cursor.getString(1	));
        result.	setLastName(cursor.getString(2	));
        result.	setAddress1(cursor.getString(3	));
        result.	setAddress2(cursor.getString(4	));
        result.	setCity(cursor.getString(5	));
        result.	setState(cursor.getString(6	));
        result.	setZipCode(cursor.getInt(7	));
        result.	setCountry(cursor.getString(8	));
        result.	setPhoneNumber(cursor.getString(9	));
        result.	setEmail(cursor.getString(10));

        return result;
    }

    public int getCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);

        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }

        return result;
    }


}
