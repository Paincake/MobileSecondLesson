package ru.mirea.ryazhevilya.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button buttonCalculate;
    private EditText editTextCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculate = findViewById(R.id.buttonCalculate);
        editTextCalculate = findViewById(R.id.editTextCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(
                        getApplicationContext(),
                        String.format("СТУДЕНТ 20 ГРУППА 7 Количество символов %d", editTextCalculate.getText().toString().length()),
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

}