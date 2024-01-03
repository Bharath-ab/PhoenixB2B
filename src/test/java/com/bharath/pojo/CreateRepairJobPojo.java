package com.bharath.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class CreateRepairJobPojo {
    private int mst_service_location_id;
    private int mst_platform_id;
    private int mst_warrenty_status_id;
    private int mst_oem_id;
    private CustomerDetails customer;
    private CustomerAddress customer_address;
    private CustomerProductDetails customer_product;
    ArrayList<Object> problems = new ArrayList<>();

    public CreateRepairJobPojo(int mst_service_location_id, int mst_platform_id, int mst_warrenty_status_id, int mst_oem_id, CustomerDetails customer, CustomerAddress customer_address, CustomerProductDetails customer_product, ArrayList<Object> problems) {
        this.mst_service_location_id = mst_service_location_id;
        this.mst_platform_id = mst_platform_id;
        this.mst_warrenty_status_id = mst_warrenty_status_id;
        this.mst_oem_id = mst_oem_id;
        this.customer = customer;
        this.customer_address = customer_address;
        this.customer_product = customer_product;
        this.problems = problems;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(new CreateRepairJobPojo(mst_service_location_id, mst_platform_id, mst_warrenty_status_id, mst_oem_id, customer, customer_address, customer_product, problems));
    }

    @Override
    public String toString() {
        return "CreateJobPojo{" +
                "mst_service_location_id=" + mst_service_location_id +
                ", mst_platform_id=" + mst_platform_id +
                ", mst_warrenty_status_id=" + mst_warrenty_status_id +
                ", mst_oem_id=" + mst_oem_id +
                ", customer=" + customer +
                ", customer_address=" + customer_address +
                ", customer_product=" + customer_product +
                ", problems=" + problems +
                '}';
    }
}
