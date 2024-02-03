package com.pojo.frontdesk;

import com.utils.TestUtility;

public class CustomerAddress {
    private String flat_number;
    private String apartment_name;
    private String street_name;
    private String landmark;
    private String area;
    private String pincode;
    private String country;
    private String state;

    public CustomerAddress(String flat_number, String apartment_name, String street_name, String landmark, String area, String pincode, String country, String state) {
        this.flat_number = flat_number;
        this.apartment_name = apartment_name;
        this.street_name = street_name;
        this.landmark = landmark;
        this.area = area;
        this.pincode = (pincode.length() == 6) ? pincode : TestUtility.generateNumber(6).toString();
        this.country = country;
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomerAddressPojo{" +
                "flat_number='" + flat_number + '\'' +
                ", apartment_name='" + apartment_name + '\'' +
                ", street_name='" + street_name + '\'' +
                ", landmark='" + landmark + '\'' +
                ", area='" + area + '\'' +
                ", pincode='" + pincode + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
