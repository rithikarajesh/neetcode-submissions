class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        String res = "";
        int incr = (numRows-1)*2;
        for(int r = 0; r < numRows; r++){
            for(int i = r; i <s.length(); i = i+incr){
                res = res+s.charAt(i);
                
                if(r!=0 && r!= numRows-1){
                    int mid = i + incr-(2*r);
                    if(mid<s.length()){
                        res = res+s.charAt(mid);                       
                    }
                }
            } 
        }

        return res;
    }
}