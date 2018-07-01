package co.grgiral.formulario;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

import static co.grgiral.formulario.R.string.datepicker;
import static co.grgiral.formulario.R.string.ptelefono;

public class MainActivity extends AppCompatActivity {


    private EditText etNombre;//= (TextView) findViewById(R.id.tvNombre);
    private EditText etEmail;//l= (TextView) findViewById(R.id.tvEmail);
    private EditText etTelefono;//= (TextView) findViewById(R.id.tvTelefono);
    private EditText etDescripcion;
    private DatePicker dpfecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=findViewById(R.id.etNombre);
        etDescripcion=findViewById(R.id.etDescripcion);
        etEmail= findViewById(R.id.etEmail);
        dpfecha= findViewById(R.id.dpfecha);
        etTelefono=findViewById(R.id.etTelefono);


        Bundle parametros = getIntent().getExtras();
        if( parametros!= null){
            String nombre = parametros.get(getResources().getString(R.string.pnombre)).toString();
            int dia = (int) parametros.get(getResources().getString(R.string.pfechaday));
            int mes = (int) parametros.get(getResources().getString(R.string.pfechamonth));
            int anio = (int) parametros.get(getResources().getString(R.string.pfechayear));
            String telefono= (String) parametros.get(getResources().getString(R.string.ptelefono));
            String descripcion= (String) parametros.get(getResources().getString(R.string.pdescripcion));
            String email= (String) parametros.get(getResources().getString(R.string.pemail));


            etNombre.setText(nombre);
            dpfecha.updateDate(anio,mes,dia);
            etDescripcion.setText(descripcion);
            etEmail.setText(email);
            etTelefono.setText(telefono);
        }

    }

    public void siguiente(View v){
        etNombre=findViewById(R.id.etNombre);
        etDescripcion=findViewById(R.id.etDescripcion);
        etEmail= findViewById(R.id.etEmail);
        dpfecha= findViewById(R.id.dpfecha);
        etTelefono=findViewById(R.id.etTelefono);

        Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre),etNombre.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono),etTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfechayear), (dpfecha.getYear()));
        intent.putExtra(getResources().getString(R.string.pfechamonth),dpfecha.getMonth());
        intent.putExtra(getResources().getString(R.string.pfechaday),dpfecha.getDayOfMonth());
        intent.putExtra(getResources().getString(R.string.datepicker),dpfecha.getDayOfMonth());
        intent.putExtra(getResources().getString(R.string.pemail),etEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion),etDescripcion.getText().toString());
        startActivity(intent);
    }
}
