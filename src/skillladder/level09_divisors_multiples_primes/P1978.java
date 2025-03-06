package skillladder.level09_divisors_multiples_primes;

/**
 *문제
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * 출력
 * 주어진 수들 중 소수의 개수를 출력한다.
 *
 * 예제 입력 1
 * 4
 * 1 3 5 7
 * 예제 출력 1
 * 3
 */

import java.util.*;

public class P1978 {
    // 1을 제외한 소수 개수 세기
    // 100개 이하 숫자 조사. 각 숫자 최댓값 1000. -> 전수조사 가능
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        int targetCnt = 0;
        while (st.hasMoreTokens()){
            int targetValue = Integer.parseInt(st.nextToken());
            if(targetValue<=1){
                continue;
            }
            boolean flagPrimeNumber = true;
            for (int i=2; i<targetValue; i++){
                if ((targetValue%i)==0){
                    flagPrimeNumber = false;
                    break;
                }
            }
            if (flagPrimeNumber){
                targetCnt++;
            }
        }

        System.out.println(targetCnt);
    }
}
