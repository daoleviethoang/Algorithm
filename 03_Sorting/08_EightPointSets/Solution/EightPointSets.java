import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class EightPointSets {
    public String solve(Point[] points) {
        LinkedHashSet <Integer> xSet = new LinkedHashSet <>();
        LinkedHashSet <Integer> ySet = new LinkedHashSet <>();

        Arrays.sort(points, (p1, p2) -> Point.equals(p1, p2));

        int countX1 = 0;
        int countX3 = 0;
        for(Point point: points) {
            if (point.getX() == points[0].getX()) {
                countX1++;
            }
            if (point.getX() == points[7].getX()) {
                countX3++;
            }

            xSet.add(point.getX());
            ySet.add(point.getY());
        }

        if (xSet.size() != 3 || ySet.size() != 3) {
            return "ugly";
        }
        if (countX1 != 3 || countX3 != 3) {
            return "ugly";
        }
        if (points[0].getY() != points[5].getY() 
        || points[1].getY() != points[6].getY()
        || points[2].getY() != points[7].getY()) {
            return "ugly";
        }
        if (points[3].getY() != points[0].getY() || points[4].getY() != points[7].getY()) {
            return "ugly";
        }

        return "respectable";
    }
    
    public static void main(String[] args) {
        EightPointSets solution = new EightPointSets();
        Scanner scanner = new Scanner(System.in);


        Point[] points = new Point[8];
        for (int i = 0; i < 8; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        scanner.close();

        System.out.print(solution.solve(points));
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int equals(Point p1, Point p2) {
        if (p1.getX() > p2.getX()) {
            return 1;
        } else if (p1.getX() == p2.getX()) {
            if (p1.getY() > p2.getY()) {
                return 1;
            } else if (p1.getY() < p2.getY()) {
                return -1;
            }
            return 0;
        }
        return -1;
    }
}
