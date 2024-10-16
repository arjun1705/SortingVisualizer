import javax.swing.*;

public class BubbleSortPanel extends SortPanel {
    public BubbleSortPanel(SortPanel mainPanel) {
        super();
        sort();
    }

    @Override
    public void sort() {
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = 0; j < arraySize - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                repaint();
                try {
                    Thread.sleep(10); // Visualization delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
