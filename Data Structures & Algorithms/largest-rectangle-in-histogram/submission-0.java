class Solution {
    public int largestRectangleArea(int[] heights) {
        int max_area = 0;
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && (stack.peek()[1]>heights[i])){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                max_area = Math.max(max_area, top[1]*(i-index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
 int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                max_area = Math.max(max_area, top[1]*(heights.length-index));
        }

        return max_area;
    }
}
