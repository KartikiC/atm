package com.example.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Pasie25Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 0.25){
			int num = (int) (cur.getAmount()/0.25);
			Double remainder = (cur.getAmount() % 0.25);
			System.out.println("Dispensing "+num+" 25 paise");
			Log.e("Dispensing",""+num+" 0.25 paise");
			Context applicationContext = MainActivity.getContextOfApplication();
			SharedPreferences.Editor editor = applicationContext.getSharedPreferences("Amount",applicationContext.MODE_PRIVATE).edit();
			editor.putString("Pasie25Dispenser", num+" 0.25 paise");

			editor.apply();
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}