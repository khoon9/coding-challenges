package skillladder.level15_divisors_multiples_primes2;

/**
 *문제
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 *
 * 출력
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 *
 * 예제 입력 1
 * 3 16
 * 예제 출력 1
 * 3
 * 5
 * 7
 * 11
 * 13
 */

import java.util.*;

public class P1929 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = scanner.nextInt();
        int N = scanner.nextInt();

        for (int i=M; i<=N; i++){
            if (i<=1){
                continue;
            }
            boolean flag = true;
            int targetSqrt = (int) Math.sqrt(i);
            for (int j=2; j<=targetSqrt;j++){
                if (i%j == 0){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
