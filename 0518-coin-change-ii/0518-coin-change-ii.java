class Solution {
    public int change(int amount, int[] coins) {
        
        return solve(coins,amount,0);
        
    }
    
    Integer t[][]=new Integer[305][5005];
    
    int solve(int arr[],int target,int i)
    {
        if(i>=arr.length || target<0)
        {
            return 0;
        }
        if(target==0)
        {
            return 1;
        }
        if(t[i][target]!=null)
        {
            return t[i][target];
        }
        
        if(arr[i]<=target)
        {
            t[i][target]= solve(arr,target-arr[i],i)+solve(arr,target,i+1);
            return t[i][target];
        }
        
        t[i][target]= solve(arr,target,i+1);
        return t[i][target];
        
    }
    
    
}