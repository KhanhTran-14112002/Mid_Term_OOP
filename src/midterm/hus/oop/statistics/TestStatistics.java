package midterm.hus.oop.statistics;

import java.util.Random;

public class TestStatistics {
    static Random random = new Random();

    public static void main(String[] args) {
        testStatisticsUsingArrayDataSet();
        testStatisticsUsingLinkedListDataSet();
        /* Yêu cầu:

        I. Hoàn thiện các file source code đã cho. Viết các chức năng test cho chương trình.
        Viết hàm test cho ArrayDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         Viết hàm test cho LinkedListDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         II. Chạy các hàm test để test chương trình.
         Copy kết quả chạy chương trình và lưu vào file text có tên <TenSinhVien_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
         Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <TenSinhVien_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */
    }

    /**
     * Hàm test cho tập dữ liệu kiểu ArrayDataSet.
     */
    public static void testStatisticsUsingArrayDataSet() {
        // Generate a random natural number in the range [20 - 30]


        // Create an ArrayDataSet with random double values
        ArrayDataSet arrayDataSet = new ArrayDataSet();
        for (int i = 0; i < 20; i++) {
            double vl = random.nextDouble(20, 30);
            arrayDataSet.append(vl);
        }

        System.out.println("ArrayDataSet Statistics:");
        for (int i = 0; i < arrayDataSet.size(); i++) {
            System.out.print(arrayDataSet.get(i) + " ");
        }

        // Remove an element from the beginning and end of the dataset
        arrayDataSet.remove(0);
        arrayDataSet.remove(arrayDataSet.size() - 1);
        System.out.println();
        System.out.println("ArrayDataSet Statistics After Removing Elements:");
        for (int i = 0; i < arrayDataSet.size(); i++) {
            System.out.print(arrayDataSet.get(i) + " ");
        }
    }

    /**
     * Hàm test cho tập dữ liệu kiểu LinkedListDataSet.
     */
    public static void testStatisticsUsingLinkedListDataSet() {
        int dataSize = (int) (Math.random() * 11) + 20;

        // Create a LinkedListDataSet with random double values
        LinkedListDataSet linkedListDataSet = new LinkedListDataSet();
        for (int i = 0; i < 20; i++) {
            double vl = random.nextDouble(20, 30);
            linkedListDataSet.append(vl);
        }
        System.out.println();
        System.out.println("LinkedListDataSet Statistics:");
        for (int i = 0; i < linkedListDataSet.size(); i++) {
            System.out.print(linkedListDataSet.get(i) + " ");
        }


        // Remove an element from the beginning and end of the dataset
        linkedListDataSet.remove(0);
        linkedListDataSet.remove(linkedListDataSet.size() - 1);
        System.out.println();

        System.out.println("LinkedListDataSet Statistics After Removing Elements:");
        for (int i = 0; i < linkedListDataSet.size(); i++) {
            System.out.print(linkedListDataSet.get(i) + " ");
        }
    }
}
