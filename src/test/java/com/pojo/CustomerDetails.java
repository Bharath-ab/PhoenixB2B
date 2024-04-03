package com.pojo;

import com.utils.TestUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerDetails {
    private String first_name;
    private String last_name;
    private String mobile_number;
    private String mobile_number_alt;
    private String email_id;
    private String email_id_alt;

    public CustomerDetails(String first_name, String last_name, String mobile_number, String mobile_number_alt, String email_id, String email_id_alt) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile_number = (mobile_number.length() == 10) ? mobile_number : TestUtil.generateNumber(10);
        this.mobile_number_alt = (mobile_number_alt.length() == 10) ? mobile_number_alt : TestUtil.generateNumber(10);
        this.email_id = email_id;
        this.email_id_alt = email_id_alt;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(new CustomerDetails(first_name, last_name, mobile_number, mobile_number_alt, email_id, email_id_alt));
    }

    @Override
    public String toString() {
        return "CustomerPojo{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", mobile_number_alt='" + mobile_number_alt + '\'' +
                ", email_id='" + email_id + '\'' +
                ", email_id_alt='" + email_id_alt + '\'' +
                '}';
    }
}
