package com.driver.model;

import javax.persistence.*;

@Entity
public class Driver {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId;
    
//    private String name;
    private String mobile;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "cab_id")
    private Cab cab;
    
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

//    public String getName() {
//        return name;
//    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Driver(Integer driverId,String mobile, String password, Cab cab) {
        this.driverId = driverId;
       // this.name = name;
        this.mobile = mobile;
        this.password = password;
        this.cab = cab;
    }

    public Driver() {
    }
}
