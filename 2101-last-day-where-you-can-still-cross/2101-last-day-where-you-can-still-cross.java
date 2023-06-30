class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int start=1;
        int end=cells.length;
        int ans=1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(canWalk(row,col,cells,mid))
            {
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;

    }
    
    boolean canWalk(int n,int m,int c[][],int day)
    {
        boolean visited[][]=new boolean[n][m];
        int g[][]=new int[n][m];
        int d[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        for(int i=0;i<day;i++)
        {
            int r=c[i][0]-1;
            int col=c[i][1]-1;

            g[r][col]=1;
        }

        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            if(g[0][i]!=1)
            {
                q.add(new int[]{0,i});
                visited[0][i]=true;
            }
        }

        while(q.size()>0)
        {
            int arr[]=q.poll();
            int row=arr[0];
            int col=arr[1];
            if(row== n-1) return true;

            for(int i=0;i<4;i++)
            {
                int x=row+d[i][0];
                int y=col+d[i][1];

                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || g[x][y]==1)
                {
                    continue;
                }

                q.add(new int[]{x,y});
                visited[x][y]=true;
            }

        }
        return false;
    }

}