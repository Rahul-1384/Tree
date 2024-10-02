import java.util.*;
public class BinaryTree {
    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }
    private Node root;

    public void populate(Scanner sc){
        System.out.println("Enter a Root node value:");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc,root);
    }
    private void populate(Scanner sc, Node root){
        System.out.println("Do you want to add the node into left side: "+root.value);
        boolean left = sc.nextBoolean();
        if(left){
            System.out.println("Enter the left node value");
            int value = sc.nextInt();
            root.left = new Node(value);
            populate(sc, root.left);
        }

        System.out.println("Do you want to add the node into right side: "+root.value);
        boolean right = sc.nextBoolean();
        if(right){
            System.out.println("Enter the right node value");
            int value = sc.nextInt();
            root.right = new Node(value);
            populate(sc, root.right);
        }
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node root, int level){
        if(root == null){
            return;
        }
        prettyDisplay(root.right,level+1);
        if(level != 0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->"+ root.value);
        }else{
            System.out.println(root.value);
        }
        prettyDisplay(root.left,level+1);
    }

    // Pre-order Traversal
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    // In-order traversal
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }
    // Post-order traversal
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    // Level Order traversal (new line)
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currentNode = q.remove();
            if(currentNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currentNode.value);
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
        }
    }
    // Level Order traversal (Array List)

    // public List<List<Integer>> levelOrder() {
    //     return levelOrder(root);
    // }

    // private List<List<Integer>> levelOrder(Node root) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     if (root == null) {
    //         return result;
    //     }

    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     q.add(null); // marker for end of level

    //     List<Integer> currentLevel = new ArrayList<>();

    //     while (!q.isEmpty()) {
    //         Node currentNode = q.remove();

    //         if (currentNode == null) {
    //             result.add(new ArrayList<>(currentLevel));
    //             currentLevel.clear();

    //             if (q.isEmpty()) {
    //                 break;
    //             } else {
    //                 q.add(null); // add marker for next level
    //             }
    //         } else {
    //             currentLevel.add(currentNode.value);

    //             if (currentNode.left != null) {
    //                 q.add(currentNode.left);
    //             }
    //             if (currentNode.right != null) {
    //                 q.add(currentNode.right);
    //             }
    //         }
    //     }

    //     return result;
    // }



    // Height of a binary tree
    public int heightOfBT(){
        return heightOfBT(root);
    }
    private int heightOfBT(Node root){
        if(root == null){
            return 0;
        }
        int lh = heightOfBT(root.left);
        int rh = heightOfBT(root.right);
        int height = Math.max(lh, rh) + 1;
        return height;
    }

    // Nodes Count
    public int countNodes(){
        return countNodes(root);
    }
    private int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);

        return lc+rc+1;
    }

    // Diameter Of a BT
    public int diameterOfBT(){
        return diameterOfBT(root);
    }
    private int diameterOfBT(Node root){
        if(root == null){
            return 0;
        }

        int ld = diameterOfBT(root.left);
        int rd = diameterOfBT(root.right);
        int lh = heightOfBT(root.left);
        int rh = heightOfBT(root.right);
        int selfDiameter = rh + lh + 1;
        return Math.max(Math.max(rd, ld), selfDiameter);
    }

    // Subtree of another Tree


    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(sc);
        tree.prettyDisplay();
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        tree.levelOrder();
        System.out.print("Height of a tree is ");
        System.out.print(tree.heightOfBT());
        System.out.println();
        System.out.print("Count of a Nodes: ");
        System.out.print(tree.countNodes());
        System.out.print("Diameter of a BT: ");
        System.out.print(tree.diameterOfBT());
    }
}
