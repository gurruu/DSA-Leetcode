class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        List<List<Integer>>g=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            g.add(new ArrayList<>());
        }
        int deg[]=new int[n];
        Arrays.fill(deg,0);
        for(int arr[]:relations)
        {
            int u=arr[0]-1;
            int v=arr[1]-1;
            g.get(u).add(v);
            deg[v]++;
        }

        int currTime[]=new int[n];
        Arrays.fill(currTime,0);
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(deg[i]==0)
            {
                q.add(i);
                currTime[i]=time[i];
            }
        }

        while(q.size()>0)
        {
            int u=q.poll();
            for(int v:g.get(u))
            {
                if(currTime[u]+time[v]>currTime[v])
                {
                    currTime[v]=currTime[u]+time[v];
                }
                deg[v]--;
                if(deg[v]==0)
                {
                    q.add(v);
                }
            }
        }
        int res=0;
        for(int c:currTime)
        {
            res=Math.max(res,c);
        }
        return res;

    }
}