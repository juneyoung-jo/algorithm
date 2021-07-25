import java.sql.Array;
import java.util.*;

public class test {

    static class Point {
        int r,c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public void setR(int r) {
            this.r = r;
        }

        public void setC(int c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) {

        List<Point> list = new ArrayList<>();

        list.add(new Point(10,10));
        list.add(new Point(20,20));
        list.add(new Point(30,30));
        list.add(new Point(40,40));
        list.add(new Point(50,50));

        Point p = new Point(100,100);
        for (Point point : list) {
            point.setC(100);
        }

        for (Point point : list) {
            System.out.println(point);
        }

        String str = "a";
        StringBuilder sb = new StringBuilder();
        sb.append("a");

        for(int i = 0; i<1000000; i++) {
//            str+= "a";
            sb.append("a");
        }
        System.out.println(sb.toString());


    }

}
