public class LinkedList <T extends Comparable<T>> {
    private Node root;
    private int size;

    private class Node {
        T value;
        Node next;

        Node() {
        }

        Node(T _value) {
            this.value = _value;
        }

        Node(T _value, Node _next) {
            this.value = _value;
            this.next = _next;
        }
    }
    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }
    public void addAt(T value, int index) {
        if (index < 0 || index > size)
            return;
        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = root;
            root = newNode;
            size++;
            return;
        }
        Node currentNode = getNode(index - 1);
        Node newNode = new Node(value, currentNode.next);
        currentNode.next = newNode;
        size++;
    }
    private Node getNode(int index) {
        if (index < 0 || index >= size)
            return null;
        if (index == 0)
            return root;
        Node currentNode = root;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public void revert() {
        for (int i = 0; i < size/2; i++) {
            Node node1 = getNode(i);
            Node node2 = getNode(size - i - 1);
            T temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
        }
    }
    public void print() {
        Node currentNode = root;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
