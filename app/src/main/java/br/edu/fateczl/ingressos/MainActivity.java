package br.edu.fateczl.ingressos;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private RadioButton rbIng;
    private RadioButton rbVip;
    private Button btnComprar;
    private EditText etFun;
    private RadioGroup rgIngressos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbIng = findViewById(R.id.rbIng);
        rbIng.setChecked(true);

        rbVip = findViewById(R.id.rbVip);
        rgIngressos = findViewById(R.id.rgIngressos);

        etFun = findViewById(R.id.etFun);
        etFun.setVisibility(View.GONE);

        rgIngressos.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbVip) {
                etFun.setVisibility(View.VISIBLE);
            } else {
                etFun.setVisibility(View.GONE);
            }
        });

        btnComprar = findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(op -> comprar());
        
    }

    private void comprar() {
        Bundle bundle = new Bundle();
        boolean eVIP = false;
        if(rbVip.isChecked()){
            eVIP = true;
            bundle.putString("funcao", etFun.getText().toString());
        }
        bundle.putBoolean("vip", eVIP);
        mudar(bundle);
    }

    private void mudar(Bundle bundle) {
        Intent i = new Intent(this, Exibir.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}