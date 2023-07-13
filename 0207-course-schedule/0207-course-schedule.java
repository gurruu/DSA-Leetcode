class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>>g=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            g.add(new ArrayList<>());
        }

        for(int arr[]:prerequisites)
        {
           g.get(arr[1]).add(arr[0]);
        }

        boolean visited[]=new boolean[numCourses+1];
        boolean recStack[]=new boolean[numCourses+1];

        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==false)
            {
                if(isCycle(g,i,recStack,visited))
                {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCycle(List<List<Integer>>g,int src,boolean rc[],boolean vis[])
    {
        if(rc[src]==true)
        {
            return true;
        }
        if(vis[src])
        {
            return false;
        }

        vis[src]=true;
        rc[src]=true;
        for(int v:g.get(src))
        {
            if(isCycle(g,v,rc,vis))
            {
                return true;
            }
        }

        rc[src]=false;
        return false;

    }
}