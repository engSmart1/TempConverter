package com.thenewboston.tempconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText tempEditText;
    private Button fButton , celsiusButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempEditText = (EditText) findViewById(R.id.editText);
        fButton =(Button) findViewById(R.id.fBtnId);
        celsiusButton =(Button) findViewById(R.id.celsiusBtnId);
        showTempTextView =(TextView) findViewById(R.id.showResultTextView);

        //set up out Buttons (event listener)

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call convertToCelsius Method
                String editTextValue = tempEditText.getText().toString();
               // showTempTextView.setText(editTextValue);
                if (editTextValue.isEmpty()){
                    Toast.makeText(getApplicationContext() , " Plz Enter The Value" ,Toast.LENGTH_SHORT).show();
                } else {
                    double doubleEditText = Double.parseDouble(editTextValue);
                   // convertToCelsius(doubleEditText);
                    double convertValue = convertToCelsius(doubleEditText);
                    String myResultText = String.valueOf(round.format(convertValue));
                    showTempTextView.setText(myResultText + " C");
                }

            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call convertToFahrenheit Method
                String editTextValue2 = tempEditText.getText().toString();
                if (editTextValue2.isEmpty()){
                    Toast.makeText(getApplicationContext() ,"Plz Enter The Value!" ,Toast.LENGTH_SHORT).show();
                }else {

                    double doubleEditText2 = Double.parseDouble(editTextValue2);
                    //convertToFahrenheit(doubleEditText2);
                    double convertedValue = convertToFahrenheit(doubleEditText2);
                    String mtResultText = String.valueOf(round.format(convertedValue));

                    showTempTextView.setText(mtResultText + " F");
                }

            }
        });
    }
    public double convertToCelsius( double fahValue){
        //C = Fahrenheit -32 * 5/9 ;
        double resultCelsius;
        resultCelsius =(fahValue - 32) * 5/9 ;
        return resultCelsius;
    }
    public double convertToFahrenheit ( double celsiusValue){
        //F = celsius * 9/5 +32
        double resultFah ;
        resultFah = (celsiusValue * 9/5) + 32 ;

        return resultFah;
    }
}
