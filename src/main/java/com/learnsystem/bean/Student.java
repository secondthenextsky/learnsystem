package com.learnsystem.bean;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 学生
 */
public class Student {
    private int id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String gender;
    /**
     * 学号
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
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String major;
    /**
     * 身份证号
     */
    private String idcardnumber;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系方式
     */
    private String phonenumber;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 入学时间
     */
    private Date intendtime;
    /**
     * 备注
     */
    private String remarks;

    private Set<Role> roles = new LinkedHashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getIntendtime() {
        return intendtime;
    }

    public void setIntendtime(Date intendtime) {
        this.intendtime = intendtime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", number='" + number + '\'' +
                ", birthday=" + birthday +
                ", nation='" + nation + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", idcardnumber='" + idcardnumber + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", intendtime=" + intendtime +
                ", remarks='" + remarks + '\'' +
                ", roles=" + roles +
                '}';
    }
}
