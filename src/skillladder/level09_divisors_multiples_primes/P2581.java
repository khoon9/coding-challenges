package skillladder.level09_divisors_multiples_primes;

/**
 *문제
 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 *
 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최솟값은 61이 된다.
 *
 * 입력
 * 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
 *
 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 *
 * 출력
 * M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다.
 *
 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 *
 * 예제 입력 1
 * 60
 * 100
 * 예제 출력 1
 * 620
 * 61
 * 예제 입력 2
 * 64
 * 65
 * 예제 출력 2
 * -1
 */

import java.util.*;

public class P2581 {
    // M, N < 10,000 이하
    // 전수조사 방식 이외의 소수 판별 방법: 약수 여부를 2 ~ 제곱근까지만 조사해도 됨.
    // 소수 없으면 -1 출력
    // 소수 합, 소수 최솟값 각각 출력
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i=M; i<=N; i++){
            if (i==1){
                continue;
            }
            boolean flagPrime = true;
            for (int j=2; j*j<=i; j++){
                if ((i%j)==0){
                    flagPrime = false;
                    break;
                }
            }
            if (flagPrime){
                sum += i;
                min = ((i<min) ? i : min);
            }
        }
        if (sum == 0){
            sb.append("-1").append("\n");
        } else {
            sb.append(sum).append("\n");
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
