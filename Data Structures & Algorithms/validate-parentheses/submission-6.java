class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==1){
            return false;
        }

        for(Character c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            
            if(!stack.isEmpty() && ((c == ')' && stack.peek()=='(')
            || (c == '}' && stack.peek()=='{')
            || (c == ']' && stack.peek()=='[')
            )){
                stack.pop();
            }
            else
             return false;

        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
