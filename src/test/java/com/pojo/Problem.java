package com.pojo;

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

    @Override
    public String toString() {
        return "Problems{" +
                "problems=" + problem +
                '}';
    }
}
