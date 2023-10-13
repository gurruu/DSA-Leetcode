class Solution {
    Integer t[];
    public int minCostClimbingStairs(int[] cost) {
        t=new Integer[cost.length+2];
        int ans1=solve(cost,0);
        int ans2=solve(cost,1);
        
        return Math.min(ans1,ans2);
    }

    int solve(int arr[],int ind)
    {
        if(ind>=arr.length) return 0;
        if(t[ind]!=null) return t[ind];

        t[ind]= arr[ind]+Math.min(solve(arr,ind+1),solve(arr,ind+2));
        return t[ind];

    }
}