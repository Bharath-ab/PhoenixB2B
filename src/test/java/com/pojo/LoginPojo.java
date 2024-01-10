package com.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginPojo {
    private String username;
    private String password;

    public LoginPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(new LoginPojo(username, password));
    }

    @Override
    public String toString() {
        return "LoginPojo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
