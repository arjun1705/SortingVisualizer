import javax.swing.*;

public class SelectionSortPanel extends SortPanel {
    public SelectionSortPanel(SortPanel mainPanel) {
        super();
        sort();
    }

    @Override
    public void sort() {
        for (int i = 0; i < arraySize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arraySize; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                repaint();
                try {
                    Thread.sleep(10); // Visualization delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Swap
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
