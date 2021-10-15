/*

solving eq of type ax + by = k * gcd(a,b)
            divide both sides by k
             ax' + by' = gcd(a, b)
             now we can solve this eq by using extended euclidean theorom
*/

package Level3.NumberTheory;
import java.util.*;
public class linearDiophantinequation {
    static int x;
    static int y;
    static int g;
    static void gcd(int a, int b){
        if(b == 0){
            x = 1;
            y = 0;
            g = a;
            return;
        }

        gcd(b, a % b);
        int cx = y;
        int cy = x - a / b * y;

        x = cx;
        y = cy;
    }
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int k = 8;
        gcd(3, 5);
        x = x * k;
        y = y * k;
        System.out.println("Solution for the eq: " + a + "x" + " + " + b + "y = " + k + " * " + g + " is " + x  + "," + y);

        System.out.println("printing the next three solutions of the eq");
        for(int t = 1; t <= 3; t++){
            int nx = x - (b / g) * t;
            int ny = y + (a / g) * t;
            System.out.println(nx + " " + ny);
        }
    }
}
