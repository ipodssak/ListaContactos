package com.uaemex.armandosandoval.listacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Armando","3213213","correo@correo"));
        contactos.add(new Contacto("Ana","324324324","correo@correo"));
        contactos.add(new Contacto("Luis","32425325","correo@correo"));
        contactos.add(new Contacto("Fernando","8657546","correo@correo"));
        ListView listContactos = (ListView) findViewById(R.id.lstcontactos);

        ArrayList<String> nombresContactos= new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContactos.add(contacto.getNombre());
        }
        listContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContactos));

        listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getString(R.string.nombre_param),contactos.get(i).getNombre());
                intent.putExtra(getString(R.string.telefono_param),contactos.get(i).getTelefono());
                intent.putExtra(getString(R.string.correo_param),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });

    }
}
