import javax.swing.*;

public class QuickSortPanel extends SortPanel {
    public QuickSortPanel(SortPanel mainPanel) {
        super();
        sort(0, arraySize - 1);
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                repaint();
                try {
                    Thread.sleep(10); // Visualization delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private void sort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            sort(low, pi - 1);
            sort(pi + 1, high);
        }
    }
}
