package gaoc.transporteguevaraalfaro;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class gas extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final String CERO = "0";
    private static final String BARRA = "/";
    public int dia, mes, anio;
    EditText fechaEntrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas);
        fechaEntrada = (EditText)findViewById(R.id.fechaGas);
        fechaEntrada.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(fechaEntrada==v){
            final Calendar calendar = Calendar.getInstance();
            dia=calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);
            /*DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    fechaEntrada.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
                    ,dia, mes, anio);*/

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    final int mesActual = month + 1;
                    String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                    String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                    fechaEntrada.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
                }
            }, anio, mes, dia);

            datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
