package model;

import java.sql.Date;

public class Room {
    private int roomId;
    private String tenantName;
    private String phone;
    private Date startDate;
    private PaymentType paymentType;
    private String note;

    public Room(String tenantName, String phone, Date startDate, PaymentType paymentType, String note) {
        this.tenantName = tenantName;
        this.phone = phone;
        this.startDate = startDate;
        this.paymentType = paymentType;
        this.note = note;
    }

    public Room(int roomId, String tenantName, String phone, Date startDate, PaymentType paymentType, String note) {
        this.roomId = roomId;
        this.tenantName = tenantName;
        this.phone = phone;
        this.startDate = startDate;
        this.paymentType = paymentType;
        this.note = note;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
