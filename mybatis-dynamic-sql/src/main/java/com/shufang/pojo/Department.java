package com.shufang.pojo;

import java.io.Serializable;
import java.util.List;

public class Department  implements Serializable {

    private Integer dId;
    private String dName;
    private List<Employee> employeeList;

    @Override
    public String toString() {
        return "Department{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department(Integer dId, String dName) {
        this.dId = dId;
        this.dName = dName;
    }

    public Department() {
    }
}
