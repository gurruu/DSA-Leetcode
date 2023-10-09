class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]=new int[2];
        res[0]=left(nums,target);
        res[1]=right(nums,target);
        return  res;
    }
    
     int left(int nums[],int target)
    {
        int index=-1;
        int s=0,e=nums.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(nums[mid]==target)
            {
                e=mid-1;
                s=0;
                index=mid;
            }
           else if(nums[mid]>target)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
            
        }
        return index;
    }
      int right(int nums[],int target)
    {
        int index=-1;
        int s=0,e=nums.length-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(nums[mid]==target)
            {
                 s=mid+1;
                e=nums.length-1;
                index=mid;
            }
           else if(nums[mid]>target)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
            
        }
        return index;
    }
    
}