public class lcmSum {

    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    
    public static int lcm(int x, int y) {
        return x * (y / gcd(x, y));
    }



    
}
