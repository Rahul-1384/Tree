class class1 extends implementation{
    public static void main(String[] args) {
        implementation im = new implementation();
        im.createTree();
        System.out.println("Preorder:");
        im.preOrder();
        System.out.println("Inorder:");
        im.inOrder();
        System.out.println("Inorder:");
        im.postOrder();
    }
}