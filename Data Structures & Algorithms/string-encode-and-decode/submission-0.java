class Solution {

    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();

        for(String str : strs){
            s.append(str.length()).append("#").append(str);
    }

    return s.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while(i< str.length()){
            int j = i;

            while(str.charAt(j)!='#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            String s = str.substring(j+1, j+len+1);
            res.add(s);
            System.out.println(s);
            i = j+len+1;

        }
    return res;
    }
}
