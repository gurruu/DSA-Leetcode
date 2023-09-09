class Solution {
    Integer t[];
    public int combinationSum4(int[] nums, int target) {
        t=new Integer[target+6];
        return solve(nums,0,target);
    }
    int solve(int nums[],int ind,int target)
    {
        if(target==0) return 1;
        if(target<0 || ind>=nums.length) return 0;
        if(t[target]!=null)return t[target];

        int res=0;
        for(int k=0;k<nums.length;k++)
        {
            if(nums[k]<=target){
                res+=solve(nums,k,target-nums[k]);
            }
        }
        t[target]=res;
        return res;

    }
}