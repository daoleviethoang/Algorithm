import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            boolean[] visited = new boolean[n];
            Queue<Element> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                Element element = new Element(v, i, i == m ? true : false);
                queue.add(element);
                a[i] = v;
                visited[i] = false;
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Element e = queue.peek();
                int flag = 0;
                for (int i = 0; i < a.length; i++) {
                    if (e.getValue() < a[i] && !visited[i]) {
                        Element tmp = queue.poll();
                        queue.add(tmp);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    count++;
                    if (e.getLocation()) {
                        break;
                    }
                    visited[queue.peek().getIndex()] = true;
                    queue.remove();
                }
            }

            System.out.println(count);
        }

        scanner.close();
    }
}

class Element {
    private int value;
    private int index;
    private boolean isLocation;

    public Element(int value, int index, boolean isLocation) {
        this.value = value;
        this.index = index;
        this.isLocation = isLocation;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getLocation() {
        return isLocation;
    }

    public void setLocation(boolean isLocation) {
        this.isLocation = isLocation;
    }
}
