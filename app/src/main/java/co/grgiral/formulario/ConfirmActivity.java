package co.grgiral.formulario;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class ConfirmActivity extends AppCompatActivity {
    private TextView tvNombre;//= (TextView) findViewById(R.id.tvNombre);
    private TextView tvEmail;//l= (TextView) findViewById(R.id.tvEmail);
    private TextView tvTelefono;//= (TextView) findViewById(R.id.tvTelefono);
    private TextView tvDescripcion;
    private TextView tvFecha;
    private DatePicker datePicker;
    private int dia;
    private int mes;
    private int anio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Bundle parametros= getIntent().getExtras();
        String nombre= (String) parametros.get(getResources().getString(R.string.pnombre));
        String email= (String) parametros.get(getResources().getString(R.string.pemail));
        String telefono= String.valueOf(parametros.get(getResources().getString(R.string.ptelefono)));
        String descripcion= (String) parametros.get(getResources().getString(R.string.pdescripcion));
        datePicker = (DatePicker) parametros.get(getResources().getString(R.string.pfecha));
        dia = (int) parametros.get("day");
        mes = (int) parametros.get("month");
        anio = (int) parametros.get("year");

        tvNombre= (TextView) findViewById(R.id.tvnombrep);
        tvEmail= (TextView) findViewById(R.id.tvemailp);
        tvTelefono= (TextView) findViewById(R.id.tvtelp);
        tvFecha= (TextView) findViewById(R.id.tvfechap);
        tvDescripcion= (TextView) findViewById(R.id.tvdescripcionp);


        tvNombre.setText(nombre);
        tvEmail.setText(email);
        tvTelefono.setText(telefono);
        tvDescripcion.setText(descripcion);
        tvFecha.setText(fechaFormato(dia,mes,anio));

    }

    private String fechaFormato(int day, int month, int year){

        return day+"/"+month+"/"+year;
    }

    public void editar(View v){

        tvNombre=findViewById(R.id.tvnombrep);

        Intent intent = new Intent(ConfirmActivity.this, MainActivity.class);
        intent.putExtra(getResources().getString(R.string.pnombre),tvNombre.getText().toString());

        intent.putExtra(getResources().getString(R.string.ptelefono),tvTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfechayear), anio);
        intent.putExtra(getResources().getString(R.string.pfechamonth),mes);
        intent.putExtra(getResources().getString(R.string.pfechaday),dia);
        intent.putExtra(getResources().getString(R.string.pemail),tvEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion),tvDescripcion.getText().toString());
        startActivity(intent);




    }
}
