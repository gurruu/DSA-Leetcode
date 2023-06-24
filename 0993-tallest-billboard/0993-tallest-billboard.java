class Solution {
    Integer t[][];
    public int tallestBillboard(int[] rods) {
        
        t=new Integer[20][10000];
        int ans= solve(rods,0,0,0,0);
        if(ans==Integer.MIN_VALUE) return -1;

        return ans/2;

    }

    int solve(int arr[],int ind,int leftSum,int rightSum,int diff)
    {
        if(ind==arr.length && diff==0)
        {
            return 0;
        }

        if(ind==arr.length && diff!=0)
        {
            return Integer.MIN_VALUE;
        }

        if(t[ind][diff+5000]!=null) return t[ind][diff+5000];

       int left=solve(arr,ind+1,leftSum+arr[ind],rightSum,diff+arr[ind]);
       int right=solve(arr,ind+1,leftSum,rightSum+arr[ind],diff-arr[ind]);

       int skip=solve(arr,ind+1,leftSum,rightSum,diff);

       int ans= Math.max(skip,arr[ind]+Math.max(right,left));

       t[ind][diff+5000]=ans;
       return ans;
    }
}