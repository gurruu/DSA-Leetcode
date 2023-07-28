class Solution {
    Integer t[][][];
    public boolean PredictTheWinner(int[] nums) {
        
        int sum=0;
        t=new Integer[22][22][3];
        sum=solve(nums,0,nums.length-1,1);
        return sum>=0;

    }
    int solve(int arr[],int i,int j,int playr)
    {
        if(i>j) return 0;
        
        if(t[i][j][playr]!=null) return t[i][j][playr];

        if(playr==1)
        {
            int left=arr[i]+solve(arr,i+1,j,2);
            int right=arr[j]+solve(arr,i,j-1,2);
            t[i][j][playr]= Math.max(left,right);
            return t[i][j][playr];
        }else{
            int left=-arr[i]+solve(arr,i+1,j,1);
            int right=-arr[j]+solve(arr,i,j-1,1);
            t[i][j][playr]= Math.min(left,right);
            return t[i][j][playr];
        }
    }
}