/**
 *
 */
package uy.edu.um.tad.binarytree;

import uy.edu.um.tad.linkedlist.MyLinkedListImpl;
import uy.edu.um.tad.linkedlist.MyList;

public class MySearchBinaryTreeImpl<K extends Comparable<K>, V> implements
        MySearchBinaryTree<K, V> {

    private TreeNode<K, V> root;

    @Override
    public void add(K key, V value) {
        TreeNode<K, V> elementToAdd = new TreeNode<>(key, value);

        if (root == null) {

            root = elementToAdd;

        } else {

            root.add(key, value);

        }
    }

    public V find(K key) {

        return find(key, root);
    }

    private V find(K keyToSearch, TreeNode<K, V> root) {
        V value = null;

        if (root != null) {

            int nValue = keyToSearch.compareTo(root.getKey());

            if (nValue == 0) {

                value = root.getValue();

            } else if (nValue > 0) {

                value = find(keyToSearch, root.getRight());

            } else {

                value = find(keyToSearch, root.getLeft());

            }

        }

        return value;
    }

    public boolean contains(K key) {

        return contains(key, root);
    }

    private boolean contains(K keyToSearch, TreeNode<K, V> root) {
        boolean contains = false;

        if (root != null) {

            int nValue = keyToSearch.compareTo(root.getKey());

            if (nValue == 0) {

                contains = true;

            } else if (nValue > 0) {

                contains = contains(keyToSearch, root.getRight());

            } else {

                contains = contains(keyToSearch, root.getLeft());

            }

        }

        return contains;
    }


    @Override
    public void remove(K key) {

        if (root != null) {

            root = root.remove(key);

        }

    }

    @Override
    public MyList<K> inOrder() {
        MyList<K> inOrderTraverse = new MyLinkedListImpl<>();

        if (root != null) {

            root.inOrderTraverse(inOrderTraverse);

        }

        return inOrderTraverse;
    }

    @Override
    public TreeNode<K, V> getRoot() {
        return root;
    }

    @Override
    public MyList<V> inOrderValues() {
        MyList<V> inorderList = new MyLinkedListImpl<>();
        if (root != null) {
            root.inOrderValues(inorderList);
        }
        return inorderList;
    }

}
