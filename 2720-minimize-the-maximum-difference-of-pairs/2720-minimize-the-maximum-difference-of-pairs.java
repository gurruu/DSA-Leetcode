class Solution {
    public int minimizeMax(int[] nums, int p) {
        
        Arrays.sort(nums);
        int n=nums.length;
        int left=0;
        int right=nums[n-1];
        while(left<right)
        {
            int mid=(left+right)/2;
            if(getCount(nums,mid)>=p)
            {
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
    int getCount(int arr[],int mid)
    {
        int ind=0;
        int count=0;
        while(ind<arr.length-1)
        {
            if(arr[ind+1]-arr[ind]<=mid)
            {
                count++;
                ind++;
            }
            ind++;
        }
        return count;
    }
}