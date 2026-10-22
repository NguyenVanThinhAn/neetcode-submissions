class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numMap = new HashMap();

        for(int i = 0; i < nums.length; i++){
            if(numMap.containsKey(target - nums[i])){
                int[] result = new int[]{numMap.get(target - nums[i]),i};
                return result;
            }
            numMap.put(nums[i],i);
        }
        int[] result = new int[]{-1,-1};
        return result;
    }
}
