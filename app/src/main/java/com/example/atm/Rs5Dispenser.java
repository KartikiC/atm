package com.example.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Rs5Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 5){
			int num = (int) (cur.getAmount()/5);
			Double remainder = cur.getAmount() % 5;
			System.out.println("Dispensing "+num+" 5 note");
			Log.e("Dispensing",""+num+" 5 note");
			Context applicationContext = MainActivity.getContextOfApplication();
			SharedPreferences.Editor editor = applicationContext.getSharedPreferences("Amount",applicationContext.MODE_PRIVATE).edit();
			editor.putString("Rs5Dispenser", num+" 5 note");

			editor.apply();
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}