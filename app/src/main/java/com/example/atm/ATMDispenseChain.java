package com.example.atm;

import java.util.Scanner;

public class ATMDispenseChain {

	public DispenseChain c1;

	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Rs2000Dispenser();
		DispenseChain c2 = new Rs1000Dispenser();
		DispenseChain c3 = new Rs500Dispenser();
		DispenseChain c4 = new Rs200Dispenser();
		DispenseChain c5 = new Rs100Dispenser();
		DispenseChain c6 = new Rs50Dispenser();
		DispenseChain c7 = new Rs20Dispenser();
		DispenseChain c8 = new Rs10Dispenser();
		DispenseChain c9 = new Rs5Dispenser();
		DispenseChain c10 = new Rs1Dispenser();
		DispenseChain c11 = new Paise50Dispenser();
		DispenseChain c12 = new Pasie25Dispenser();
		
		
		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
		c3.setNextChain(c4);
		c4.setNextChain(c5);
		c5.setNextChain(c6);
		c6.setNextChain(c7);
		c7.setNextChain(c8);
		c8.setNextChain(c9);
		c9.setNextChain(c10);
		c10.setNextChain(c11);
		c11.setNextChain(c12);
	}
	
	public static void main(String[] args) {
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
		Double amount = 1730.75;

			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}

	}


