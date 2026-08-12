class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i = 1; i<=n; i++){
            res[i] = getCount(i);
        }
         
         return res;
    }

    private int getCount(int num){
        int count = 0;
        while(num>0)
        {if((num&1)==1){
            count++;
        }
        num=num>>1;}
        return count;
    }
}
