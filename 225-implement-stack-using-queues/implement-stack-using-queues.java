class MyStack {
    Queue<Integer> mainqu;
    Queue<Integer> helperqu;
    public MyStack() {
        mainqu=new ArrayDeque<>();
        helperqu=new ArrayDeque<>();
    }
    
    public void push(int x) {
        this.mainqu.add(x);
    }
    
    public int pop() {
        if(this.mainqu.size()==0)
        {
            return -1;
        }
        while(this.mainqu.size()>1)
        {
            this.helperqu.add(this.mainqu.poll());
        }
        int val=this.mainqu.poll();
        while(this.helperqu.size()!=0)
        {
            this.mainqu.add(this.helperqu.poll());
        }
        return val;
    }
    
    public int top() {
        if(this.mainqu.size()==0)
        {
            return -1;
        }
        while(this.mainqu.size()>1)
        {
            this.helperqu.add(this.mainqu.poll());
        }
        int val=this.mainqu.poll();
        while(this.helperqu.size()!=0)
        {
            this.mainqu.add(this.helperqu.poll());
        }
        this.mainqu.add(val);
        return val;
    }
    
    public boolean empty() {
        if(this.mainqu.size()==0)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */