package skillladder.level24_prefix_sum;

/**
 *문제
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 *
 * 출력
 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 *
 * 제한
 * 1 ≤ N ≤ 100,000
 * 1 ≤ M ≤ 100,000
 * 1 ≤ i ≤ j ≤ N
 * 예제 입력 1
 * 5 3
 * 5 4 3 2 1
 * 1 3
 * 2 4
 * 5 5
 * 예제 출력 1
 * 12
 * 9
 * 1
 */

import java.util.*;
import java.io.*;

public class P11659 {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            int[] prefixSum = new int[n+1];
            for (int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st2.nextToken());
                prefixSum[i] = prefixSum[i-1] + arr[i];
            }
            int[][] arr2 = new int[m][2];
            for (int i=0; i<m; i++){
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                arr2[i][0] = Integer.parseInt(st3.nextToken());
                arr2[i][1] = Integer.parseInt(st3.nextToken());
            }
            for (int i=0; i<m; i++){
                int start = arr2[i][0];
                int last = arr2[i][1];
                int targetValue = prefixSum[last] - prefixSum[start-1];
                sb.append(targetValue+"\n");
            }

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
