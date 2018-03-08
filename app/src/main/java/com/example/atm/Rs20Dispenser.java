package com.example.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Rs20Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = (int) (cur.getAmount()/20);
			Double remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20 note");
			Log.e("Dispensing",""+num+" 20 note");
			Context applicationContext = MainActivity.getContextOfApplication();
			SharedPreferences.Editor editor = applicationContext.getSharedPreferences("Amount",applicationContext.MODE_PRIVATE).edit();
			editor.putString("Rs20Dispenser", num+" 20 note");

			editor.apply();
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}