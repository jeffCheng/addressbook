package com.hantse.addressbook;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by han-tsecheng on 3/19/18.
 */

public class AddressBook  implements Parcelable {
    long id;
    String lastName;
    String firstName;
    String address1;
    String address2;
    String city;
    String state;
    int zipCode;
    String country;
    String phoneNumber;
    String email;

    public AddressBook(){

    };

    public AddressBook(String lastName, String firstName){
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Parcelable
    @Override
    public int describeContents() { //Define the kind of object that you gonna parcel,
        return 0;
    }

    //Parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(lastName);
        dest.writeString(firstName);
        dest.writeString(address1);
        dest.writeString(address2);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeInt(zipCode);
        dest.writeString(country);
        dest.writeString(phoneNumber);
        dest.writeString(email);
    }

    protected AddressBook(Parcel in) {
        id = in.readLong();
        lastName = in.readString();
        firstName = in.readString();
        address1 = in.readString();
        address2 = in.readString();
        city = in.readString();
        state = in.readString();
        zipCode = in.readInt();
        country = in.readString();
        phoneNumber = in.readString();
        email = in.readString();
    }

    public static final Creator<AddressBook> CREATOR = new Creator<AddressBook>() {
        @Override
        public AddressBook createFromParcel(Parcel in) {
            return new AddressBook(in);
        }

        @Override
        public AddressBook[] newArray(int size) {
            return new AddressBook[size];
        }
    };
}
