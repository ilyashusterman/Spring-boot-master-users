package com.ilya.shusterman.repository;

import com.ilya.shusterman.beans.User;

import java.io.*;

/**
 * Created by ilya on 26/01/2017.
 */
public class MongoDataBaseHandler {

    public static void readFromFile(UserRepository repository ,File file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
            while((line =br.readLine())!=null)
                {
                    String[] arr = line.split(" ");
                    repository.save(new User(arr[0], arr[1],arr[2]));
                }
            System.out.println(repository.findAll());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
