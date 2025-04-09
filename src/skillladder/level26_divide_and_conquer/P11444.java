package skillladder.level26_divide_and_conquer;

/**
 *문제
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 *
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 *
 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 *
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 *
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 1000
 * 예제 출력 1
 * 517691607
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class P11444 {
    // 목표: 피보나치 수 구하기
    // 유의:
    // 구하기 문제
    // 0 -> 0, 1-> 1, n -> n-1 + n-2
    // 10^18 -> long 범위 내에서 처리 가능
    // 시간 복잡도 O(n)일 경우 불가능
    // 시간 복잡도 O(log n) 또는 O(n^(1/2)) 요구
    // mod = 1000000007 -> 10^9+7 -> 소수값
    // 피보나치 수
    // F_(n+1) + F_(n) = 2*F_(n) + F_(n-1)
    private static long[][] base = {{1l, 1l}, {1l, 0l}};
    private static Map<Long, long[][]> cache = new HashMap<>();
    private static long mod = 1000000007l;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            long n = Long.parseLong(br.readLine());
            function1(n);
            sb.append(cache.get(n)[1][0]);

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static long[][] function1(long n){
        if (cache.containsKey(n)){
            return cache.get(n);
        }
        if (n==1){
            cache.put(n, base);
            return cache.get(n);
        }
        if (n==0){
            cache.put(n, new long[2][2]);
            return cache.get(n);
        }
        long[][] targetA;
        long[][] targetB;
        long[][] targetAnswer = new long[2][2];
        if (n%2==0l){
            targetA = function1(n/2);
            targetB = targetA;
        } else {
            targetA = function1(n/2);
            targetB = function1(n/2+1);
        }
        for (int i=0; i<2; i++){
            for (int j=0; j<2; j++){
                for (int k=0; k<2; k++){
                    targetAnswer[i][j] += (targetA[i][k]*targetB[k][j]);
                    targetAnswer[i][j] %= mod;
                }
            }
        }
        cache.put(n, targetAnswer);
        return cache.get(n);
    }
}
