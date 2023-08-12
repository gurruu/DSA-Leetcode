class Solution {
    Integer t[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        t=new Integer[303][303];
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        return solve(obstacleGrid,0,0);
    }

    int solve(int arr[][],int i,int j)
    {
        if(i==arr.length-1 && j==arr[0].length-1) return 1;
        if(i==arr.length || j==arr[0].length || arr[i][j]==1)return 0;
        if(t[i][j]!=null) return t[i][j];
        return t[i][j]= solve(arr,i+1,j)+solve(arr,i,j+1);
    }
}