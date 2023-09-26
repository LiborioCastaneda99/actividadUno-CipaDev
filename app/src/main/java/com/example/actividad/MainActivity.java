package com.example.actividad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText editTextSalaryBase, editTextHoursExtras, editTextBonuses;
    private TextView textViewTotalSalary, textViewHealthDiscount, textViewPensionDiscount, textViewCompensationDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSalaryBase = findViewById(R.id.editTextSalaryBase);
        editTextHoursExtras = findViewById(R.id.editTextHoursExtras);
        editTextBonuses = findViewById(R.id.editTextBonuses);

        textViewTotalSalary = findViewById(R.id.textViewTotalSalary);

        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSalary();
            }
        });
    }

    private void calculateSalary() {
        // Obtener los valores de entrada
        double salaryBase = Double.parseDouble(editTextSalaryBase.getText().toString());
        double hoursExtras = Double.parseDouble(editTextHoursExtras.getText().toString());
        double bonuses = Double.parseDouble(editTextBonuses.getText().toString());

        // Realizar cálculos
        double hourValue = salaryBase / 192;
        double extrasValue = hourValue * 1.25;
        double valueBonuses = 0;
        if (bonuses == 1) {
            valueBonuses = salaryBase * 0.05;
        } else {
            valueBonuses = 0;
        }
        double extrasValueComplete = hoursExtras * extrasValue;
        double totalSalary = salaryBase + extrasValueComplete + valueBonuses;
        double healthDiscount = totalSalary * 0.035;
        double pensionDiscount = totalSalary * 0.04;
        double compensationDiscount = totalSalary * 0.01;
        double totalSalaryEnd = totalSalary - healthDiscount - pensionDiscount - compensationDiscount;

        // Mostrar resultados
        textViewTotalSalary.setText("Salario Total: " + totalSalaryEnd);
    }
}