package com.api.stepdefinitions;

import com.utils.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateRepairJob_SD extends TestUtil {


    @Given("User fills device details as below")
    public void userFillsDeviceDetailsAsBelow(List<Map<String, String>> productDetails) {

        List<String> deviceName = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_oem", "name");
        List<String> deviceOEMID = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_oem", "id");
        List<String> mstProductName = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_product", "name");
        List<String> mstProductID = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_product", "id");
        List<String> mstProduct_OEMID = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_product", "mst_oem_id");
        List<String> mstModelName = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_model", "name");
        List<String> mstModel_ProductID = TestUtil.deviceDependencyMap(masterAPIResponse, "mst_model", "mst_product_id");

        Map<String, String> OEMMap = new HashMap<>();
        for (int i = 0; i < deviceName.size(); i++) {
            OEMMap.put(deviceOEMID.get(i), deviceName.get(i));
        }

        Map<String, String> PRODUCTMAP = new HashMap<>();
        for (int i = 0; i < mstProduct_OEMID.size(); i++) {
            PRODUCTMAP.put(mstProductName.get(i), mstProduct_OEMID.get(i));
        }

        ArrayList<String> userInputFields = new ArrayList<>();
        for (Map<String, String> pDetails : productDetails) {
            if (pDetails.get("Mandatory Field ?").equalsIgnoreCase("true") && pDetails.get("Value").isBlank()) {
                Assert.fail(
                        "Mandatory Field " + pDetails.get("Device Details") + " is Blank please enter proper value"
                );
            }
            userInputFields.add(pDetails.get("Value"));
        }

        System.out.println(userInputFields);
        if (deviceName.stream().anyMatch(userInputFields.get(0)::equalsIgnoreCase) == false) {
            Assert.fail(
                    "Device " + userInputFields.get(0) + " Not a valid Manufacturer!!!\n"
                            + "Valid manufacturer are " + deviceName
            );
        }

        if (mstProductName.stream().anyMatch(userInputFields.get(1)::equalsIgnoreCase) == false) {
            Assert.fail(
                    "Device " + userInputFields.get(1) + " Not a valid Product Name!!!\n"
                            + "Valid product Name are " + mstProductName
            );
        }

        if (mstModelName.stream().anyMatch(userInputFields.get(2)::equalsIgnoreCase) == false) {
            Assert.fail(
                    "Device " + userInputFields.get(2) + " Not a valid Model Name !!!\n"
                            + "Valid model Name  are " + mstModelName
            );
        }

    }

    @And("User fills problem details as below")
    public void userFillsProblemDetailsAsBelow(List<Map<String, String>> productDetails) {
        System.out.println(productDetails);
        for (Map<String, String> pDetails : productDetails) {
            if (pDetails.get("Mandatory Field ?").equalsIgnoreCase("true")) {

            }
        }

    }

    @And("User fills customer details as below")
    public void userFillsCustomerDetailsAsBelow(List<Map<String, String>> productDetails) {

        for (Map<String, String> pDetails : productDetails) {
            if (pDetails.get("Mandatory Field ?").equalsIgnoreCase("true")) {

            }


        }
    }
}
