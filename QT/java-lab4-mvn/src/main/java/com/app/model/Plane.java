package com.app.model;

public class Plane {
    private int id;
    private String planeMaker;
    private String planeModel;
    private int planeCapacity;
    private String planeRegNo;


    public Plane(int planeId,String planeMaker,String planeModel,int planeCapacity,String planeReg) {
        this.id = planeId;
        this.planeMaker = planeMaker;
        this.planeModel = planeModel;
        this.planeCapacity = planeCapacity;
        this.planeRegNo = planeReg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaneMaker() {
        return planeMaker;
    }

    public void setPlaneMaker(String planeMaker) {
        this.planeMaker = planeMaker;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public int getPlaneCapacity() {
        return planeCapacity;
    }

    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity;
    }

    public String getPlaneRegNo() {
        return planeRegNo;
    }

    public void setPlaneRegNo(String planeRegNo) {
        this.planeRegNo = planeRegNo;
    }

    public String getString() {
        return "";
    }
}