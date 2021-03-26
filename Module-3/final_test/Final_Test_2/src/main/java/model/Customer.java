package model;

import java.sql.Date;

public class Customer {
    private String CusName;
    private Date cusBirthday;
    private String cusPhone;
    private String cusAddress;
    private String cusEmail;

    public Customer(String cusName, Date cusBirthday, String cusPhone, String cusAddress, String cusEmail) {
        CusName = cusName;
        this.cusBirthday = cusBirthday;
        this.cusPhone = cusPhone;
        this.cusAddress = cusAddress;
        this.cusEmail = cusEmail;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    public Date getCusBirthday() {
        return cusBirthday;
    }

    public void setCusBirthday(Date cusBirthday) {
        this.cusBirthday = cusBirthday;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }
}
