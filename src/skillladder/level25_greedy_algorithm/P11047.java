package skillladder.level25_greedy_algorithm;

/**
 *문제
 * 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 *
 * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
 *
 * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 *
 * 출력
 * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
 *
 * 예제 입력 1
 * 10 4200
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 * 예제 출력 1
 * 6
 * 예제 입력 2
 * 10 4790
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 * 예제 출력 2
 * 12
 */

import java.util.*;
import java.io.*;

public class P11047 {
    // 목표: 가치 합 K로 만드는 동전 개수 최솟값 구하기
    // 유의:
    // 동전별로 매우 많은 동전을 가지고 있다 -> 중복 허용
    // A[i]는 A[i-1]의 배수 -> 더 큰 단위의 동전으로 먼저 몫을 구하는 구조가 최적해
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            int cnt = 0;
            for (int i=n-1; i>=0; i--){
                cnt += (k/arr[i]);
                k %= arr[i];
            }
            sb.append(cnt);

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
