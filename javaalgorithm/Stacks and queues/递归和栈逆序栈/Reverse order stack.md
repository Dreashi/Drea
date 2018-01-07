

public static int getAndRemoveLastElement(St
ack<Integer stack>)
{
    
    int result=stack.pop();
    if(stack.isEmpty()){
        return result;       
    }
    else{
        int last=getAndRemoveLastElement(stack);
        stack.push(result);
        return last;
    }
}
public static void reverse(Stack<Integer> stack)
{

    if(stack.isEmpty()){
        return;
    }
    int i=getAndRemoveLastElement(stack);
    reverse(stack);
    stack.push(i);
}