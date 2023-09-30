class Solution {
    public int maxSubarrays(int[] nums) {
        
        int curr=-1;
        int res=0;
        for(int x:nums)
        {
            curr&=x;
            if(curr==0)
            {
                curr=-1;
                res++;
            }
        }
        return Math.max(res,1);

    }
}