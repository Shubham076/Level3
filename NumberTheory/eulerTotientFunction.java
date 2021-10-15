/*
you have been given a number n, count the number of integers between 1 to n inclusive, which are co-prime to n.
coprime are those which have only one as common factor

brutfeforce check all the pairs having gcd = 1  O(n * logn)

efficient solution euler totient functions
phi(n) =>  count the number of integers between 1 to n inclusive, which are co-prime to n.


//some important points
* phi(n) => n - 1 where n is prime number
* phi(n ^ k) => n ^ k  - n ^ k / k where n is prime number and k is non negative integer
   proof: as n is prime number n ^ k only contains factors of 2 types 1, x * n where x is any integer
     now 1 ---- x * n nos are not coprime with n ^ k
     so we have to find the count
     now how to find the count for eg how many factors of 2 are in 20 => 20 / 2
     similarly how many factors of n are there in n ^ k => n ^ k / k
 * phi(a * b) => phi(a) * phi(b) a & b should be coprime
 * phi(a * b) => phi(a) * phi(b) * d / phi(d) where d is gcd(a, b) a and b are not co prime

 now generic formula phi(n) => n * (1 - 1 / p1) * (1 - 1 / p2) ...... (1 - 1 / pn)
    where p1,p2, .....pn are prime factors of n

    O(sqrt(n))
*/
 package Level3.NumberTheory;
import java.util.*;
public class eulerTotientFunction {
    public static void main(String[] args) {
        int n = 7;
        int cnt = n;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                cnt = cnt - cnt / i;
            }
            while(n % i == 0){
                n = n / i;
            }
        }
        
        //after completing the loop it can be possible we are left with a prime number eg = 26
        // after completing the loop n becomes 13 which is prime factor
        if(n > 1){
            cnt = cnt - cnt / n;
        }
        
        System.out.println(cnt);
    }
}
