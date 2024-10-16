import javax.swing.*;

public class HeapSortPanel extends SortPanel {
    public HeapSortPanel(SortPanel mainPanel) {
        super();
        sort();
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            // Swap
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            repaint();
            try {
                Thread.sleep(10); // Visualization delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            heapify(n, largest);
        }
    }

    public void sort() {
        int n = arraySize;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Swap
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            repaint();
            try {
                Thread.sleep(10); // Visualization delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            heapify(i, 0);
        }
    }
}
