class Solution {
    public boolean checkArray(int[] nums, int k) {
        
        int windowSum=0;
        for(int i=0;i<nums.length;i++)
        {
            if(windowSum>nums[i])
            {
                return false;
            }

            nums[i]-=windowSum;
            windowSum+=nums[i];
            if(i>=k-1)
            {
                windowSum-=nums[i-k+1];
            }
        }
        return windowSum==0;
    }
}