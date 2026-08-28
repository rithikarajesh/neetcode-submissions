class Solution {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(n==0){
            return true;
        }
  
        for(int i= 0; i<n; i++){
            map.put(i, new ArrayList<Integer>());
        }

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        System.out.println(map);
         if(helper(0,-1) &&  visited.size()==n){
            return true;
         }
        return false;
    }

    private Boolean helper(int i,int prev){
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        for(int num : map.get(i)){
            if(num==prev)
                continue;
            if(!helper(num,i))
                return false;
        }
        return true;
    }
}
