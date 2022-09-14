package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@Component
public class HotelInformation {

    @Autowired
    ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        readHotelFile();
    }

    public void readHotelFile(){
        List<Hotel> newList = new ArrayList<>();
        try{
            Hotel newInstanceHotel = new Hotel(0, "");

            Resource resource = resourceLoader.getResource("classpath:hotel_info.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(resource.getFile()));

            String line = fileReader.readLine();
            System.out.println(line);
            while (line != null){
                StringTokenizer delimiter = new StringTokenizer(line,"#");
                newInstanceHotel.roomNum = Integer.valueOf(delimiter.nextToken());
                newInstanceHotel.name = delimiter.nextToken();
                newInstanceHotel.bedNum = Integer.valueOf(delimiter.nextToken());
                newInstanceHotel.kindBed = delimiter.nextToken();
                newInstanceHotel.peopleNum = Integer.valueOf(delimiter.nextToken());
                newInstanceHotel.status = delimiter.nextToken();
                newInstanceHotel.price = Integer.valueOf(delimiter.nextToken());
            }

        }
        catch (IOException error){
            System.out.println("Error on file read: " + error);
        }
        for (Hotel hotelArray: newList){
            System.out.println(hotelArray);
        }
    }



}
