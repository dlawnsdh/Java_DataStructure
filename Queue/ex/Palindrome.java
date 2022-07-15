package queue;
import java.util.Scanner;
import stack.LinkedStack;

public class Palindrome {

	public static boolean isPalindrome(String str) {
		LinkedStack s = new LinkedStack<>();
		LinkedQueue q = new LinkedQueue<>();
		
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));
			q.enqueue(str.charAt(i));
		}
		while(!s.isEmpty() && s.pop() == q.dequeue()) {}
		if (s.isEmpty())
			return true;
		return false;		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		System.out.print("Is String Palindrome? : " + isPalindrome(str));
	}
}
