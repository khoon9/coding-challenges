package skillladder.level29_dynamic_programming2;

/**
 * 문제
 * 크기가 N×M인 행렬 A와 M×K인 B를 곱할 때 필요한 곱셈 연산의 수는 총 N×M×K번이다. 행렬 N개를 곱하는데 필요한 곱셈 연산의 수는 행렬을 곱하는 순서에 따라 달라지게 된다.
 *
 * 예를 들어, A의 크기가 5×3이고, B의 크기가 3×2, C의 크기가 2×6인 경우에 행렬의 곱 ABC를 구하는 경우를 생각해보자.
 *
 * AB를 먼저 곱하고 C를 곱하는 경우 (AB)C에 필요한 곱셈 연산의 수는 5×3×2 + 5×2×6 = 30 + 60 = 90번이다.
 * BC를 먼저 곱하고 A를 곱하는 경우 A(BC)에 필요한 곱셈 연산의 수는 3×2×6 + 5×3×6 = 36 + 90 = 126번이다.
 * 같은 곱셈이지만, 곱셈을 하는 순서에 따라서 곱셈 연산의 수가 달라진다.
 *
 * 행렬 N개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최솟값을 구하는 프로그램을 작성하시오. 입력으로 주어진 행렬의 순서를 바꾸면 안 된다.
 *
 * 입력
 * 첫째 줄에 행렬의 개수 N(1 ≤ N ≤ 500)이 주어진다.
 *
 * 둘째 줄부터 N개 줄에는 행렬의 크기 r과 c가 주어진다. (1 ≤ r, c ≤ 500)
 *
 * 항상 순서대로 곱셈을 할 수 있는 크기만 입력으로 주어진다.
 *
 * 출력
 * 첫째 줄에 입력으로 주어진 행렬을 곱하는데 필요한 곱셈 연산의 최솟값을 출력한다. 정답은 231-1 보다 작거나 같은 자연수이다. 또한, 최악의 순서로 연산해도 연산 횟수가 231-1보다 작거나 같다.
 *
 * 예제 입력 1
 * 3
 * 5 3
 * 3 2
 * 2 6
 * 예제 출력 1
 * 90
 */

import java.util.*;
import java.io.*;

public class P11049 {
    // 목적: 행렬 곱셈 순서에 따른 연산 횟수 최소화
    // 유의:
    // N 5 * 10^2
    // r, c 5 * 10^2
    // O(N^3) 10^6 -> 가능
    // 탑다운, 분할정복, 동적 계획법 사용
    public static int[][] dp;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int i=0; i<N; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                // row length
                arr[i][0] = Integer.parseInt(st1.nextToken());
                // col length
                arr[i][1] = Integer.parseInt(st1.nextToken());
            }
            dp = new int[N][N];
            int minValue = function1(arr, 0, N-1);
            sb.append(minValue);

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // 분할 정복 ->
    // 3 4  4 2  2 6
    // 맨 앞[0] * 가운데 * 맨 뒤[1] + function(쪼개기1) + function(쪼개기2)
    // base -> return 0
    public static int function1(int[][] arr, int l, int r){
        if (dp[l][r] !=0){
            return dp[l][r];
        }
        if (l-r == 0){
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        for (int i=l; i<r; i++){
            int target = arr[l][0] * arr[i][1] * arr[r][1] + function1(arr, l, i) + function1(arr, i+1, r);
            minValue = (target<minValue? target: minValue);
        }
        dp[l][r] = minValue;
        return dp[l][r];
    }
}
