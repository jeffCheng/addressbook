package com.hantse.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAddressBookActivity extends AppCompatActivity {

    private EditText addFirstName;
    private EditText addLastName;
    private EditText addAddressOne;
    private EditText addAddressTwo;
    private EditText city;
    private EditText state;
    private EditText zipCode;
    private EditText country;
    private EditText phoneNumber;
    private EditText email;

    private AddressBookDAO addressBookDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button button= (Button) findViewById(R.id.add_adbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFirstName = (EditText) findViewById(R.id.add_firstName);
                addLastName = (EditText) findViewById(R.id.add_lastName);
                addAddressOne = (EditText) findViewById(R.id.add_addressOne);
                addAddressTwo = (EditText) findViewById(R.id.add_addressTwo);
                city = (EditText) findViewById(R.id.city);
                state = (EditText) findViewById(R.id.state);
                zipCode = (EditText) findViewById(R.id.zip_code);
                country = (EditText) findViewById(R.id.country);
                phoneNumber = (EditText) findViewById(R.id.phone_number);
                email = (EditText) findViewById(R.id.email);
                AddressBook addressBook = new AddressBook();
                addressBook.setFirstName(addFirstName.getText().toString());
                addressBook.setLastName(addLastName.getText().toString());
                addressBook.setAddress1(addAddressOne.getText().toString());
                addressBook.setAddress2(addAddressTwo.getText().toString());
                addressBook.setCity(city.getText().toString());
                addressBook.setCountry(country.getText().toString());
                addressBook.setState(state.getText().toString());
                addressBook.setZipCode(Integer.parseInt(zipCode.getText().toString()));
                addressBook.setPhoneNumber(phoneNumber.getText().toString());
                addressBook.setEmail(email.getText().toString());
                addressBookDAO = new AddressBookDAO(getApplicationContext());
                addressBook = addressBookDAO.insert(addressBook);
                Toast.makeText(getApplicationContext(),"added to DB:"+addressBook.getId(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        //findViews();
    }
    /*
    private void findViews() {
        addFirstName = (EditText) findViewById(R.id.add_firstName);
        addLastName = (EditText) findViewById(R.id.add_lastName);
    }

    public void add(View v){

    }*/
}
