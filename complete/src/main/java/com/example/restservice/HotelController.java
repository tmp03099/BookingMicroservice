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

    @PostMapping("hotel/list")
    Hotel newUploadHotel(@RequestBody Hotel newUploadHotel){
        return repository.save(newUploadHotel);
    }

//    @PutMapping("/hotel/{id}")
//    Hotel replaceHotel(@RequestBody Hotel newUploadHotel, @PathVariable Integer id){
////        return repository.findById(id)
////                .map(hotel -> {
////                    hotel.setId(newUploadHotel.getId());
////                    return repository.save(hotel);
////                });
//    }







}
