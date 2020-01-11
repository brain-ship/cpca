package org.brainship.cpca;

import java.util.Vector;

public class Console {
	
	private ConsolePrintStream cps;
	
	private int charsPrinted;
	
	public Console() {
		charsPrinted = 0;
	}
	
	public <T extends Object> void print(T element) {
		System.out.print(element.toString());
		charsPrinted+=element.toString().length();
	}
	
	public <T extends Object> void println(T element) {
		System.out.println(element.toString());
		charsPrinted+=element.toString().length()+1;
	}
	
	public void println() {
		System.out.println();
		charsPrinted++;
	}
	
	public void loadConsolePrintStream(ConsolePrintStream cps) {
		this.cps = cps;
	}
	
	public void printStreamScreen(int index) {
		Vector<String> v = this.cps.getScreens().elementAt(index);
		for(int i = 0; i < v.size(); i++)
			println(v.elementAt(i));
	}
	
	public void printStreamScreenAndFlush(int index) {
		printStreamScreen(index);
		clear();
	}
	
	public void printAllScreens(String delimiter) {
		Vector<Vector<String>> screens = this.cps.getScreens();
		for(int i = 0; i < screens.size(); i++) {
			if(i != 0 && delimiter != null) print(delimiter);
			printStreamScreen(i);
		}
	}
	
	public void printAllScreens() {
		printAllScreens(null);
	}
	
	public void clear() {
		for(int i = 1; i <= charsPrinted; i++)
			System.out.print("\b");
		charsPrinted = 0;
	}
	
}