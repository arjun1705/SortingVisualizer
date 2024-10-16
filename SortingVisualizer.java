import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortingVisualizer extends JPanel implements ActionListener {
    private static final int SCREEN_WIDTH = 910;
    private static final int SCREEN_HEIGHT = 750;
    private static final int ARR_SIZE = 130;
    private static final int RECT_SIZE = 7;

    private int[] arr = new int[ARR_SIZE];
    private int[] Barr = new int[ARR_SIZE];
    private boolean complete = false;
    private Timer timer;
    private String sortingAlgorithm = "";

    public SortingVisualizer() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        timer = new Timer(40, this);
        randomizeAndSaveArray();
        loadArr();
    }

    private void randomizeAndSaveArray() {
        Random random = new Random();
        for (int i = 0; i < ARR_SIZE; i++) {
            Barr[i] = random.nextInt(SCREEN_HEIGHT);
        }
    }

    private void loadArr() {
        System.arraycopy(Barr, 0, arr, 0, ARR_SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < ARR_SIZE; i++) {
            if (complete) {
                g.setColor(new Color(100, 180, 100));
            } else if (sortingAlgorithm.equals("current") && (i == arr.length - 1 || i == arr.length - 2)) {
                g.setColor(new Color(165, 105, 189)); // Color for the currently swapping elements
            } else {
                g.setColor(new Color(170, 183, 184)); // Default bar color
            }
            g.fillRect(i * RECT_SIZE, SCREEN_HEIGHT - arr[i], RECT_SIZE, arr[i]);
        }
    }

    public void selectionSort() {
        new Thread(() -> {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                    repaint();
                    delay();
                }
                swap(i, minIndex);
                repaint();
            }
            complete = true;
        }).start();
    }

    public void insertionSort() {
        new Thread(() -> {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                    repaint();
                    delay();
                }
                arr[j + 1] = key;
                repaint();
            }
            complete = true;
        }).start();
    }

    public void bubbleSort() {
        new Thread(() -> {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j + 1] < arr[j]) {
                        swap(j, j + 1);
                    }
                    repaint();
                    delay();
                }
            }
            complete = true;
        }).start();
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void delay() {
        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void showControls() {
        String controls = "Available Controls inside Sorting Visualizer:\n"
                + "Press 0 to generate a different randomized list.\n"
                + "Press 1 for Selection Sort.\n"
                + "Press 2 for Insertion Sort.\n"
                + "Press 3 for Bubble Sort.\n"
                + "Press q to exit.";
        JOptionPane.showMessageDialog(this, controls, "Controls", JOptionPane.INFORMATION_MESSAGE);
    }

    public void runSorting() {
        String[] options = {"Selection Sort", "Insertion Sort", "Bubble Sort", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(this, "Choose a sorting algorithm:",
                    "Sorting Algorithm", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    complete = false;
                    sortingAlgorithm = "selection";
                    selectionSort();
                    break;
                case 1:
                    complete = false;
                    sortingAlgorithm = "insertion";
                    insertionSort();
                    break;
                case 2:
                    complete = false;
                    sortingAlgorithm = "bubble";
                    bubbleSort();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        SortingVisualizer visualizer = new SortingVisualizer();

        frame.add(visualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        visualizer.showControls();
        visualizer.runSorting();
    }
}
