package br.edu.scl.ifsp.ads.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editNome, editTelefone, editEmail;
    private CheckBox checkBoxEmail;
    private RadioGroup radioGroupSexo;
    private Spinner spinnerEstado;

    private String[] estadosBrasileiros = {
            "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
            "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul",
            "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro",
            "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina",
            "São Paulo", "Sergipe", "Tocantins"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNome = findViewById(R.id.editNome);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);
        checkBoxEmail = findViewById(R.id.checkBoxEmail);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        spinnerEstado = findViewById(R.id.spinnerEstado);

        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        Spinner spinnerEstado = findViewById(R.id.spinnerEstado);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, estadosBrasileiros);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstado.setAdapter(adapter);


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFormulario();
            }
        });
    }

    private void clearFields() {
        editNome.setText("");
        editTelefone.setText("");
        editEmail.setText("");
        checkBoxEmail.setChecked(false);
        radioGroupSexo.clearCheck();
        spinnerEstado.setSelection(0);
    }

    private void saveFormulario() {
        String nome = editNome.getText().toString();
        String telefone = editTelefone.getText().toString();
        String email = editEmail.getText().toString();
        boolean ingressarEmail = checkBoxEmail.isChecked();

        RadioButton selectedRadioButton = findViewById(radioGroupSexo.getCheckedRadioButtonId());
        String sexo = selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";

        String estado = spinnerEstado.getSelectedItem().toString();

        Formulario formulario = new Formulario(nome, telefone, email, ingressarEmail, sexo, "", estado);

        Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show();
    }
}