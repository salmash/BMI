package edu.cs.birzeit.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText height ;
    private EditText weight ;
    private EditText bmi ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews ();
    }

    private void setupViews() {
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bmi = findViewById(R.id.bmi);
    }

    public void btnOnClick(View view) {
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        double c = (w/h/h)*10000;
        bmi.setText(c+"");
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

        if(c<18.5){
            Toast.makeText(this,"Under Weight!",Toast.LENGTH_LONG).show();
        }

        else if(c>18.5 && c<24.9){
            Toast.makeText(this,"Normal Weight!",Toast.LENGTH_LONG).show();
        }
        else if(c>25 && c<29.9){
            Toast.makeText(this,"Over Weight!",Toast.LENGTH_LONG).show();
        }
        else if(c>=30){
            Toast.makeText(this,"Obesity!",Toast.LENGTH_LONG).show();
        }
    }
}