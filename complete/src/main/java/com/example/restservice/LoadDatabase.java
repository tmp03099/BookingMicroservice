package com.example.restservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Configuration
public class LoadDatabase {

    @Autowired
    ResourceLoader resourceLoader;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(HotelRepository repository){

        return args -> {
            //create variable to store Hotel
            Hotel standRoom = new Hotel(1,"");

            //Set value in standRoom
            standRoom.name= "LAPALACE STANDARD ROOM";
            standRoom.price = 90;
            standRoom.kindBed = "QUEEN BED";
            standRoom.peopleNum = 2;
            standRoom.breakfast = "BREAKFAST";
            standRoom.tv = "TV";
            standRoom.pool = "POOL";
            standRoom.bath = "BATH";
            standRoom.parking = "PARKING";
            standRoom.laundry = "LAUNDRY";
            standRoom.condition = true;


            Hotel deluxeRoom = new Hotel(2,"");

            //Set value in deluxeRoom
            deluxeRoom.name= "LAPALACE DELUXE ROOM";
            deluxeRoom.price = 115;
            deluxeRoom.kindBed = "KING BED";
            deluxeRoom.peopleNum = 2;
            deluxeRoom.breakfast = "BREAKFAST";
            deluxeRoom.tv = "TV";
            deluxeRoom.pool = "POOL";
            deluxeRoom.bath = "BATH";
            deluxeRoom.parking = "PARKING";
            deluxeRoom.laundry = "LAUNDRY";
            deluxeRoom.condition = true;

            Hotel deluxeRoom2 = new Hotel(3,"");

            //Set value in deluxeRoom2
            deluxeRoom2.name= "LAPALACE DELUXE VIEW ROOM";
            deluxeRoom2.price = 135;
            deluxeRoom2.kindBed = "QUEEN BED";
            deluxeRoom2.peopleNum = 4;
            deluxeRoom2.breakfast = "BREAKFAST";
            deluxeRoom2.tv = "TV";
            deluxeRoom2.pool = "POOL";
            deluxeRoom2.bath = "BATH";
            deluxeRoom2.parking = "PARKING";
            deluxeRoom2.laundry = "LAUNDRY";
            deluxeRoom2.condition = true;

            Hotel familyRoom = new Hotel(4,"");

            //Set value in deluxeRoom2
            familyRoom.name= "LAPALACE FAMILY ROOM";
            familyRoom.price = 170;
            familyRoom.kindBed = "KING BED";
            familyRoom.peopleNum = 4;
            familyRoom.breakfast = "BREAKFAST";
            familyRoom.tv = "TV";
            familyRoom.pool = "POOL";
            familyRoom.bath = "BATH";
            familyRoom.parking = "PARKING";
            familyRoom.laundry = "LAUNDRY";
            familyRoom.condition = true;

            Hotel familyRoom2 = new Hotel(5,"");

            //Set value in deluxeRoom2
            familyRoom2.name= "LAPALACE FANTASTIC ROOM";
            familyRoom2.price = 210;
            familyRoom2.kindBed = "QUEEN BED";
            familyRoom2.peopleNum = 6;
            familyRoom2.breakfast = "BREAKFAST";
            familyRoom2.tv = "TV";
            familyRoom2.pool = "POOL";
            familyRoom2.bath = "BATH";
            familyRoom2.parking = "PARKING";
            familyRoom2.laundry = "LAUNDRY";
            familyRoom2.condition = true;


            //save to repository
            log.info("Preloading " + repository.save(standRoom));
            log.info("Preloading " + repository.save(deluxeRoom));
            log.info("Preloading " + repository.save(deluxeRoom2));
            log.info("Preloading " + repository.save(familyRoom));
            log.info("Preloading " + repository.save(familyRoom2));

            // read data from file
            String strLine ="";
            try{
                Resource resource = resourceLoader.getResource("classpath:hotel_info.txt");
                BufferedReader fileReader = new BufferedReader(new FileReader(resource.getFile()));

                while ((strLine = fileReader.readLine())!= null){

                    //Create an instance of object
                    Hotel newInstanceHotel = new Hotel(0, "");

                    StringTokenizer delimiter = new StringTokenizer(strLine,"#");

                    while (delimiter.hasMoreTokens()){
                        newInstanceHotel.roomNum = Integer.valueOf(delimiter.nextToken());
                        newInstanceHotel.name = delimiter.nextToken();
                        newInstanceHotel.kindBed = delimiter.nextToken();
                        newInstanceHotel.peopleNum = Integer.valueOf(delimiter.nextToken());
                        newInstanceHotel.setStatus(delimiter.nextToken());
                        newInstanceHotel.price = Integer.valueOf(delimiter.nextToken());

                    }
                    repository.save(newInstanceHotel);
                }

            }
            catch (IOException error){
                System.out.println("Error on file read: " + error);
            }

        };
    }


}
