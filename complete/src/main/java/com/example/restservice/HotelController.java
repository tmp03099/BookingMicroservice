package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {


    @GetMapping("/hotel/list")
    List<Hotel> all(){ //List use to contain Hotel type
        Hotel  hotel = new Hotel(1,"LeeKhung"); //hotel contain an instance of Hotel class.
        List<Hotel> hotelList = new ArrayList<>(); //Create an empty list type List<Hotel>
        hotelList.add(hotel);
        return hotelList;//need return list of hotel object
    }








}
