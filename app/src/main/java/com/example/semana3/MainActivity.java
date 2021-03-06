package com.example.semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<InformacionAtributos> datos;
    RecyclerView rvReciclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvReciclerView = findViewById(R.id.rvReciclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvReciclerView.setLayoutManager(llm);
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        listaInformacion();
        inicializaAdaptador();
    }

    public void inicializaAdaptador(){
        AdaptadorCardView adaptador = new AdaptadorCardView(datos,this);
        rvReciclerView.setAdapter(adaptador);
    }

    public void listaInformacion(){
        datos = new ArrayList<>();
        datos.add(new InformacionAtributos("Rafaela Arandia", R.drawable.perrito_arreglado_1,"1"));
        datos.add(new InformacionAtributos("Carmen Ayala",R.drawable.perro_arreglado_2,"2"));
        datos.add(new InformacionAtributos("Giovanny Arandia",R.drawable.perro_arreglado_3,"3"));
        datos.add(new InformacionAtributos("Wilmer Arandia",R.drawable.perro_arreglado_4,"4"));
        datos.add(new InformacionAtributos("Andres Arandia",R.drawable.perro_arreglado_5,"5"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.estrellita) {
            Intent intent = new Intent(rvReciclerView.getContext(), Interface2.class);
            rvReciclerView.getContext().startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
