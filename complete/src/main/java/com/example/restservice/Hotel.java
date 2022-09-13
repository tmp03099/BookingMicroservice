package com.example.restservice;


public class Hotel {

    private Long id;
    private String status;
    public String name;
    public Integer price;
    public Integer peopleNum;
    public Integer roomNum;


    Hotel(Long id, String status){
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public String getStatus(){
        return this.status;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setStatus(String status){
        this.status = status;
    }

1


}
