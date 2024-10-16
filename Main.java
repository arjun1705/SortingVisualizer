import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sorting Visualizer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JButton bubbleSortButton = new JButton("Bubble Sort");
            JButton insertionSortButton = new JButton("Insertion Sort");
            JButton selectionSortButton = new JButton("Selection Sort");
            JButton mergeSortButton = new JButton("Merge Sort");
            JButton quickSortButton = new JButton("Quick Sort");
            JButton heapSortButton = new JButton("Heap Sort");

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(bubbleSortButton);
            buttonPanel.add(insertionSortButton);
            buttonPanel.add(selectionSortButton);
            buttonPanel.add(mergeSortButton);
            buttonPanel.add(quickSortButton);
            buttonPanel.add(heapSortButton);

            SortPanel sortPanel = new SortPanel();
            frame.add(sortPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            // Action Listeners
            bubbleSortButton.addActionListener(e -> {
                sortPanel.setSortingAlgorithm(new BubbleSortPanel(sortPanel));
            });
            insertionSortButton.addActionListener(e -> {
                sortPanel.setSortingAlgorithm(new InsertionSortPanel(sortPanel));
            });
            selectionSortButton.addActionListener(e -> {
                sortPanel.setSortingAlgorithm(new SelectionSortPanel(sortPanel));
            });
            mergeSortButton.addActionListener(e -> {
                sortPanel.setSortingAlgorithm(new MergeSortPanel(sortPanel));
            });
            quickSortButton.addActionListener(e -> {
                sortPanel.setSortingAlgorithm(new QuickSortPanel(sortPanel));
            });
            heapSortButton.addActionListener(e -> {
                sortPanel.setSortingAlgorithm(new HeapSortPanel(sortPanel));
            });

            frame.setSize(900, 700);
            frame.setVisible(true);
        });
    }
}
