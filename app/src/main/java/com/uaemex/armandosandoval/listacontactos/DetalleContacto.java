package com.uaemex.armandosandoval.listacontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView nom, tel, ema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.nombre_param));
        String telefono = parametros.getString(getResources().getString(R.string.telefono_param));
        String email = parametros.getString(getResources().getString(R.string.correo_param));
        nom = (TextView) findViewById(R.id.tvNombre);
        tel = (TextView) findViewById(R.id.tvTel);
        ema = (TextView) findViewById(R.id.tvCorreo);
        nom.setText(nombre);
        tel.setText(telefono);
        ema.setText(email);
    }

    public void llamar(View view) {
        String telefno = tel.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefno)));

    }

    public void enviar_correo(View view) {
        String correo = ema.getText().toString();
        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.setData(Uri.parse("mailto:"));
        emailintent.putExtra(Intent.EXTRA_EMAIL,correo);
        emailintent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailintent,"Email"));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetalleContacto.this,MainActivity.class);
        startActivity(intent);
        /*
        el primer cambio en el repositorio es este


         */
        finish();

    }
}
