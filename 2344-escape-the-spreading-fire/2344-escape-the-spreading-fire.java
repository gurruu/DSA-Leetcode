class Solution {
    boolean flag=false,max=false;
    int d[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean canWalk(int g[][],int day)
    {
        int m=g[0].length;
        int n=g.length;
        int t[][]=new int[n][m];
        Queue<int[]>q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                t[i][j]=g[i][j];
                if(g[i][j]==1)
                {
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
         
         while(q.size()!=0 &&  day-->0)
         {
            if(help(q,t)) return false;
         }


        Queue<int[]>p=new LinkedList<>();
      
        p.add(new int[]{0,0});
        

        while(p.size()>0)
        {
           boolean burn=help(q,t);
           boolean canReach=help(p,t);

           if(canReach) return true;

           if(burn) return false;

        }
        return false;


    }

    boolean help(Queue<int[]>q,int t[][])
    {
        int n=t.length;
        int m=t[0].length;

         int count=q.size();
             flag=false;
             while(count-->0)
             {
                 int arr[]=q.poll();
                 for(int i=0;i<4;i++)
                 {
                     int x=arr[0]+d[i][0];
                     int y=arr[1]+d[i][1];
                     if(x==n-1 && y==m-1) return true;
                     if(x>=0 && x<n && y>=0 && y<m && t[x][y]==0)
                     {
                       
                        t[x][y]=-1;
                        q.add(new int[]{x,y});
                     }
                 }

             }

             return false;

    }


    public int maximumMinutes(int[][] grid) {
        int start=0;
        int end=grid.length*grid[0].length;
        int ans=-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(canWalk(grid,mid))
            {
                
                ans=mid;
                start=mid+1;
            }else{
                
                end=mid-1;
            }
        }
        return ans==grid.length*grid[0].length?1000000000:ans;

    }
}