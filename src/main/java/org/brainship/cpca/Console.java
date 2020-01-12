package org.brainship.cpca;

import java.util.Vector;
import java.io.IOException;

public class Console {
	
	private ConsolePrintStream cps;
	
	public Console() {
	}
	
	public <T extends Object> void print(T element) {
		System.out.print(element.toString());
	}
	
	public <T extends Object> void println(T element) {
		System.out.println(element.toString());
	}
	
	public void println() {
		System.out.println();
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
		flush();
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
	
	public void flush() {
		try {
			 if (System.getProperty("os.name").contains("Windows"))
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else
				Runtime.getRuntime().exec("clear");
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
}