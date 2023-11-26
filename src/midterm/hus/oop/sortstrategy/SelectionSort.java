package midterm.hus.oop.sortstrategy;

public class SelectionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Selection sort.
     * @param data
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order == true){
            sortAscending(data);
        }else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
         int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử nhỏ nhất trong đoạn chưa sắp xếp
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên của đoạn chưa sắp xếp
            double temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        int n = data.length;

        for (int i = 0; i < n - 1; i++) {
            // Tìm phần tử lớn nhất trong đoạn chưa sắp xếp
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] > data[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Hoán đổi phần tử lớn nhất với phần tử đầu tiên của đoạn chưa sắp xếp
            double temp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = temp;
        }
    }
}
