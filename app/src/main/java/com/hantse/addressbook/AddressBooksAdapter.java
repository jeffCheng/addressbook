package com.hantse.addressbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by han-tsecheng on 3/21/18.
 */

//ArrayAdapter
public class AddressBooksAdapter  extends ArrayAdapter<AddressBook> {


    private int resource;
    private ArrayList<AddressBook> addressBook;

    // initialize ArrayAdapter
    public AddressBooksAdapter(Context context, int resource, ArrayList<AddressBook> addressBooks) {
        super(context, 0, addressBooks);
        this.resource = resource;
        this.addressBook = addressBooks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        AddressBook addressBook = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_addressbook, parent, false);
        }
        // Lookup view for data population
        TextView seLastName = (TextView) convertView.findViewById(R.id.se_LastName);
        TextView seFirstName = (TextView) convertView.findViewById(R.id.se_FirstName);
        // Populate the data into the template view using the data object
        seLastName.setText(addressBook.lastName);
        seFirstName.setText(addressBook.firstName);
        // Return the completed view to render on screen
        return convertView;
    }
}
