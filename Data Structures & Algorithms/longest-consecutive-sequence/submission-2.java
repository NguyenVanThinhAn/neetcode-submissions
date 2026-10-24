class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numMap = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        int currLength = 1;
        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            if(!numMap.contains(currNum - 1)){
                while(true){
                    if(numMap.contains(currNum + 1)){
                        currLength++;
                        currNum++;
                    }else{
                        if(currLength > maxLength){
                            maxLength = currLength;
                        }
                        currLength = 1;
                        break;
                    }
                }
            }
            // while(true){
            //     if(numMap.contains(currNum - 1)){
            //         currLength++;
            //         currNum--;
            //     }else{
            //         if(currLength > maxLength){
            //             maxLength = currLength;
            //         }
            //         currLength = 1;
            //         break;
            //     }
            // }
        }
        return maxLength;
    }
}
