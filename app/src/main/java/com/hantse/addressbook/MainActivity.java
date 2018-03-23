package com.hantse.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView item_list;
    private AddressBooksAdapter addressBooksAdapter;
    private ArrayList<AddressBook> addressBooks;

    private AddressBookDAO addressBookDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressBookDAO = new AddressBookDAO(getApplicationContext());
        addressBooks = addressBookDAO.getAll();
//        AddressBook addressBook1 = new AddressBook("Jack","Sam");
//        AddressBook addressBook2 = new AddressBook("Amy","Lin");
//        addressBooks.add(addressBook1);
//        addressBooks.add(addressBook2);

        //ListView to create each item and Adapter to decorate the item
        item_list= (ListView) findViewById(R.id.listview);
        addressBooksAdapter = new AddressBooksAdapter(this, R.layout.item_addressbook, addressBooks);
        item_list.setAdapter(addressBooksAdapter);

        //OnItemClickListener
        item_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,AddressBookDetailActivity.class);
                // Use Intent to develier the object
                i.putExtra("addressBook",addressBooksAdapter.getItem(position));
                //start another activity
                startActivity(i);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddAddressBookActivity.class));
            }
        });
    }

     /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
