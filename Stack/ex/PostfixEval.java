package stack;
import java.util.Scanner;

public class PostfixEval {

	public static int evaluate(String postfix) {
		LinkedStack<Integer> stack = new LinkedStack<>();
		String[] num = postfix.split(" ");
		
		int a, b, k;
		for (int i = 0; i < num.length; i++) {
			// +=, ==, >=, 등등 이런 것들은 기본제공 연산자이다. 따라서 float, int, double, char, boolean 등 기초 타입에만 적용됨
			// 래퍼 클래스나 클래스 개체에는 적용안됨 따라서 compareTo 사용
			if (num[i].compareTo("+") == 0 || num[i].compareTo("-") == 0 || num[i].compareTo("*") == 0 || num[i].compareTo("/") == 0) {
				a = stack.pop();
				b = stack.pop();
				stack.push(operation(a, b, num[i]));
			}
			else {
				k = Integer.parseInt(num[i]);
				stack.push(k);
			}
		}
		return stack.pop();
	}
	
	public static int operation(int a, int b, String str) {
		int result = 0;
		switch (str) {
			case "+": {
				result = b + a;
				break;
			}
			case "-": {
				result = b - a;
				break;
			}
			case "*": {
				result = b * a;
				break;
			}
			case "/": {
				result = b / a;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine(); // 입력이 후위 표현법으로 주어짐
		
		int result = evaluate(str);
		System.out.print(result);
	}
}
