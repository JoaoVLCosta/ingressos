package br.edu.fateczl.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.nio.Buffer;

public class Exibir extends AppCompatActivity {
    /*
     *@author:<JOÃO VITOR LIMA COSTA>
     */

    private final float TAXA = 3f;
    private TextView tvShow;
    private Button btnVoltar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibir);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        tvShow = findViewById(R.id.tvShow);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(op -> voltar());

        if(bundle.getBoolean("vip")){
            exibir(bundle.getString("funcao"));
        } else {
            exibir();
        }
        
    }

    private void exibir(String funcao){
        IngressoVIP ingresso = new IngressoVIP();
        StringBuffer buffer = new StringBuffer(getString(R.string.txt_tipoVip));
        buffer.append("\n").append(getString(R.string.txt_codigo)).append(" ").append(ingresso.getCodigo());
        buffer.append("\n").append(getString(R.string.txt_funcao)).append(" ").append(funcao);
        buffer.append("\n").append(getString(R.string.txt_custo)).append(" ").append(Ingresso.getValor());
        buffer.append("\n").append(getString(R.string.txt_taxa));
        buffer.append("\n").append(getString(R.string.txt_taxaVIP));
        buffer.append("\n").append(getString(R.string.txt_total)).append(ingresso.valorFinal(TAXA));

        tvShow.setText(buffer.toString());
    }

    private void exibir(){
        Ingresso ingresso = new Ingresso();
        StringBuffer buffer = new StringBuffer(getString(R.string.txt_tipoNormal));
        buffer.append("\n").append(getString(R.string.txt_codigo)).append(" ").append(ingresso.getCodigo());
        buffer.append("\n").append(getString(R.string.txt_custo)).append(" ").append(Ingresso.getValor());
        buffer.append("\n").append(getString(R.string.txt_taxa));
        buffer.append("\n").append(getString(R.string.txt_total)).append(ingresso.valorFinal(TAXA));

        tvShow.setText(buffer.toString());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}