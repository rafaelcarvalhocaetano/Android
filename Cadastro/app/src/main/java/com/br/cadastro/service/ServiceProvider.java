package com.br.cadastro.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafael on 24/06/18.
 */

public class ServiceProvider {

    private static ServiceContato service;

    public static ServiceContato getService(){

        if(service == null){
           service = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.106:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(ServiceContato.class);
        }
        return service;
    }
}
