package com.pojo.frontdesk;

import com.utils.TestUtility;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerProductDetails {
    private String dop;
    private String serial_number;
    private String imei1;
    private String imei2;
    private String popurl;
    private int product_id;
    private int mst_model_id;

    public CustomerProductDetails(String dop, String serial_number, String imei1, String imei2, String popurl, int product_id, int mst_model_id) {
        this.dop = dop;
        this.serial_number = serial_number;
        this.imei1 = (imei1.length() == 14) ? imei1 : TestUtility.generateString(14);
        this.imei2 = (imei2.length() == 14) ? imei2 : TestUtility.generateString(14);
        this.popurl = popurl;
        this.product_id = product_id;
        this.mst_model_id = mst_model_id;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(new CustomerProductDetails(dop, serial_number, imei1, imei2, popurl, product_id, mst_model_id));
    }

    @Override
    public String toString() {
        return "CustomerProductPojo{" +
                "dop='" + dop + '\'' +
                ", serial_number='" + serial_number + '\'' +
                ", imei1='" + imei1 + '\'' +
                ", imei2='" + imei2 + '\'' +
                ", popurl='" + popurl + '\'' +
                ", product_id=" + product_id +
                ", mst_model_id=" + mst_model_id +
                '}';
    }
}
