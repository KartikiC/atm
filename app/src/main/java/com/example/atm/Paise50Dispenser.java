package com.example.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class Paise50Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 0.50){
			int num = (int) (cur.getAmount()/0.50);
			Double remainder = (cur.getAmount() % 0.50);
			System.out.println("Dispensing "+num+" 0.50 paise");
			Log.e("Dispensing",""+num+" 0.50 paise");
			Context applicationContext = MainActivity.getContextOfApplication();
			SharedPreferences.Editor editor = applicationContext.getSharedPreferences("Amount",applicationContext.MODE_PRIVATE).edit();
			editor.putString("Paise50Dispenser", num+" 0.50 paise");

			editor.apply();
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}