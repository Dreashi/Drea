package Jan_10th;

import java.util.Stack;

public class sortStackByStack {
	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> temp = new Stack<Integer>();
		while(!stack.isEmpty()){
			int x = stack.pop();
			while(!temp.isEmpty() && temp.peek() > x){
				stack.push(temp.pop());
			}
			temp.push(x);
		}
		while(!temp.isEmpty()){
			stack.push(temp.pop());
		}
	}
}
