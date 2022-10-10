package com.example.restservice;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {

    private @Id @GeneratedValue Integer id;
    private String status;
    public Integer roomNum;
    public String name;
    public String kindBed;
    public Integer peopleNum;
    public Integer price;
    public String breakfast;
    public String tv;
    public String pool;
    public String bath;
    public String laundry;
    public String parking;
    public boolean condition;

    //create default constructor
    Hotel(){}

    //create another constructor
    Hotel(Integer id, String status){
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public String getStatus(){ return this.status;}

    public void setId(Integer id){
        this.id = id;
    }

    public void setStatus(String status){
        this.status = status;
    }


    @Override
    public String toString(){
        return "Hotel id = " + id + ", name " + name + " roomNum " + roomNum +
                " kindBed " + kindBed + " status " + status + "price " + price+
                " breakfast "+ breakfast + " tv " + tv + " pool " + pool +
                " bath " + bath + " laundry " + laundry + " parking " + parking ;
    }


}
