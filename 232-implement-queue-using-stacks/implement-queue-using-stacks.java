class MyQueue {
    Stack<Integer> mainst;
    Stack<Integer> helperst;
    public MyQueue() {
        mainst=new Stack<>();
        helperst=new Stack<>();
    }
    
    public void push(int x) {
        this.mainst.push(x);
    }
    
    public int pop() {
        if(this.mainst.size()==0)
        {
            return -1;
        }
        while(this.mainst.size()!=0)
        {
            this.helperst.push(this.mainst.pop());
        }
        int val=this.helperst.pop();
        while(this.helperst.size()!=0)
        {
            this.mainst.push(this.helperst.pop());
        }
        return val;
    }
    
    public int peek() {
        if(this.mainst.size()==0)
        {
            return -1;
        }
        while(this.mainst.size()!=0)
        {
            this.helperst.push(this.mainst.pop());
        }
        int val=this.helperst.peek();
        while(this.helperst.size()!=0)
        {
            this.mainst.push(this.helperst.pop());
        }
        return val;
    }
    
    public boolean empty() {
        if(this.mainst.size()==0)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */