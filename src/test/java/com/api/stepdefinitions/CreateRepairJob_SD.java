package com.api.stepdefinitions;

import com.utils.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateRepairJob_SD extends TestUtil {

    TestUtil testUtil = new TestUtil();

    @Given("User fills device details as below")
    public void userFillsDeviceDetailsAsBelow(List<Map<String,String>> productDetails) {

        ArrayList<Object>mstOEMList = testUtil.iterateOverJSONArray(masterAPIResponse,"mst_oem");
        List<String> jsonObjectArrayToListString = TestUtil.convertObjectArrayToList(mstOEMList);
        ArrayList<Object>deviceName = testUtil.iterateOverJSONArray(jsonObjectArrayToListString.toString(),"name");
        ArrayList<Object>deviceID = testUtil.iterateOverJSONArray(jsonObjectArrayToListString.toString(),"id");

        List<String> deviceNameInString = TestUtil.convertObjectArrayToList(deviceName);

        ArrayList<String> userInputFields = new ArrayList<>();
        for(Map<String,String> pDetails : productDetails){
            if(pDetails.get("Mandatory Field ?").equalsIgnoreCase("true")){
                userInputFields.add(pDetails.get("Value"));
            }
        }
        System.out.println(userInputFields);
        if(deviceNameInString.stream().anyMatch(userInputFields.get(0)::equalsIgnoreCase) == false){
            Assert.fail(
                    "Device "+userInputFields.get(0) + " Not found Enter correct Manufacturer Name !!!\n"
                    +"Allowed Devices are "+deviceNameInString
            );
        }

    }

    @And("User fills problem details as below")
    public void userFillsProblemDetailsAsBelow(List<Map<String,String>> productDetails) {
        System.out.println(productDetails);
        for(Map<String,String> pDetails : productDetails){
            if(pDetails.get("Mandatory Field ?").equalsIgnoreCase("true"))
                System.out.println(pDetails.get("Remark"));
        }
        
    }

    @And("User fills customer details as below")
    public void userFillsCustomerDetailsAsBelow(List<Map<String,String>> productDetails) {
        System.out.println(productDetails);
        for(Map<String,String> pDetails : productDetails){
            if(pDetails.get("Mandatory Field ?").equalsIgnoreCase("true"))
                System.out.println(pDetails.get("Value"));
        }
    }
}
