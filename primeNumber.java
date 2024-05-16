import java.util.Scanner;

public class primeNumber {
   

    public static void solution(int str) {
        if (str <4){
            System.out.println("a는 최소 4부터 입력 가능합니다.");
            
        } else {
            int[] arr = new int[str+1];
            int answer = 0;
            for (int i = 4; i <= str; i++) {
                if (arr[i] == 0) {
                    answer ++;
                    for (int j = i; j <= str; j+=i) {
                        arr[j]=1;
                    }
                }
            }
            System.out.println(answer);
        }
        
    }

    public static void main(String[] args) {
        // 테스트 예제
        Scanner kb = new Scanner(System.in);
        int str = kb.nextInt();
        solution(str);
    }
}

