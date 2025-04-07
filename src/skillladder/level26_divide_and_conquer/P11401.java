package skillladder.level26_divide_and_conquer;

/**
 *문제
 * 자연수
 * \(N\)과 정수
 * \(K\)가 주어졌을 때 이항 계수
 * \(\binom{N}{K}\)를 1,000,000,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에
 * \(N\)과
 * \(K\)가 주어진다. (1 ≤
 * \(N\) ≤ 4,000,000, 0 ≤
 * \(K\) ≤
 * \(N\))
 *
 * 출력
 *
 * \(\binom{N}{K}\)를 1,000,000,007로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 5 2
 * 예제 출력 1
 * 10
 */

import java.util.*;
import java.io.*;

public class P11401 {
    // 목표: 이항계수 구하기
    // 유의:
    // 이항계수 수식을 알고 있어야함 -> 문제에선 제시해주지 않았음
    // C(5, 3) = (5*4*3)/(3*2*1) (4*3*2)/(3*2*1) (4*3)/(2*1)
    // C(n, k) = C(n-1, k) + C(n-1, k-1) -> 깊이가 너무 큼
    // 크기 -> 10^12 까지 가능
    // 특수한 조건을 찾는 문제 -> 팩토리얼의 특성
    // n!/(n-k)! = nPk
    // n!/((n-k)!*k!) = nPk/(k!)
    // 만약 1,000,000,007가 소수라서, 분모의 나머지값 0이 될 수 없다면
    // -> 페르마의 소정리 활용
    private static Map<Long, Long> cache1 = new HashMap<>();
    private static Map<Long, Long> cache2 = new HashMap<>();
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());
            long mod = 1000000007;
            long[] factorialArr = new long[N+1];
            factorialArr[0] = 1;
            for (int i=1; i<=N; i++){
                factorialArr[i] = (factorialArr[i-1]*i)%mod;
            }
            long answer = (factorialArr[N]*(function1(factorialArr[N-K], mod-2, mod)*function2(factorialArr[K], mod-2, mod) % mod)) % mod;
            sb.append(answer);

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static long function1(long a, long b, long mod){
        if (cache1.containsKey(b)){
            return cache1.get(b);
        }
        if (b==0){
            cache1.put(b, 1l);
            return cache1.get(b);
        }
        if (b>1){
            if (b%2==0){
                cache1.put(b, (function1(a, b/2, mod)*function1(a, b/2, mod)) % mod);
                return cache1.get(b);
            } else {
                cache1.put(b, ((a % mod)*(function1(a, b/2, mod)*function1(a, b/2, mod) % mod)) % mod);
                return cache1.get(b);
            }
        }
        cache1.put(b, ((long) Math.pow(a, b)) % mod);
        return cache1.get(b);
    }
    public static long function2(long a, long b, long mod){
        if (cache2.containsKey(b)){
            return cache2.get(b);
        }
        if (b==0){
            cache2.put(b, 1l);
            return cache2.get(b);
        }
        if (b>1){
            if (b%2==0){
                cache2.put(b, (function2(a, b/2, mod)*function2(a, b/2, mod)) % mod);
                return cache2.get(b);
            } else {
                cache2.put(b, ((a % mod)*(function2(a, b/2, mod)*function2(a, b/2, mod) % mod)) % mod);
                return cache2.get(b);
            }
        }
        cache2.put(b, ((long) Math.pow(a, b)) % mod);
        return cache2.get(b);
    }
}
