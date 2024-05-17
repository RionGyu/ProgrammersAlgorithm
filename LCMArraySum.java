import java.util.ArrayList;
import java.util.Scanner;

public class LCMArraySum {

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

    
    public static String solution(ArrayList<Integer> arr) {
        int n = arr.size();
        int lcmSum = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int lcmValue = lcm(arr.get(i), arr.get(j));
                lcmSum += lcmValue;
                result.append("{").append(arr.get(i)).append(" | ").append(arr.get(j)).append("} → ").append(lcmValue);
                if (i != n - 2 || j != n - 1) {
                    result.append(" + ");
                }
            }
        }

        result.append(" = ").append(lcmSum);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        while (arr.size() < 3) {
            System.out.print("최소 3개의 숫자를 콤마로 구분하여 입력해주세요: ");
            String input = scanner.nextLine();
            String[] parts = input.split(",");

            arr.clear();  // Clear the list to avoid appending multiple times
            for (String part : parts) {
                try {
                    arr.add(Integer.parseInt(part.trim()));
                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid integer
                    System.out.println("유효하지않은 입력입니다. 콤마로 구분해주세요");
                    arr.clear();
                    break;
                }
            }

            if (arr.size() < 3) {
                System.out.println("숫자를 최소 3개 이상입력해주세요");
            }
        }

        String result = solution(arr);
        System.out.println(result);
        
        scanner.close();
    }
}
