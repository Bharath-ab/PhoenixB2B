package com.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.IBody;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LoginPojo implements IBody {
    private String username;
    private String password;

    public LoginPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toJson(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            return mapper.writeValueAsString(new LoginPojo(username, password));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public String toString() {
//        return "LoginPojo{" +
//                "username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
