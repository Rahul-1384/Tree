import java.util.Scanner;

public class implementation{
    Scanner sc = new Scanner(System.in);

    class Node{
        int val;
        Node right;
        Node left;

        public Node(){

        }
        public Node(int val){
            this.val = val;
            left = null;
            right = null;
        }

    }
        private Node root = null;


        public void createTree(){
            this.root = createTree(this.root);
        }
        

        private Node createTree(Node root){
            System.out.println("Enter the Root Node: ");
            int val = sc.nextInt();

            // Creating new Root Node
            Node nn = new Node(val);

            // Checking if there is left node or not
            Boolean hln = sc.nextBoolean();
            if(hln){
                nn.left = createTree(nn);
            }

            // Checking if there is right node or not
            Boolean hrn = sc.nextBoolean();
            if(hrn){
                nn.right = createTree(nn);
            }

            return nn;
        }

        // Pre-Order
        public void preOrder(){
            preOrder(this.root);
        }

        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }

        
        
        // In-Order
        public void inOrder(){
            inOrder(this.root);
        }

        public void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }


        // Post-Order
        public void postOrder(){
            postOrder(this.root);
        }

        public void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            System.out.println(root.val);
            postOrder(root.right);
        }


        // Height of the Node
        public int heightOfBinaryTree(Node root){
            if(root == null){
                return 0;
            }
            int lh = heightOfBinaryTree(root.left);
            int rh = heightOfBinaryTree(root.right);
            return Math.max(lh,rh) + 1;
        }


        // Diameter of a binary tree
        public int diameterOfBinaryTree(Node root){
            if(root == null){
                return 0;
            }
            int leftDiameter = diameterOfBinaryTree(root.left);
            int rightDiameter = diameterOfBinaryTree(root.right);
            int leftHeight = heightOfBinaryTree(root.left);
            int rightHeight = heightOfBinaryTree(root.right);
            int selfDiameter = leftHeight + rightHeight;

            return Math.max(selfDiameter,Math.max(leftDiameter,rightDiameter));
        }



        

        // Return Pairs of height and diameter of a binary tree
        class Pair{
            int height = 0;
            int diameter = 0;
        }
        public Pair heighDiameterOfBinaryTree(Node root){
            if(root == null){
                return new Pair();
            }
            Pair leftPair = heighDiameterOfBinaryTree(root.left);
            Pair rightPair = heighDiameterOfBinaryTree(root.right);
            Pair selfPair = new Pair();
            selfPair.height = Math.max(leftPair.height,rightPair.height) + 1;
            selfPair.diameter = leftPair.height + rightPair.height;
            selfPair.diameter = Math.max(leftPair.diameter,Math.max(rightPair.diameter,selfPair.diameter));
            return selfPair;
        }
}