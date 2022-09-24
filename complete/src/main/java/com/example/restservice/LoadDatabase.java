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
//            log.info("Preloading " + repository.save(new Hotel(0, "empty")));
//            log.info("Preloading " + repository.save(new Hotel(2, "empty")));
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
                        newInstanceHotel.bedNum = Integer.valueOf(delimiter.nextToken());
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
