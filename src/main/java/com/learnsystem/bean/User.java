package com.learnsystem.bean;

import java.util.*;

public class User {
    private String id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 联系方式
     */
    private String phonenumber;

    /**
     * 性别
     */
    private String gender;
    /**
     * 学号|工号
     */
    private String number;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 民族
     */
    private String nation;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 身份证号
     */
    private String idcardnumber;
    /**
     * 地址
     */
    private String address;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 用户拥有的角色集合
     */
    private List<Role> roles = new ArrayList<>();
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIdcardnumber() {
        return idcardnumber;
    }

    public void setIdcardnumber(String idcardnumber) {
        this.idcardnumber = idcardnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", gender='" + gender + '\'' +
                ", number='" + number + '\'' +
                ", birthday=" + birthday +
                ", nation='" + nation + '\'' +
                ", remarks='" + remarks + '\'' +
                ", idcardnumber='" + idcardnumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
