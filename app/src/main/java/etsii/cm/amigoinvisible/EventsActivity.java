package etsii.cm.amigoinvisible;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import dbms.getInfo;
import model.ClsEvent;

public class EventsActivity extends AppCompatActivity implements Serializable {
    private getInfo db = new getInfo();
    private ArrayList<ClsEvent> lstEvents;
    private ListView listado;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        listado = (ListView) findViewById(R.id.lstVwEvent);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Intent miIntent = new Intent(getApplicationContext(), ViewEventActivity.class);
                Comunicador.setObjeto(lstEvents.get(i));
                startActivity(miIntent);
               }
        });
        obtieneListaEventos();
    }

    public void obtieneListaEventos (){
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run() {
                lstEvents = db.getListEvents();
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                mostrarListado();
                            }
                        }
                );
            }
        });
        tr.start();
    }

    public void mostrarListado(){
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
        Adaptador_lista_eventos adapter = new Adaptador_lista_eventos(this, lstEvents);
        listado.setAdapter(adapter);
    }

}