package day_11_java_collection_framework.bai_tap.bst_implementation;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    @Override
    public TreeNode search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) == 0) {
                return current;
            } else if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null && !current.element.equals(e)) {     //find Node current with element e
            parent = current;
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current == null) {  //no node contains element e
            if (parent == null) {
                System.out.println("Tree is empty");
            } else {
                System.out.println(e + " is not in the tree");
            }
            return false;
        }

        TreeNode<E> node = current.left;
        if (current.left == null) {
            current = current.right;
        } else if (current.right == null) {
            current = current.left;
        } else {
            TreeNode<E> rightMost = node;
            while (rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = current.right;
        }
        if (current == root) {
            root = node;
        } else if (parent.left == current) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.println(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element + " ");
    }
}
