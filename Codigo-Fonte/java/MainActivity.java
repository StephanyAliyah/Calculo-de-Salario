package br.feccapccp.calculodesalario;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editSalario;
    RadioGroup rbGroup;
    RadioButton rb40, rb45, rb50;
    TextView texResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSalario = findViewById(R.id.editSalario);
        rbGroup = findViewById(R.id.rbGroup);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);
        texResultado = findViewById(R.id.texResultado);
    }

    public void enviar(View view) {
        String salarioTexto = editSalario.getText().toString().trim();

        if (salarioTexto.equals("")) {
            texResultado.setText("Digite um valor para o salário.");
            return;
        }

        // Substitui vírgula por ponto, se necessário
        salarioTexto = salarioTexto.replace(",", ".");

        // Conversão direta para número (cuidado: ainda pode causar erro se o texto for inválido)
        double salario = Double.parseDouble(salarioTexto);
        double novoSalario;

        if (rb40.isChecked()) {
            novoSalario = salario * 1.40;
        } else if (rb45.isChecked()) {
            novoSalario = salario * 1.45;
        } else if (rb50.isChecked()) {
            novoSalario = salario * 1.50;
        } else {
            texResultado.setText("Escolha um percentual.");
            return;
        }

        texResultado.setText(String.format("Novo salário: R$ %.2f", novoSalario));
    }
}
