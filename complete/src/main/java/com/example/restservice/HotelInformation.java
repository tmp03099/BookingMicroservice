package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
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

    List<Hotel> hotelList = new ArrayList<>();

    @PostConstruct
    public void init() {
        readHotelFile();
    }

    public void readHotelFile(){
        int count = 0;
        String strLine ="";

        try{
            Resource resource = resourceLoader.getResource("classpath:hotel_info.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(resource.getFile()));

            while ((strLine = fileReader.readLine())!= null){

                //Create an instance of object
                Hotel newInstanceHotel = new Hotel(0, "");

                StringTokenizer delimiter = new StringTokenizer(strLine,"#");

                while (delimiter.hasMoreTokens()){
                    count++;
                    newInstanceHotel.roomNum = Integer.valueOf(delimiter.nextToken());
                    newInstanceHotel.name = delimiter.nextToken();
                    newInstanceHotel.kindBed = delimiter.nextToken();
                    newInstanceHotel.peopleNum = Integer.valueOf(delimiter.nextToken());
                    newInstanceHotel.setStatus(delimiter.nextToken());
                    newInstanceHotel.price = Integer.valueOf(delimiter.nextToken());

                }
                hotelList.add(newInstanceHotel);
                System.out.println(hotelList);
            }

        }
        catch (IOException error){
            System.out.println("Error on file read: " + error);
        }



    }


}
