package skillladder.level15_divisors_multiples_primes2;

/**
 *문제
 * 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
 * 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
 *
 * 입력
 * 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
 *
 * 출력
 * 각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 6
 * 8
 * 10
 * 12
 * 100
 * 예제 출력 1
 * 1
 * 1
 * 2
 * 1
 * 6
 */

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class P17103 {
    // 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다 -> 라는 명제에서 출발
    // 2보다 큰 짝수 N에 대하여 두 소수의 합으로 나타낼 수 있는 가짓수
    // 순서만 바꾼 합 표현은 동일한 표현으로 간주
    // 개수 구하기 문제
    // 2~1,000,000 까지의 소수를 하나의 리스트에 보관하고 set에도 보관
    // (N - 소수) 값이 set에 포함되어 있지 않다면 소수가 아니라는 방식으로 진행
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());
            List<Integer> targetPrimeList = new ArrayList<>();
            for (int i=2; i<1000000; i++){
                boolean flag = true;
                int targetSqrt = (int) Math.sqrt(i);
                for (int j=2; j<=targetSqrt; j++){
                    if (i%j==0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    targetPrimeList.add(i);
                }
            }
            Set<Integer> targetPrimeSet = targetPrimeList.stream().collect(Collectors.toSet());
            for (int i=0; i<T; i++){
                int n = Integer.parseInt(br.readLine());
                int targetCnt = 0;
                for (int j=0; j<targetPrimeList.size(); j++){
                    if (targetPrimeList.get(j)>(n/2)){
                        break;
                    }
                    int targetPrimeNumber = n - targetPrimeList.get(j);
                    if (targetPrimeSet.contains(targetPrimeNumber)){
                        targetCnt++;
                    }
                }
                sb.append(targetCnt).append("\n");
            }

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
