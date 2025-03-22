package com.mb.battlefield.util;

import com.mb.battlefield.model.Player;

public class ConsolePrinter {
	private static ConsolePrinter consolePrinter;
	
	private ConsolePrinter() {
//		consolePrinter = new ConsolePrinter();
	}
	
	public static synchronized ConsolePrinter getPrinter() {
		if(consolePrinter == null) {
			consolePrinter = new ConsolePrinter();
		}
		return consolePrinter;
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}

	public void printWinner(Player winner) {
		System.out.println("WInner is "+winner.getName());
	}
}
