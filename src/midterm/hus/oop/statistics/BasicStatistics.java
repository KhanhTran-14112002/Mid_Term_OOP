package midterm.hus.oop.statistics;

public class BasicStatistics implements Statistics {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistics() {
        // Default constructor, no initialization needed.
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public double max() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double max = dataSet.get(0);
        for (int i = 1; i < size; i++) {
            double current = dataSet.get(i);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public double min() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double min = dataSet.get(0);
        for (int i = 1; i < size; i++) {
            double current = dataSet.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    @Override
    public double mean() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += dataSet.get(i);
        }
        return sum / size;
    }

    @Override
    public double variance() {
        int size = dataSet.size();
        if (size < 2) {
            throw new IllegalStateException("Dataset size must be at least 2 for variance calculation");
        }

        double mean = mean();
        double sumSquaredDifferences = 0;
        for (int i = 0; i < size; i++) {
            double difference = dataSet.get(i) - mean;
            sumSquaredDifferences += difference * difference;
        }
        return sumSquaredDifferences / (size - 1);
    }

    @Override
    public AbstractDataSet rank() {
        // Implement rank calculation based on the specific logic you want to use
        // Return an instance of AbstractDataSet with the calculated ranks
        // You may need to define a class that extends AbstractDataSet and implements rank logic
        // For example, you could have a RankDataSet class that extends AbstractDataSet and implements rank
        return null;
    }

    @Override
    public double median() {
        // Implement median calculation based on the specific logic you want to use
        // Return the calculated median value
        return 0;
    }
}
