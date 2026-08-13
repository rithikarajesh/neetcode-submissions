class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target,0);
        return res;
    }

    public void helper(int[] nums, int target, int i){
        if(target == 0){
            res.add(new ArrayList<>(current));
            return;
        }

        if(i>=nums.length || target< 0){
            return;
        }

       
        current.add(nums[i]);
        helper(nums,target-nums[i], i+1);
        current.remove(current.size()-1);
         while(i+1 < nums.length && nums[i] == nums[i+1]){
            i += 1;
        }
        helper(nums, target, i+1);
    }

    
}
