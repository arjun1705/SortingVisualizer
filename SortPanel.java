import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class SortPanel extends JPanel {
    protected int[] array;
    protected int arraySize = 130;

    public SortPanel() {
        this.array = new int[arraySize];
        randomizeArray();
        setPreferredSize(new Dimension(900, 600));
    }

    public void randomizeArray() {
        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = rand.nextInt(500); // Random height for bars
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = getWidth() / arraySize;
        for (int i = 0; i < arraySize; i++) {
            g.fillRect(i * barWidth, getHeight() - array[i], barWidth, array[i]);
        }
    }

    public abstract void sort();
}
