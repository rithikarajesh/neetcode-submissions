class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0,0, new StringBuilder());
        return res;
    }

    private void helper(int n , int open, int close, StringBuilder str){
        if(str.length() == n*2){
            res.add(str.toString());
        }

        if(open<n){
            str.append("(");
            helper(n,open+1, close,str);
            str.deleteCharAt(str.length()-1);
        }
        if(close<open){
            str.append(")");
            helper(n, open, close+1, str);
            str.deleteCharAt(str.length()-1);
        }
    }
}
