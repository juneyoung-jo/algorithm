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

    }

}
