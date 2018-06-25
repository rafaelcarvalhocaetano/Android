package com.br.cadastro.service;

import com.br.cadastro.model.Contato;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rafael on 24/06/18.
 */

public interface ServiceContato {

    @GET("lista")
    Call<List<Contato>> listaContatos();

    @GET("lista/{id}")
    Call<List<Contato>> getCodigo(@Query("id") Long id);
}
