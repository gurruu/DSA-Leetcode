/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int parent[]=new int[505];
    List<List<Integer>>g=new ArrayList<>();
    List<Integer>res=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Arrays.fill(parent,-1);
        getStart(root,target,-1);

        for(int i=0;i<=500;i++)
        {
            g.add(new ArrayList<>());
        }

        for(int i=0;i<=500;i++)
        {
            int u=parent[i];
            int v=i;
            if(u==-1) continue;

            g.get(v).add(u);
            g.get(u).add(v);
        }
        bfs(target.val,k);

        if(k==0) res.add(target.val);
        return res;
      
    }

    void bfs(int src,int k)
    {
        Queue<Integer>q=new LinkedList<>();
        boolean visited[]=new boolean[505];
        
        q.add(src);
        visited[src]=true;

        while(q.size()>0)
        {
            int len=q.size();
            for(int i=0;i<len;i++)
            {
                int u=q.poll();
                for(int v:g.get(u))
                {
                   if(visited[v]==false)
                   {
                       visited[v]=true;
                       if(k==1)
                       {
                           res.add(v);
                       }
                       q.add(v);
                   }
                }
            }
            if(k==0) return;
            k--;
        }
    }

    

    void getStart(TreeNode root,TreeNode target,int p)
    {
        if(root==null)
        {
            return ;
        }
        parent[root.val]=p;
       

        getStart(root.left,target,root.val);
        getStart(root.right,target,root.val);
    }
}