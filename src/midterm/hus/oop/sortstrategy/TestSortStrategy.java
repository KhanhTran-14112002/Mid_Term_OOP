package midterm.hus.oop.sortstrategy;

import java.util.Arrays;
import java.util.Random;

public class TestSortStrategy {
    public static void main(String[] args) {

        Random random = new Random();
        SortStrategy sortStrategy = SortStrategy.getInstance();

        // Generate a random natural number in the range [20 - 30]
        int arraySize = random.nextInt(11) + 20;

        // Generate a random array of double values
        double[] originalArray = new double[arraySize];
        for (int i = 0; i < arraySize; i++) {
            originalArray[i] = random.nextDouble() * 100; // Adjust the multiplier as needed
        }

        // Copy the data to two more arrays
        double[] array1 = Arrays.copyOf(originalArray, originalArray.length);
        double[] array2 = Arrays.copyOf(originalArray, originalArray.length);
        double[] array3 = Arrays.copyOf(originalArray, originalArray.length);
        // Test Bubble Sort Algorithm
        Sorter bubbleSort = new BubbleSort();
        sortStrategy.setSortee(bubbleSort);

        System.out.println("Using Bubble Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array1));
        sortStrategy.sort(array1,true);
        System.out.println("After sorting Ascending: " + Arrays.toString(array1));
        sortStrategy.sort(array1,false);
        System.out.println("After sorting Descending: " + Arrays.toString(array1));
        System.out.println();

        Sorter insertionSort = new InsertionSort();
        sortStrategy.setSortee(insertionSort);

        System.out.println("Using InsertionSort Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array2));
        sortStrategy.sort(array2,true);
        System.out.println("After sorting Ascending: " + Arrays.toString(array2));
        sortStrategy.sort(array2,false);
        System.out.println("After sorting Descending: " + Arrays.toString(array2));
        System.out.println();

        Sorter selectionSort = new SelectionSort();
        sortStrategy.setSortee(selectionSort);

        System.out.println("Using selectionSort Sort Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(array3));
        sortStrategy.sort(array3,true);
        System.out.println("After sorting Ascending: " + Arrays.toString(array3));
        sortStrategy.sort(array3,false);
        System.out.println("After sorting Descending: " + Arrays.toString(array3));
        System.out.println();


        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Copy dữ liệu mảng trên sang 2 mảng khác để có 3 mảng có dữ liệu giống nhau.
        - Tạo đối tượng có kiểu dữ liệu SortStrategy. Dùng đối tượng này test 3 thuật toán đã cho với 3 mảng dữ liệu trên.
          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_SortStrategy.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom
         */

    }
}
