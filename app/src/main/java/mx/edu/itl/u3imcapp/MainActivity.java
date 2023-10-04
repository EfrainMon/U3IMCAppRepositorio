/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*             Activity que muestra el layout para calcular el IMC del usuario
:*
:*  Archivo     : MainActivity.java
:*  Autor       : Efraín Montalvo Sánchez           Num. Control: 20130810
:*  Fecha       : 29/Sep/2023
:*  Compilador  : Android Studio Giraffe 2022.3.1
:*  Descripcion : Activity que muestra el layout principal para calcular el IMC, así
:*                como con los métodos necesarios para poder hacer el cálculo del IMC
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3imcapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Button acercaDeButton = findViewById( R.id.acercaDeBtn );

        acercaDeButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent = new Intent( MainActivity.this, AcercaDeActivity.class );
                startActivity( intent );
            }
        });
    }

    //Cuadro de mensaje para mostrar el Índice de Masa Corporal del Usuario
    public void calcularBtnClick(View v) {

        EditText edtMasa       = findViewById( R.id.edtMasa );
        String   textoMasa     = edtMasa.getText().toString();
        EditText edtEstatura   = findViewById( R.id.edtEstatura );
        String   textoEstatura = edtEstatura.getText().toString();

        float masa = Float.parseFloat( textoMasa );
        float estatura = Float.parseFloat( textoEstatura );
        float imc = masa / ( estatura * estatura );
        String rango = "No se pudo determinar el rango";

        if ( imc < 15 ) {
            rango = "Delgadez muy severa.";
        } else if ( imc > 15 && imc <= 15.9 ) {
            rango = "Delgadez severa.";
        } else if ( imc > 15.9 && imc <= 18.4 ) {
            rango = "Delgadez.";
        } else if ( imc > 18.4 && imc <= 24.9 ) {
            rango = "Peso saludable.";
        } else if ( imc > 24.9 && imc <= 29.9 ) {
            rango = "Sobrepeso.";
        } else if ( imc > 29.9 && imc <= 34.9 ) {
            rango = "Obesidad moderada.";
        } else if ( imc > 34.9 && imc <= 39.9 ) {
            rango = "Obesidad severa.";
        } else if ( imc > 39.9 ) {
            rango = "Obesidad muy severa.";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setTitle( "Índice de Masa Corporal" );
        builder.setMessage( "IMC = " + imc + ", su condición de salud es: " + rango )
                .setPositiveButton( "Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i ) {
                    }
                })
                .create().show();
    }
}
