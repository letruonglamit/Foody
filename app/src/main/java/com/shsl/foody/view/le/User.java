package com.shsl.foody.view.le;

/**
 * Created by CuuVuiVe on 5/10/2017.
 */

public class User {
    private int number, review;
    private String name, role, time, phonenumber, address, sex, money;

    public int getReview()
    {
        return review;
    }
    public void setReview(int review)
    {
        this.review=review;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role=role;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number=number;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money=money;
    }

    public String getTime() {
        return time;
    }

    public void setTime (String time) {
        this.time=time;
    }


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber (String phonenumber) {
        this.phonenumber=phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex (String sex) {
        this.sex=sex;
    }


}