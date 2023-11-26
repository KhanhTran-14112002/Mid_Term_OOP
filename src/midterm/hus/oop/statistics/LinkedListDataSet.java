package midterm.hus.oop.statistics;

import java.util.List;

public class LinkedListDataSet extends AbstractDataSet {
    private Node head;

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public LinkedListDataSet() {
        this.head = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public double get(int index) {
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node node = getNodeByIndex(index);
        return node.data;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(double data, int index) {
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node node = getNodeByIndex(index);
        node.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        if (!checkBoundaries(index, size())) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = getNodeByIndex(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node previous = getNodeByIndex(index - 1);
            previous.next = previous.next.next;
        }
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        if (!checkBoundaries(index, size() - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public double[] toArray() {
        double[] arr = new double[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.data;
            current = current.next;
        }
        return arr;
    }

    private static class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }
}
