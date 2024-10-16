import javax.swing.*;

public class MergeSortPanel extends SortPanel {
    public MergeSortPanel(SortPanel mainPanel) {
        super();
        sort(0, arraySize - 1);
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            repaint();
            try {
                Thread.sleep(10); // Visualization delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            repaint();
            try {
                Thread.sleep(10); // Visualization delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            repaint();
            try {
                Thread.sleep(10); // Visualization delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(left, mid);
            sort(mid + 1, right);
            merge(left, mid, right);
        }
    }
}
