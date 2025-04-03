package skillladder.level24_prefix_sum;

/**
 *문제
 * 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 *
 * 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
 *
 * 입력
 * 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 *
 * 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
 *
 * 출력
 * 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 *
 * 예제 입력 1
 * 5 3
 * 1 2 3 1 2
 * 예제 출력 1
 * 7
 */

import java.util.*;
import java.io.*;

public class P10986 {
    // 목표: 연속된 구간합 M의 배수 -> 개수 구하기
    // 유의
    // 개수 구하기 문제
    // 누적합 -> 연속된 부분 구간 순회
    // n 10^6 -> O(n^2) 불가
    // -> 특수한 조건 찾기 필요
    // 누적합%m의 값이 동일한 경우에 대하여 +1 할 수 있음
    // -> [0,m) 범위 내에서 각 값 저장
    // 0인 경우 -> 그 자체만으로도 되므로 k*(k+1)/2
    // 그 이외 -> k*(k-1)/2
    // k*(k+1)/2 은 최대 10^12까지 근접할 수 있으므로 answer은 long 타입 사용 필요
    // 연산 과정에서 사용되는 변수 또한 long 타입 사용 권장
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            int[] prefix = new int[n+1];
            long[] targetValues = new long[m];
            for (int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st2.nextToken()) % m;;
                prefix[i] = (prefix[i-1] + arr[i]) % m;
                targetValues[prefix[i]]++;
            }

            long cnt = 0l;
            for (int i=0; i<m; i++){
                if (i==0){
                    cnt += (targetValues[i]*(targetValues[i]+1))/2;
                    continue;
                }
                cnt += (targetValues[i]*(targetValues[i]-1))/2;
            }
            sb.append(cnt);

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
