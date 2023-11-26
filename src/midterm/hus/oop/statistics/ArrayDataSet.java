package midterm.hus.oop.statistics;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Hàm dựng để khởi tạo dữ liệu.
     */
    public ArrayDataSet() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Lấy kích thước của tập dữ liệu.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return
     */
    @Override
    public double get(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(double data, int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this.data[index] = data;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value là giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void append(double value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của mảng dữ liệu.
     * Nếu mảng không còn chỗ, mở rộng mảng để có thể chứa thêm dữ liệu.
     * @param value
     * @param index
     */
    @Override
    public void insert(double value, int index) {
        if (!checkBoundaries(index, size)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (size == data.length) {
            allocateMore();
        }

        // Shift elements to make space for the new element
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        // Insert the new element
        data[index] = value;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        // Shift elements to remove the specified element
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    /**
     * Mở rộng gấp đôi kích thước mảng nếu hết chỗ để chứa dữ liệu.
     */
    private void allocateMore() {
        int newCapacity = data.length * 2;
        double[] newData = new double[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    @Override
    public double[] toArray() {
        double[] arr = new double[size];
        System.arraycopy(data, 0, arr, 0, size);
        return arr;
    }
}
