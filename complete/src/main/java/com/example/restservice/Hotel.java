package com.example.restservice;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {

    private @Id @GeneratedValue Integer id;
    public String status;
    public Integer roomNum;
    public String name;
    public Integer bedNum;
    public String kindBed;
    public Integer peopleNum;
    public Integer price;


    Hotel(Integer id, String status){
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    @Override
    public String toString(){
        return "Hotel id = " + id + ", name " + name + " roomNum " + roomNum +
                "bedRum " + bedNum + " kindBed " + kindBed + " status " + status;
    }


}
