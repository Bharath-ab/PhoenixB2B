package com.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.pojo.LoginPojo;
import com.pojo.frontdesk.*;
import io.restassured.http.Header;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static io.restassured.RestAssured.given;

public class TestUtility {
    public static String generateString(int lengthOfString) {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "").toUpperCase().substring(0, lengthOfString);
    }

    public static String generateNumber(int length) {
        Random random = new Random();
        long nextLong = Math.abs(random.nextLong());
        return String.valueOf(nextLong).substring(0, length);
    }

    public static String convertToJson(Object referenceObject) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(referenceObject);
    }

    public static String generateTokenFor(Role role) throws JsonProcessingException {

        LoginPojo loginRequestPOJO = null;
        if (role == Role.FD) {
            loginRequestPOJO = new LoginPojo("iamfd", "password");
        } else if (role == Role.SUP) {
            loginRequestPOJO = new LoginPojo("iamsup", "password");
        } else if (role == Role.ENG) {
            loginRequestPOJO = new LoginPojo("iameng", "password");
        } else if (role == Role.QC) {
            loginRequestPOJO = new LoginPojo("iamqc", "password");
        } else if (role == Role.FST) {
            loginRequestPOJO = new LoginPojo("iamfst3", "password");
        } else if (role == Role.CC) {
            loginRequestPOJO = new LoginPojo("iamcc", "password");
        }
        Header myHeader = new Header("Content-Type", "application/json");
        String jsonData = convertToJson(loginRequestPOJO);
        return given().header(myHeader).and().body(jsonData).log().all().when().post("/v1/login").then().log()
                .all().extract().path("data.token");
    }

    public static String generateCreateJobData() throws JsonProcessingException {
        Faker faker = new Faker();
        int mstServiceLocationId = 0;
        int mstPlatformId = 2;
        int mstWarrantyStatusId = 1;
        int mstOemId = 2;
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String mobileNumber = String.valueOf(faker.phoneNumber());
        String alternateMobileNumber = String.valueOf(faker.phoneNumber());
        String emailId = "bharath.varma@outlook.com";
        String alternateEmailId = "bharath.varma@outlook.com";
        String flatNumber = faker.address().buildingNumber();
        String apartmentName = faker.address().latitude();
        String streetName = faker.address().streetName();
        String landmark = faker.address().streetName();
        String area = faker.address().streetAddress();
        String pinCode = faker.address().zipCode();
        String country = faker.address().country();
        String state = faker.address().state();
        String dop = generateISODate();
        String serialNumber = faker.numerify("4#############");
        String imei1 = faker.numerify("4#############");
        String imei2 = faker.numerify("4#############");
        String popUrl = generateISODate();
        int productId = 3;
        int mstModelId = 3;
        CustomerDetails customerDetails = new CustomerDetails(firstName, lastName, mobileNumber, alternateMobileNumber, emailId, alternateEmailId);
        CustomerAddress customerAddress = new CustomerAddress(flatNumber, apartmentName, streetName, landmark, area, pinCode, country, state);
        CustomerProductDetails customerProductDetails = new CustomerProductDetails(dop, serialNumber, imei1, imei2, popUrl, productId, mstModelId);
        ArrayList<Object> problems = new ArrayList<>();
        Problem pb = new Problem(2, faker.pokemon().name());
        Problem pb1 = new Problem(1, faker.pokemon().name());
        Problem pb2 = new Problem(1, faker.pokemon().name());
        Problem pb3 = new Problem(1, faker.pokemon().name());
        problems.add(pb.getProblem());
        problems.add(pb1.getProblem());
        problems.add(pb2.getProblem());
        problems.add(pb3.getProblem());
        CreateRepairJobPojo createRepairJobPojo = new CreateRepairJobPojo(mstServiceLocationId, mstPlatformId, mstWarrantyStatusId, mstOemId, customerDetails, customerAddress, customerProductDetails, problems);
        return convertToJson(createRepairJobPojo);
    }

    public static String generateISODate() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        return df.format(new Date());
    }
}
