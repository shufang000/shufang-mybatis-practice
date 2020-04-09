package com.shufang.pojo;

public class Employee {

    private Integer empId;
    private String name;
    private Integer gender;
    private Integer age;
    private Department dept;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDeptId() {
        return dept;
    }

    public void setDeptId(Department dept) {
        this.dept = dept;
    }

    public Employee(Integer empId, String name, Integer gender, Integer age, Department dept) {
        this.empId = empId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dept = dept;
    }

    public Employee() {
    }
}
