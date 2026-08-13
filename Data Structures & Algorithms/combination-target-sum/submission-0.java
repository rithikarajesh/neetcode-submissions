class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums,target, 0);
        return list;
    }

    public void helper(int nums[], int target, int i){
        if(target == 0){
            list.add(new ArrayList<>(combination));
            return;
        }
        if(i>=nums.length || target<0){
            return;
        }

        combination.add(nums[i]);
        helper(nums, target - nums[i], i);
        combination.remove(combination.size()-1);
        helper(nums, target , i+1);

    }
}
