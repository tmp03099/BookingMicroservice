package com.example.restservice;


public class Hotel {

    private Integer id;
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



}
