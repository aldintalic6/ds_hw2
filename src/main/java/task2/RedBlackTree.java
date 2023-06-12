package task2;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int numSteps;

    public Value get(Key key) {
        numSteps = 1;
        Node<Key, Value> node = getNode(root, key);
        if (node != null) {
            return node.getValue();
        }
        return null;
    }

    private Node<Key, Value> getNode(Node<Key, Value> node, Key key) {
        if (node == null || key.equals(node.getKey())) {
            return node;
        }

        int cmp = key.compareTo(node.getKey());
        numSteps++;
        if (cmp < 0) {
            return getNode(node.getLeft(), key);
        } else {
            return getNode(node.getRight(), key);
        }
    }

    public void put(Key key, Value value) {
        root = putNode(root, key, value);
        root.setRed(false); // Root should always be black
    }

    private Node<Key, Value> putNode(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeft(putNode(node.getLeft(), key, value));
        } else if (cmp > 0) {
            node.setRight(putNode(node.getRight(), key, value));
        } else {
            node.setValue(value);
        }

        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }
        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(Node<Key, Value> node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> node) {
        Node<Key, Value> newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        newRoot.setRed(node.isRed());
        node.setRed(true);
        return newRoot;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> node) {
        Node<Key, Value> newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        newRoot.setRed(node.isRed());
        node.setRed(true);
        return newRoot;
    }

    private void flipColors(Node<Key, Value> node) {
        node.setRed(true);
        node.getLeft().setRed(false);
        node.getRight().setRed(false);
    }

    public int countRedLinks() {
        return countRedLinks(root);
    }

    private int countRedLinks(Node<Key, Value> node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (isRed(node.getLeft())) {
            count++;
        }
        if (isRed(node.getRight())) {
            count++;
        }
        count += countRedLinks(node.getLeft());
        count += countRedLinks(node.getRight());
        return count;
    }

    public int getNumSteps() {
        return numSteps;
    }
}

