package midterm.hus.oop.studentmanager;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        this.studentList = new LinkedList<>();
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     *
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        if (index < 0 || index > limit) {
            return false;
        }
        return true;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     *
     * @param student
     */
    public void append(Student student) {
        studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index, chỉ thêm vào nếu index có giá trị
     * nằm trong đoạn từ [0 - length], trong đó length là số sinh viên trong danh sách hiện tại.
     *
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        if (checkBoundaries(index,studentList.size())){
            studentList.set(index,student);
        }
    }

    /**
     * Xóa sinh viên ở vị trí index, chỉ xóa được nếu index nằm trong đoạn [0 - (length - 1)],
     * trong đó length là số sinh viên trong danh sách hiện tại.
     *
     * @param index
     */
    public void remove(int index) {
        if (checkBoundaries(index,studentList.size())){
            studentList.remove(index);
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index.
     *
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        return studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên và sau đó đến họ.
     *
     * @return
     */
    public List<Student> sortStudentByName() {
        List<Student> copy = new LinkedList<>(studentList);
//        Arrays.sort(copy,(s1,s2)->{
        int n = copy.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (copy.get(i - 1).getAverageGrade() > copy.get(i).getAverageGrade()) {
                    Student temp = copy.get(i - 1);
                    studentList.set(i - 1,copy.get(i));
                    studentList.set(i,temp);

                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        return copy;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeIncreasing() {
        List<Student> copy = new LinkedList<>(studentList);
        int n = copy.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (copy.get(i - 1).getAverageGrade() > copy.get(i).getAverageGrade()) {
                    Student temp = copy.get(i - 1);
                    studentList.set(i - 1,copy.get(i));
                    studentList.set(i,temp);

                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        return copy;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự giảm dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeDecreasing() {
        List<Student> copy = new LinkedList<>(studentList);
        int n = copy.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (copy.get(i - 1).getAverageGrade() < copy.get(i).getAverageGrade()) {
                    Student temp = copy.get(i - 1);
                    studentList.set(i - 1,copy.get(i));
                    studentList.set(i,temp);

                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        return copy;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả tốt nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     *
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestGrade(int howMany) {
        if (howMany<0){
            return null;
        }
        if (howMany>studentList.size()){
            return studentList;
        }
        // Convert newList to an array for sorting
        List<Student> sortByGradeDecreasing= sortByGradeDecreasing();
        List<Student> studentsHighestGrade = new LinkedList<>();
        for (int i = 0; i < howMany; i++) {
            studentsHighestGrade.add(sortByGradeDecreasing.get(i));
        }
        return studentsHighestGrade;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả thấp nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     *
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestGrade(int howMany) {
        if (howMany<0){
            return null;
        }
        if (howMany>studentList.size()){
            return studentList;
        }
        // Convert newList to an array for sorting
        List<Student> sortByGradeDecreasing= sortByGradeIncreasing();
        List<Student> studentsLowestGrade = new LinkedList<>();
        for (int i = 0; i < howMany; i++) {
            studentsLowestGrade.add(sortByGradeDecreasing.get(i));
        }
        return studentsLowestGrade;
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
