package txusblack.domilicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private ImageView logo;
    private EditText telefono,sufijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Vinculamos la imagen si queremos hacerle alguna modificación
        logo = (ImageView) findViewById(R.id.imageView);
        logo.setOnClickListener(this);
        // Incluimos telefono para validar opciones
        telefono = (EditText) findViewById(R.id.Telefono);
        sufijo = (EditText) findViewById(R.id.Sufijo);
    }

    // Con esto ponemos la pantalla completa y con un gesto
    // podemos volver a mostrar el menú de navegación y la barra de notificaciones
    @Override
    public void onWindowFocusChanged(boolean hasFocas){
        super.onWindowFocusChanged(hasFocas);
        View decorView = getWindow().getDecorView();
        if(hasFocas){
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }

    @Override
    public void onClick(View view) {
        String usuario = ((EditText)findViewById(R.id.Telefono)).getText().toString();
        if(usuario.equals("3")){
            Intent activacion = new Intent(Login.this,CrearCuenta.class);
            startActivity(activacion);
        }
        else{
            Toast.makeText(getApplicationContext(), "Usuario Incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    /*
    switch (view.getId()){
            case R.id.imageView:
                Intent intent1 = new Intent(this, Activation.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
     */
}
