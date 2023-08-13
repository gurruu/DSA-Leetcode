class Solution {
    public boolean validPartition(int[] nums) {
        
        return solve(nums,0,nums.length);
        
    }
    Boolean t[]=new Boolean[100007];
    
    boolean solve(int nums[],int ind,int n)
    {
        if(ind>=n)
        {
            return true;
        }
        
        if(t[ind]!=null)
        {
            return t[ind];
        }
        
        if(ind+1<n && nums[ind]==nums[ind+1])
        {
            if(solve(nums,ind+2,n))
            {
                t[ind]=true;
                return true;
            }
            
            if(ind+2<n && nums[ind]==nums[ind+2])
            {
                if(solve(nums,ind+3,n))
                {
                    t[ind]=true;
                   return true;
                }
            }
            
        }
        
        if(ind+2<n && nums[ind+1]-nums[ind]==1 && nums[ind+2]-nums[ind]==2)
        {
            if(solve(nums,ind+3,n))
            {
                t[ind]=true;
                return true;
            }
        }
        t[ind]=false;
        return false;
        
    }
    
}