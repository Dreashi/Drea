package Answer;

import java.util.Scanner;
import java.util.Stack;

public class Main{
	private static boolean isClosed(String str){
		Stack<Character>stack = new Stack<>();
		for(int i = 0 ; i < str.length() ; i++){
			char c = str.charAt(i);
			if(c == '{' || c == '[' || c == '('){
				stack.push(c);
			}else if(!stack.isEmpty() && (c=='}'&&stack.peek()=='{' || c == ']'&&stack.peek()=='[' || c == ')'&&stack.peek()=='('  )     ){
				stack.pop();
			}else{
				return false;
			}
		}
		return stack.isEmpty() ? true : false; 
	}
	 public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
		 String str = in.nextLine();
		 System.out.println(isClosed(str) ? "YES" : "NO");
	 }
}