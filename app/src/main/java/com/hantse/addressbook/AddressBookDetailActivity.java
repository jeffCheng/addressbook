package com.hantse.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by han-tsecheng on 3/22/18.
 */
public class AddressBookDetailActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView addressOne;
    private TextView addressTwo;
    private TextView city;
    private TextView state;
    private TextView zipCode;
    private TextView country;
    private TextView phoneNumber;
    private TextView email;

    private AddressBook addressBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        addressBook = getIntent().getExtras().getParcelable("addressBook");
        firstName =(TextView) findViewById(R.id.detail_firstName);
        lastName =(TextView) findViewById(R.id.detail_lastName);
        addressOne  =(TextView) findViewById(R.id.detail_addressOne);
        addressTwo  =(TextView) findViewById(R.id.detail_addressTwo);
        city  =(TextView) findViewById(R.id.detail_city);
        state =(TextView) findViewById(R.id.detail_state);
        zipCode=(TextView) findViewById(R.id.detail_zip_code);
        country=(TextView) findViewById(R.id.detail_country);
        phoneNumber =(TextView) findViewById(R.id.detail_phone_number);
        email =(TextView) findViewById(R.id.detail_email);

        firstName.setText(addressBook.getFirstName());
        lastName.setText(addressBook.getLastName());
        addressOne.setText(addressBook.getAddress1());
        addressTwo.setText(addressBook.getAddress2());
        city.setText(addressBook.getCity());
        state.setText(addressBook.getState());
        zipCode.setText(String.valueOf(addressBook.getZipCode()));
        country.setText(addressBook.getCountry());
        phoneNumber.setText(addressBook.getPhoneNumber());
        email.setText(addressBook.getEmail());

        Button button= (Button) findViewById(R.id.modify_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), UpdateAddressBookActivity.class);
                i.putExtra("addressBook",addressBook);
                startActivity(i);
            }
        });
    }
}
