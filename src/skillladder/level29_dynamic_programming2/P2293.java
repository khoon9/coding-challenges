package skillladder.level29_dynamic_programming2;

/**
 * 문제
 * n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
 *
 * 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
 *
 * 입력
 * 첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 경우의 수를 출력한다. 경우의 수는 231보다 작다.
 *
 * 예제 입력 1
 * 3 10
 * 1
 * 2
 * 5
 * 예제 출력 1
 * 10
 */

import java.util.*;
import java.io.*;

public class P2293 {
    // 목표: 동전 선택 합 k 가치가 되는 경우의 수 구하기
    // 유의:
    // 동전 종류별 개수 제한 없음
    // 종류별 사용 개수가 다른 경우에만 다른 경우의 수로 취급
    // n -> 10^2, k -> 10^4
    // 최대 경우의 수 -> 2^31 -> int 범위 내 사용 가능
    // [현재 동전 종류][현재 남은 가치] -> 10^2 * 10^4 -> 10^6 상태로 dp 사용 가능
    public static int[][] dp;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int K = Integer.parseInt(st1.nextToken());
            int[] arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            arr = Arrays.stream(arr).boxed().sorted(Comparator.comparing(target->target, Comparator.reverseOrder())).mapToInt(Integer::intValue).toArray();
            dp = new int[N][K+1];
            for (int i=0; i<N; i++) {
                for (int j=0; j<K+1; j++) {
                    dp[i][j] = -1;
                }
            }
            int cnt = function(arr, 0, K);
            sb.append(cnt);

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static int function(int[] arr, int nowIdx, int nowValue) {
        if (dp[nowIdx][nowValue] != -1){
            return dp[nowIdx][nowValue];
        }
        if (nowValue==0){
            dp[nowIdx][nowValue] = 1;
            return dp[nowIdx][nowValue];
        }
        if (nowIdx==arr.length-1){
            if (nowValue%arr[nowIdx] == 0) {
                dp[nowIdx][nowValue] = 1;
                return dp[nowIdx][nowValue];
            } else {
                dp[nowIdx][nowValue] = 0;
                return dp[nowIdx][nowValue];
            }
        }
        int cnt = 0;
        for (int i=0; (nowValue-arr[nowIdx]*i)>=0; i++) {
            cnt += function(arr, nowIdx+1, nowValue-arr[nowIdx]*i);
        }
        dp[nowIdx][nowValue] = cnt;
        return dp[nowIdx][nowValue];
    }
}
