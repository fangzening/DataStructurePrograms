// zening fang
// assignment 2 complexity

public class Complexity {
     
    // time complexity:  O(n^2)
    public static void method1(int n) {
        int counter = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                System.out.println("Operation " + counter);
                counter++;
            }
        }
    }

    // O(n^3)
    public static void method2(int n) {
        int counter = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    System.out.println("Opeation " + counter);
                    counter++;
                }
            }
        }
    }

    // O(logn)
    public static void method3(int n) {
        int counter = 0;
        for (int i=1; i<=n; i*= 2) {
            System.out.println("Operation " + counter);
            counter++;
        }
    }

    // O(n log n)
    public static void method4(int n) {
        int counter = 0;
        for (int i=0; i<n; i++) {
            for (int j=1; j<=n; j*=2) {
                System.out.println("Operation " + counter);
                counter++;
            }
        }
    }

    // time complexity O(log log n)
    public static void method5(int n) {
        int counter = 0;
        for (int i=2; i<n; i*= i) {
            System.out.println("Operation5 " + counter);
            counter++;
        }
    }

    //Method 6:complexity with O(2^n). i made two solutions for this problem, method 6 and method6_1. reference from https://www.baeldung.com/java-algorithm-complexity 
    static private int counter6 = 0;
    public static int method6(int n) {
        // base case 1&2
        if(n == 0) {
            counter6++;
            System.out.println("Operation " + counter6);
            return counter6;
        }
        else if(n == 1) {
            System.out.println("Operation " + counter6);
            counter6++;
            System.out.println("Operation " + counter6);
            counter6++;
            return counter6;
        }
        // use the recursion
        method6(n-1);
        method6(n-1);
        return counter6;
    }

    public static void method6_1(int n){
        int counter = 0;
        for (int i = 1; i <= Math.pow(2, n); i++){
            System.out.println("Operation " + counter);
            counter++;
        }
    }

}

        

