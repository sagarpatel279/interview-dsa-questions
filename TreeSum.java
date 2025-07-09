
public class TreeSum {
    private static int sum;
    public static void main(String[] args) {
        // TreeNode t7=new TreeNode(7,null,null);
        TreeNode t6=new TreeNode(6,null,null);
        TreeNode t5=new TreeNode(5,null,null);
        TreeNode t4=new TreeNode(4,null,null);
        TreeNode t3=new TreeNode(3,t6,null);
        TreeNode t2=new TreeNode(2,t4,t5);
        TreeNode t1=new TreeNode(1,t2,t3);
        treeSum(t1,0);
        System.out.println(sum);
    }
    
    private static void treeSum(TreeNode root,int num){
        if(root==null){return;}
        num=num*10+root.val;
        if(root.left==null && root.right==null){
            sum+=num;
        }
        treeSum(root.left,num);
        treeSum(root.right,num);
        num/=10;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}