package stack;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		LinkedStack<Character> stack = new LinkedStack<>();
		for (int i = 0; i < str.length(); i ++) 
			stack.push(str.charAt(i));
		
		stack.print_out(str.length());
	}
}
