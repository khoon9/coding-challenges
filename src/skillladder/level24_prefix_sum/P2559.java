package skillladder.level24_prefix_sum;

/**
 *문제
 * 매일 아침 9시에 학교에서 측정한 온도가 어떤 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 알아보고자 한다.
 *
 * 예를 들어, 아래와 같이 10일 간의 온도가 주어졌을 때,
 *
 * 3 -2 -4 -9 0 3 7 13 8 -3
 *
 * 모든 연속적인 이틀간의 온도의 합은 아래와 같다.
 *
 *
 *
 * 이때, 온도의 합이 가장 큰 값은 21이다.
 *
 * 또 다른 예로 위와 같은 온도가 주어졌을 때, 모든 연속적인 5일 간의 온도의 합은 아래와 같으며,
 *
 *
 *
 * 이때, 온도의 합이 가장 큰 값은 31이다.
 *
 * 매일 측정한 온도가 정수의 수열로 주어졌을 때, 연속적인 며칠 동안의 온도의 합이 가장 큰 값을 계산하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에는 두 개의 정수 N과 K가 한 개의 공백을 사이에 두고 순서대로 주어진다. 첫 번째 정수 N은 온도를 측정한 전체 날짜의 수이다. N은 2 이상 100,000 이하이다. 두 번째 정수 K는 합을 구하기 위한 연속적인 날짜의 수이다. K는 1과 N 사이의 정수이다. 둘째 줄에는 매일 측정한 온도를 나타내는 N개의 정수가 빈칸을 사이에 두고 주어진다. 이 수들은 모두 -100 이상 100 이하이다.
 *
 * 출력
 * 첫째 줄에는 입력되는 온도의 수열에서 연속적인 K일의 온도의 합이 최대가 되는 값을 출력한다.
 *
 * 예제 입력 1
 * 10 2
 * 3 -2 -4 -9 0 3 7 13 8 -3
 * 예제 출력 1
 * 21
 * 예제 입력 2
 * 10 5
 * 3 -2 -4 -9 0 3 7 13 8 -3
 * 예제 출력 2
 * 31
 */

import java.util.*;
import java.io.*;

public class P2559 {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            int[] prefix = new int[n+1];
            for (int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st2.nextToken());
                prefix[i] = prefix[i-1] + arr[i];
            }
            int[] sumOfCntK = new int[n-k+1];
            for (int i=0; i<n-k+1; i++){
                sumOfCntK[i] = prefix[i+k] - prefix[i];
            }
            int maxValue = Arrays.stream(sumOfCntK).max().orElse(0);
            sb.append(maxValue);

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
