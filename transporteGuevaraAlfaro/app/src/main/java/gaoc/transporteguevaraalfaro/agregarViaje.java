package gaoc.transporteguevaraalfaro;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class agregarViaje extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private static final String CERO = "0";
    private static final String BARRA = "/";

    EditText fechaEntrada, contenedor, cliente, poliza;
    RequestQueue requestQueue;
    public int dia, mes, anio;
    String insertarUrl="";
    Button guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_viaje);

        guardar = (Button)findViewById(R.id.guardar);
        contenedor = (EditText)findViewById(R.id.contenedor);
        cliente = (EditText)findViewById(R.id.cliente);
        poliza = (EditText)findViewById(R.id.poliza);
        fechaEntrada = (EditText)findViewById(R.id.fechaCarga);
        fechaEntrada.setOnClickListener(this);


        requestQueue = Volley.newRequestQueue(getApplicationContext());

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertarUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams()throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<>();

                        parameters.put("contenedor", contenedor.getText().toString());
                        parameters.put("fechaCarga", fechaEntrada.getText().toString());
                        parameters.put("cliente", cliente.getText().toString());
                        parameters.put("poliza", poliza.getText().toString());



                        return  parameters;


                    }
                };
                requestQueue.add(request);
            }
        });
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
