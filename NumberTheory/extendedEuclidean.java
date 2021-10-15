/*
solving eq of type ax + by = gcd(a, b)
  find value of x and y which satisfies the equation

euclids algorithm gcd(a, b) => gcd(b, a % b) --- 1

proof => ax + by = gcd(a, b) -------------- 2
        we can rewrite the above eq is
        bx' + (a % b)y' = gcd(b, a % b); ----------  3

        as rhs of both eq are equal from eq1
        lhs is also equal

        now a % b = a - [a / b] * b
        substituting this in eq 3

        bx' + (a - [a / b] * b)y' = gcd(a, b % a)
        b(x' [a / b]y') + ay' = gcd(a, b % a)

        on comparing the coefficients with eq 2

        x = y' && y = (x' - [a / b]y')

       simlarly after reducing the eq we hit base case means b == 0 we get value of x' = 1 & y' = 0
       from these x' && y' we calculate the values of x && y from avove derived eq
*/
//O(log(min(a, b))
package Level3.NumberTheory;
public class extendedEuclidean {
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
        int cy = x - (a / b) * y;

        x = cx;
        y = cy;
    }
    public static void main(String[] args) {
        int a = 34;
        int b = 24;
        gcd(a, b);
        System.out.println("Solution for the eq: " + a + "x" + " + " + b + "y = " + g + " is " + x  + "," + y);
    }
}
