public class Console {
	
	public int charsPrinted;
	
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
	
	public void clear() {
		for(int i = 1; i <= charsPrinted; i++)
			System.out.print("\b");
		charsPrinted = 0;
	}
	
}