package gaoc.transporteguevaraalfaro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.toolbox.StringRequest;

public class Usuario extends AppCompatActivity {
    TextView tvusuario, tvdpi, tvtipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        tvdpi = findViewById(R.id.TextV_nombre);
        tvusuario = findViewById(R.id.TextV_usuario);
        tvtipo = findViewById(R.id.TextV_tipo_user);


        Intent intent = getIntent();
        int dpi = intent.getIntExtra("name",-1);
        String username = intent.getStringExtra("username");
        String tipo = intent.getStringExtra("tipo");

        tvdpi.setText(dpi+"");
        tvusuario.setText(username);
        tvtipo.setText(tipo);




    }
}
