package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private final HotelRepository repository;

    HotelController(HotelRepository repository){
        this.repository = repository;
    }

    @Autowired
    HotelInformation hotelInformation;

    @GetMapping("/hotel/list")
    List<Hotel> all(){ //List use to contain Hotel type
        /**
         Hotel hotel = new Hotel(1,"abc"); //hotel contain an instance of Hotel class.
         List<Hotel> hotelList = new ArrayList<>(); //Create an empty list type List<Hotel>
         hotelList.add(hotel);
         return hotelList;//need return list of hotel object
         */
        //return hotelInformation.hotelList;
        return repository.findAll();
    }

    //get child property in Hotel parent list
    @GetMapping("/hotel/detail")
    List<Hotel> newDetailHotel(){

        //create detail variable to store full list of Hotel in repository
        List<Hotel> detail = repository.findAll();

        /**To get the small list that I want in Hotel list
         * create new empty list to store value
         * then compare and add to new list
         */
        List<Hotel> newList = new ArrayList<>();

        //loop Hotel list to get value
        detail.forEach((n) -> {
            System.out.println("A: " + n);

            //compare and add to newList
            if(n.condition == true){
                newList.add(n);
            }

        });


        System.out.println("B: " + newList);
        return newList;
    }




    @GetMapping("/hotel/{id}")
    Hotel one(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException());
    }

    @PostMapping("hotel/list")
    Hotel newUploadHotel(@RequestBody Hotel newUploadHotel){
        return repository.save(newUploadHotel);
    }

    @PutMapping("/hotel/{id}")
    Hotel replaceHotel(@RequestBody Hotel newUploadHotel, @PathVariable Integer id){
        return repository.findById(id)
                .map(hotel -> {
                    hotel.setId(newUploadHotel.getId());
                    hotel.setStatus(newUploadHotel.getStatus());
                    return repository.save(hotel);
                }).orElseGet(() -> {
                    newUploadHotel.setId(id);
                    return repository.save(newUploadHotel);
                });
    }

    @DeleteMapping("/hotel/{id}")
    void deleteHotel(@PathVariable Integer id){
        repository.deleteById(id);
    }





}
