package firstapp.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;

import android.view.View;
import android.widget.Button;
import  android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        //Variable create for calcualtion referne XMl compoments
        TextView txtResult;
        EditText ht, wt,inches;
        Button btn;

        //find Xmlcomponet by ID by Activity XMl file
        wt=findViewById(R.id.editWeight);
        ht=findViewById(R.id.edithieght);
        inches=findViewById(R.id.editIN);
        txtResult=findViewById(R.id.Result);
        btn=findViewById(R.id.cal);

        //functionality provide on user button clicks
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //IT variab;e stored user input data in these variable
             int ft= Integer.parseInt(ht.getText().toString());
             int inch=Integer.parseInt(inches.getText().toString());
             int w1 =Integer.parseInt(wt.getText().toString());

                    //total hieght
                    int totalin = ft*12+inch;
                    //total centimeter
                    double totalCm= totalin*2.23;
                    //total meter
                    double totalM=totalCm/100;


                    //calature Body MASS
                double bmi = w1/ (totalM * totalM);


                //showing the weight result  these calcalution on app
                    //it directly show on the textview component in app
                    if(bmi>25){
                        txtResult.setText("You are overweight......!");
                    } else if (bmi<18) {
                        txtResult.setText("You are underweight...!");
                    }else{
                        txtResult.setText("Congratulation....! You are healthy");
                    }


            }
      });


    }
}