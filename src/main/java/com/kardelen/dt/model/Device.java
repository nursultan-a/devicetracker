package com.kardelen.dt.model;


import javax.persistence.*;

/**
 * @author Nursultan Abdrakypov
 * @email nuronjava@gmail.com
 */


@Entity // This tells Hibernate to make a table out of this class
public class Device {
    @Id
    private String id;

    private String phoneNumber;

    private String registerTime;

    private String lastUpdate;

    private String currentStatus;

    private String responseMsg;

    @Override
    public String toString(){
        return String.format(
                "ID: "+this.getId()+
                "\nNumber: "+this.getPhoneNumber()+
                "\nStatus: "+this.getCurrentStatus()+
                "\nResponse Msg: "+this.getResponseMsg()+
                "\nRegister Time: "+this.getRegisterTime()+
                "\nLast Update: "+this.getLastUpdate()
        );
    }
//    Getter and Setters

    public String getId() { return id;  }

    public void setId(String id) { this.id = id;}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}