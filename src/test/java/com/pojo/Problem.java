package com.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class Problem {

    private HashMap<String, Object> problem = new HashMap<String, Object>();
    private int id;
    private String remark;

    public Problem(int id, String remark) {
        this.id = id;
        this.remark = remark;
        problem.put("id",id);
        problem.put("remark",remark);
    }

    public HashMap<String, Object> getProblem() {
        return problem;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        return mapper.writeValueAsString(new Problem(id,remark));
    }

    @Override
    public String toString() {
        return "Problems{" +
                "problems=" + problem +
                '}';
    }
}
