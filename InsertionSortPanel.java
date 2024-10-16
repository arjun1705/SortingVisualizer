import javax.swing.*;

public class InsertionSortPanel extends SortPanel {
    public InsertionSortPanel(SortPanel mainPanel) {
        super();
        sort();
    }

    @Override
    public void sort() {
        for (int i = 1; i < arraySize; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                repaint();
                try {
                    Thread.sleep(10); // Visualization delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            array[j + 1] = key;
        }
    }
}
