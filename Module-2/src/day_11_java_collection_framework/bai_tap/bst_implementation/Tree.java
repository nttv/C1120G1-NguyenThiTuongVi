package day_11_java_collection_framework.bai_tap.bst_implementation;

public interface Tree<E> {
    /**
     * Insert element e into the binary search tree.
     * Return true if the element is inserted successfully.
     */
    public boolean insert(E e);

    /**
     * Search element e in the binary search tree.
     * Return treeNode if the element is found.
     */
    public TreeNode search(E e);

    /**
     * Delete element e in the binary search tree.
     * Return true if the element is deleted successfully.
     */
    public boolean delete(E e);

    /**
     * Inorder traversal from the root
     */
    public void inorder();

    /**
     * Preorder traversal from the root
     */
    public void preorder();

    /**
     * Postorder traversal from the root
     */
    public void postorder();

    /**
     * Get the number of nodes in the tree
     */
    public int getSize();
}
