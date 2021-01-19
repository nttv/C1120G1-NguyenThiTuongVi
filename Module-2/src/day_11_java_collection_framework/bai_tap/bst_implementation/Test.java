package day_11_java_collection_framework.bai_tap.bst_implementation;

public class Test {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(15);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(4);
        tree.insert(7);
        tree.insert(20);
        tree.insert(40);
        System.out.println("===Preorder (sorted)===");
        tree.preorder();
        tree.delete(15);
        System.out.println("===Preorder (sorted)===");
        tree.preorder();
    }
}
