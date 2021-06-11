package code;

import java.util.Arrays;

public class Main {

    class Point {
        int x;
        int y;
    }

    public class Jarvis {

        private boolean orijentacija(Point p, Point q, Point r) {
            int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

            if (val >= 0)
                return false;
            return true;
        }

        public void ispisi(Point[] points, int[] next) {
            System.out.println("\nTacke : ");
            for (int i = 0; i < next.length; i++)
                if (next[i] != -1)
                    System.out.println("(" + points[i].x + ", " + points[i].y + ")");
        }

        public void Jarvis(Point[] points)
        {
            int n = points.length;
            //ako je manje od 3 tacke ne postoji ravan
            if (n < 3)
                return;
            int[] next = new int[n];
            Arrays.fill(next, -1);

            // trazenje najlevlje tacke
            int najlevlja = 0;
            for (int i = 1; i < n; i++)
                if (points[i].x < points[najlevlja].x)
                    najlevlja = i;
            int p = najlevlja, q;
            // prolazak kroz petlju dok p ne postane najlevlja
            do
            {
                // pakovanje
                q = (p + 1) % n;
                for (int i = 0; i < n; i++)
                    if (orijentacija(points[p], points[i], points[q]))
                        q = i;

                next[p] = q;
                p = q;
            } while (p != najlevlja);


            ispisi(points, next);
        }

    }




    public static void main(String[] args) {

    }
}
