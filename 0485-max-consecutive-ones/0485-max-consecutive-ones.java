class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
         if(nums[0]==1)
        {
            count++;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]==1) {
                count++;
            }
            else {
                maxCount=Math.max(maxCount, count);
                count=0;
            }
        }
        maxCount=Math.max(maxCount, count);
         return maxCount;
    }
}