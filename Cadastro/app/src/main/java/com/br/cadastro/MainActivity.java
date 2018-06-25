package com.br.cadastro;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.br.cadastro.model.Contato;
import com.br.cadastro.service.ServiceContato;
import com.br.cadastro.service.ServiceProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ServiceContato serviceContato;
    private Button btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListar = (Button) findViewById(R.id.btn_listar);

        serviceContato = ServiceProvider.getService();

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                serviceContato.listaContatos().enqueue(new Callback<List<Contato>>() {
                    @Override
                    public void onResponse(Call<List<Contato>> call, Response<List<Contato>> response) {
                        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);

                        adb.setTitle("Lista de Usuários");
                        ArrayList<Contato> list = new ArrayList<>();
                        if(response.isSuccessful()){
                            List<Contato> lista = response.body();

                            for(Contato c : lista){
                                Log.i("TAG", "Lista: "+c.getNome());


                                adb.setMessage(c.getIdade());
                                adb.setMessage(c.getNome());


                            }


                            adb.show();



                        }else{
                            Toast.makeText(MainActivity.this, "Erro Aqui", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Contato>> call, Throwable t) {

                    }
                });
            }
        });


    }


}
