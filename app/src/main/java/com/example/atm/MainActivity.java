package com.example.atm;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    EditText editAmount;
    TextView txtView;
    Double enterAmount;
    Button buttonDispense;
    public static Context contextOfApplication;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contextOfApplication = getApplicationContext();

        editAmount = (EditText) findViewById(R.id.editAmount);
        txtView = (TextView) findViewById(R.id.txtAmount);
        buttonDispense = (Button) findViewById(R.id.buttonDispense);




        buttonDispense.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ATMDispenseChain atmDispenser = new ATMDispenseChain();
		/*while (true) {
			Double amount = 0.0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextDouble();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			*/

                //For testing
                SharedPreferences preferences = getSharedPreferences("Amount", MODE_PRIVATE);
                preferences.edit().clear().apply();
                enterAmount = Double.parseDouble(editAmount.getText().toString());
                //Double amount = 1730.75;

                // process the request
                atmDispenser.c1.dispense(new Currency(enterAmount));

                SharedPreferences prefs = getSharedPreferences("Amount", MODE_PRIVATE);


                String Rs2000Dispenser = prefs.getString("Rs2000Dispenser", "");//"No name defined" is the default value.
                String Rs1000Dispenser = prefs.getString("Rs1000Dispenser", "");//"No name defined" is the default value.
                String Rs500Dispenser = prefs.getString("Rs500Dispenser", "");//"No name defined" is the default value.
                String Rs200Dispenser = prefs.getString("Rs200Dispenser", "");//"No name defined" is the default value.
                String Rs100Dispenser = prefs.getString("Rs100Dispenser", "");//"No name defined" is the default value.
                String Rs50Dispenser = prefs.getString("Rs50Dispenser", "");//"No name defined" is the default value.
                String Rs20Dispenser = prefs.getString("Rs20Dispenser", "");//"No name defined" is the default value.
                String Rs10Dispenser = prefs.getString("Rs10Dispenser", "");//"No name defined" is the default value.
                String Rs5Dispenser = prefs.getString("Rs5Dispenser", "");//"No name defined" is the default value.
                String Rs1Dispenser = prefs.getString("Rs1Dispenser", "");//"No name defined" is the default value.
                String Pasie25Dispenser = prefs.getString("Pasie25Dispenser", "");//"No name defined" is the default value.
                String Pasie50Dispenser = prefs.getString("Pasie50Dispenser", "");//"No name defined" is the default value.

                String total = Rs2000Dispenser+" "+Rs1000Dispenser +" "+Rs500Dispenser +" "+Rs200Dispenser+" "+ Rs100Dispenser+" "+ Rs50Dispenser+" "+ Rs20Dispenser+" "+ Rs10Dispenser+" "+
                        Rs5Dispenser+" "+ Rs1Dispenser +" "+ Pasie50Dispenser +" "+Pasie25Dispenser ;

                txtView.setText(total);
            }
        });

    }
    public static Context getContextOfApplication(){
        return contextOfApplication;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
