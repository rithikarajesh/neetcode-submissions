class MinStack {
    Stack<Integer> st;
    Stack<Integer> min_stack;
    int min = -1;
    public MinStack() {
        st = new Stack();
        min_stack = new Stack();
    }
    
    public void push(int val) {
       
            st.push(val);
   
             if(min_stack.isEmpty() || val <= min_stack.peek()){
                min_stack.push(val);
             }
      
        
    }
    
    public void pop() {
        if(!st.isEmpty()){
            int ele = st.pop(); 
            if(!min_stack.isEmpty() && ele == min_stack.peek()){
                min_stack.pop();
            }         
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!min_stack.isEmpty()){
            return min_stack.peek();
        }
        return -1;
    }
}
