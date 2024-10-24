// import java.util.*;
// class TreeNode{
//     TreeNode left;
//     TreeNode right;
//     int val;
// }
// class Leeet2583 {
//     public long kthLargestLevelSum(TreeNode root, int k) {
//         PriorityQueue<Long> pq = new PriorityQueue<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty())
//         {
//             int size = q.size();
//             long sum = 0;
//             while(size>0)
//             {
//             TreeNode temp = q.poll();
//             sum += temp.val;
//             if(temp.left!=null)
//             q.add(temp.left);
//             if(temp.right!=null)
//             q.add(temp.right);
//             size--;
//             }
//             pq.add(sum);
//             if(pq.size()>k)
//             pq.poll();
//         }    
//         return pq.size()<k ? -1 : pq.peek();
//     }
// }


class Leet2853 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
    
        boolean a = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right, root2.right);
        boolean b = flipEquiv(root1.right,root2.left) && flipEquiv(root1.left, root2.right);
        if(a && b){
            return true;
        }
        if(a || b){
            return true;
        }
        return false;
    }
}