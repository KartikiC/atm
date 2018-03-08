package com.example.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Rs1000Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	public void dispense(Currency cur) {
		if(cur.getAmount() >= 1000){
			int num = (int) (cur.getAmount()/1000);
			Double remainder = cur.getAmount() % 1000;
			System.out.println("Dispensing "+num+" 1000 note");
			Log.e("Dispensing",""+num+" 1000 note");
			Context applicationContext = MainActivity.getContextOfApplication();
			SharedPreferences.Editor editor = applicationContext.getSharedPreferences("Amount",applicationContext.MODE_PRIVATE).edit();
			editor.putString("Rs1000Dispenser", num+" 1000 note");

			editor.apply();
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}

}