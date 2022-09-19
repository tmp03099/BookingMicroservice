package com.example.restservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    public List<Hotel> listAllHotel(){
        return hotelRepository.findAll();
    }

    

}
