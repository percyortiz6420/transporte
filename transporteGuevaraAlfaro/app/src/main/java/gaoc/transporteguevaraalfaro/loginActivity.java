package gaoc.transporteguevaraalfaro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gaoc.transporteguevaraalfaro.R;

public class loginActivity extends AppCompatActivity  {

    Button bt_ingresar;
    EditText et_usuario;
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usuario = (EditText) findViewById(R.id.txtusuario);
        et_password = (EditText) findViewById(R.id.txtclave);

        bt_ingresar = findViewById(R.id.btn_ingresar);

        bt_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                final String username = et_usuario.getText().toString();
                final String password = et_password.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){

                                int name = jsonResponse.getInt("piloto");
                                String tipo = jsonResponse.getString("tipo");

                                Intent intent = new Intent(loginActivity.this, Usuario.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("tipo",tipo);

                                loginActivity.this.startActivity(intent);


                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                                builder.setMessage("Error Inicio")
                                        .setNegativeButton("Retry",null)
                                        .create().show();


                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(username, password, responseListener );
                RequestQueue queue = Volley.newRequestQueue(loginActivity.this);
                queue.add(loginRequest);

            }
        });


    }
};