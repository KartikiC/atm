package com.example.atm;

public interface  DispenseChain {
void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur);
}
