package com.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="PLANES")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PLANE_ID")
    private long id;
    @Column(name="PLANE_MAKER")
    private String planeMaker;
    @Column(name="PLANE_MODEL")
    private String planeModel;
    @Column(name="CAPACITY")
    private int planeCapacity;
    @Column(name="REG_NO")
    private String planeRegNo;

    public Plane(){}

    public Plane(String planeMaker, String planeModel, int planeCapacity, String planeReg) {
        this.planeMaker = planeMaker;
        this.planeModel = planeModel;
        this.planeCapacity = planeCapacity;
        this.planeRegNo = planeReg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}