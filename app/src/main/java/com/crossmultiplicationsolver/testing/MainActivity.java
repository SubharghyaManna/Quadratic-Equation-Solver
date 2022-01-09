package com.crossmultiplicationsolver.testing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText a1,a2,b1,b2,c1,c2;
    private TextView x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "This Application is made by - Subharghya Manna", Toast.LENGTH_SHORT).show();

        button = findViewById(R.id.button);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a1.onEditorAction(EditorInfo.IME_ACTION_DONE);
                String s_a1 = a1.getText().toString();
                String s_a2 = a2.getText().toString();
                String s_b1 = b1.getText().toString();
                String s_b2 = b2.getText().toString();
                String s_c1 = c1.getText().toString();
                String s_c2 = c2.getText().toString();
                if(s_a1.isEmpty() || s_a2.isEmpty() || s_b1.isEmpty() || s_b2.isEmpty() || s_c1.isEmpty() || s_c2.isEmpty()){
                    alert("All field must be filled !!");
                    return;
                }
                double d_a1 = Double.parseDouble(s_a1);
                double d_a2 = Double.parseDouble(s_a2);
                double d_b1 = Double.parseDouble(s_b1);
                double d_b2 = Double.parseDouble(s_b2);
                double d_c1 = Double.parseDouble(s_c1);
                double d_c2 = Double.parseDouble(s_c2);
                if(d_a1/d_a2 == d_b1/d_b2){
                    if(d_a1/d_a2 == d_c1/d_c2){
                        alert("Infinitely many points found");
                    }
                    else{
                        alert("No general point found");
                    }
                }
                else{
                    double d_x = (d_b1*d_c2 - d_c1*d_b2)/(d_a1*d_b2 - d_b1*d_a2);
                    double d_y = (d_a2*d_c1 - d_a1*d_c2)/(d_a1*d_b2 - d_b1*d_a2);
                    x.setText(Double.toString(d_x));
                    y.setText(Double.toString(d_y));
                }
            }
        });
    }

    private void alert(String message){
        AlertDialog dig = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Warning")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                })
                .create();
        dig.show();
    }
}