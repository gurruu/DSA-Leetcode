class Solution {
    public int minimumMoves(int[][] grid) {
        
        int ans=Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(grid[i][j]==0) count++;
            }
        }
        if(count==0) return 0;

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(grid[i][j]==0)
                {
                    for(int r=0;r<3;r++)
                    {
                        for(int c=0;c<3;c++)
                        {
                            int dis=Math.abs(r-i)+Math.abs(c-j);
                            if(grid[r][c]>1)
                            {
                                grid[r][c]--;
                                grid[i][j]++;
                                ans=Math.min(ans,dis+minimumMoves(grid));
                                grid[r][c]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        return ans;

    }
}