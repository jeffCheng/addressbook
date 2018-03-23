package com.hantse.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by han-tsecheng on 3/22/18.
 */

public class UpdateAddressBookActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText addressOne;
    private EditText addressTwo;
    private EditText city;
    private EditText state;
    private EditText zipCode;
    private EditText country;
    private EditText phoneNumber;
    private EditText email;

    private AddressBookDAO addressBookDAO;
    private AddressBook addressBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        addressBook = getIntent().getExtras().getParcelable("addressBook");
        firstName =(EditText) findViewById(R.id.upd_firstName);
        lastName =(EditText) findViewById(R.id.upd_lastName);
        addressOne  =(EditText) findViewById(R.id.upd_addressOne);
        addressTwo  =(EditText) findViewById(R.id.upd_addressTwo);
        city  =(EditText) findViewById(R.id.upd_city);
        state =(EditText) findViewById(R.id.upd_state);
        zipCode=(EditText) findViewById(R.id.upd_zip_code);
        country=(EditText) findViewById(R.id.upd_country);
        phoneNumber =(EditText) findViewById(R.id.upd_phone_number);
        email =(EditText) findViewById(R.id.upd_email);

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

        Button button= (Button) findViewById(R.id.upd_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName =(EditText) findViewById(R.id.upd_firstName);
                lastName =(EditText) findViewById(R.id.upd_lastName);
                addressOne  =(EditText) findViewById(R.id.upd_addressOne);
                addressTwo  =(EditText) findViewById(R.id.upd_addressTwo);
                city  =(EditText) findViewById(R.id.upd_city);
                state =(EditText) findViewById(R.id.upd_state);
                zipCode=(EditText) findViewById(R.id.upd_zip_code);
                country=(EditText) findViewById(R.id.upd_country);
                phoneNumber =(EditText) findViewById(R.id.upd_phone_number);
                email =(EditText) findViewById(R.id.upd_email);
                addressBook.setFirstName(firstName.getText().toString());
                addressBook.setLastName(lastName.getText().toString());
                addressBook.setAddress1(addressOne.getText().toString());
                addressBook.setAddress2(addressTwo.getText().toString());
                addressBook.setCity(city.getText().toString());
                addressBook.setCountry(country.getText().toString());
                addressBook.setState(state.getText().toString());
                addressBook.setZipCode(Integer.parseInt(zipCode.getText().toString()));
                addressBook.setPhoneNumber(phoneNumber.getText().toString());
                addressBook.setEmail(email.getText().toString());
                addressBookDAO = new AddressBookDAO(getApplicationContext());
                addressBookDAO.update(addressBook);
                Toast.makeText(getApplicationContext(),"updated to DB:"+addressBook.getId(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
