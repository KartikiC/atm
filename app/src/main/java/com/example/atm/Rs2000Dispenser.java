package com.example.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class Rs2000Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}



	public void dispense(Currency cur) {
		if(cur.getAmount() >= 2000){
			int num = (int) (cur.getAmount()/2000);
			Double remainder = cur.getAmount() % 2000;
			System.out.println("Dispensing "+num+" 2000 note");
			Log.e("Dispensing",""+num+" 2000 note");

			Context applicationContext = MainActivity.getContextOfApplication();
			SharedPreferences.Editor editor = applicationContext.getSharedPreferences("Amount",applicationContext.MODE_PRIVATE).edit();
			editor.putString("Rs2000Dispenser", num+" 2000 note");

			editor.apply();
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);


		}
	}

}