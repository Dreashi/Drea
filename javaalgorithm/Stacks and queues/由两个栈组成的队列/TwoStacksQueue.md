public class TwoStacksQueue{
    
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public void TwoStackQueue(){
        stackPush=new Stack()<Integer>;
        stackPop=new Stack()<Integer>;
    }
    public void add (int pushInt){
        stackPush.push(pushInt);
    }
    public int poll(){
        if(stackPop.empty()&&stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        else if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
    
}