package com.example.calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText Ingreso;
    private Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btMas, btMenos, btMultiplicacion, btDivision, btBorrar, btPunto, btIgual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        bt1 = findViewById(R.id.bt1);           bt2             = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);           bt4             = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);           bt6             = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);           bt8             = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);           bt0             = findViewById(R.id.bt0);
        btPunto = findViewById(R.id.btpunto);   btBorrar        = findViewById(R.id.btBorrar);
        btMas = findViewById(R.id.btMas);       btMenos         = findViewById(R.id.btMenos);
        btIgual = findViewById(R.id.btIgual);   Ingreso         = findViewById(R.id.txIngreso);
        btDivision = findViewById(R.id.btDivision);
        btMultiplicacion = findViewById(R.id.btMultiplicacion);

        bt1.setOnClickListener(this);        bt2.setOnClickListener(this);        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);        bt5.setOnClickListener(this);        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);        bt8.setOnClickListener(this);        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);        btPunto.setOnClickListener(this);    btBorrar.setOnClickListener(this);
        btMas.setOnClickListener(this);      btMenos.setOnClickListener(this);    btMultiplicacion.setOnClickListener(this);
        btDivision.setOnClickListener(this); btIgual.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private String Texto, Operador, Num1, Num2;

    private void ingresoTexto(String prm){
        Texto = Ingreso.getText().toString().trim();
        //Valida el ingreso de mas de un "."
        if (prm == ".") {
            if (Texto.indexOf(".") > 0  ) {
                prm = "";
            }
        }
        //Despliega Texto Seleccionado
        Ingreso.setText(Texto + prm);
    }

    private void ingresoOperador(String prm){
        if (Ingreso.getText().toString().length() == 0){
            Toast.makeText(getBaseContext(), "Error: Debe ingresar un número!", Toast.LENGTH_SHORT).show();
        }
        else {
            Operador = prm;
            Num1 = Ingreso.getText().toString();
            Ingreso.setText("");
        }
    }

    private void resultado(){
        Num2 = Ingreso.getText().toString();
        double res = 0;
        switch (Operador){
            case "+":
                res = Double.parseDouble(Num1) + Double.parseDouble(Num2);
                Ingreso.setText(String.valueOf(res));
                break;
            case "-":
                res = Double.parseDouble(Num1) - Double.parseDouble(Num2);
                Ingreso.setText(String.valueOf(res));
                break;
            case "*":
                res = Double.parseDouble(Num1) * Double.parseDouble(Num2);
                Ingreso.setText(String.valueOf(res));
                break;
            case "/":
                if ((Num2 == "0") || (Num2.length() == 0)) {
                    Toast.makeText(getBaseContext(), "Error: División entre 0!", Toast.LENGTH_SHORT).show();
                }
                res = Double.parseDouble(Num1) / Double.parseDouble(Num2);
                Ingreso.setText(String.valueOf(res));
                break;
        }
    }

    private void borrar(){
        Ingreso.setText("");
        Operador = "";
        Num1 = "";
        Num2 = "";
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bt0:
                ingresoTexto("0"); break;
            case R.id.bt1:
                ingresoTexto("1"); break;
            case R.id.bt2:
                ingresoTexto("2"); break;
            case R.id.bt3:
                ingresoTexto("3"); break;
            case R.id.bt4:
                ingresoTexto("4"); break;
            case R.id.bt5:
                ingresoTexto("5"); break;
            case R.id.bt6:
                ingresoTexto("6"); break;
            case R.id.bt7:
                ingresoTexto("7"); break;
            case R.id.bt8:
                ingresoTexto("8"); break;
            case R.id.bt9:
                ingresoTexto("9"); break;
            case R.id.btpunto:
                ingresoTexto("."); break;
            case R.id.btMas:
                ingresoOperador("+"); break;
            case R.id.btMenos:
                ingresoOperador("-"); break;
            case R.id.btMultiplicacion:
                ingresoOperador("*"); break;
            case R.id.btDivision:
                ingresoOperador("/"); break;
            case R.id.btIgual:
                resultado(); break;
            case R.id.btBorrar:
                borrar(); break;
        }
    }
}
