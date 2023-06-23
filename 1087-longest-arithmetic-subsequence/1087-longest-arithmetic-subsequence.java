class Solution {
    Integer t[][];
    public int longestArithSeqLength(int[] nums) {
        
        t=new Integer[1005][1010];
        return solve(nums,0,-505);

    }
    int solve(int nums[],int ind,int diff)
    {
        if(ind==nums.length) return 0;

        if(t[ind][diff+505]!=null) return t[ind][diff+505];

        int ans=1;
        if(diff==-505)
        {
            for(int i=ind+1;i<nums.length;i++)
            {
                ans=Math.max(ans,Math.max(1+solve(nums,i,nums[ind]-nums[i]),solve(nums,i,diff)));
            }
        }else{
            for(int i=ind+1;i<nums.length;i++)
            {
                int d=nums[ind]-nums[i];
                if(d==diff)
                {
                    ans=Math.max(ans,1+solve(nums,i,d));
                }
            }
        }
        t[ind][diff+505]=ans;
        return ans;
    }
}