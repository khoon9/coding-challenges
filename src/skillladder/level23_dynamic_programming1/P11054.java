package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
 *
 * 예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만, {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
 *
 * 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)
 *
 * 출력
 * 첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.
 *
 * 예제 입력 1
 * 10
 * 1 5 2 1 4 3 4 5 2 1
 * 예제 출력 1
 * 7
 */

import java.util.*;

public class P11054 {
    // 목표: 오름차 - 내림차 수열 최대 길이 찾기
    // 유의:
    // 특정 값 기준 오른 방향으로 내림차순 진행, 왼 방향으로 오른차순 진행
    private static int[] cache0;
    private static int[] cache1;
    private static int[] cache2;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        int[] targetArray = new int[n];
        scanner.nextLine();
        StringTokenizer st1 = new StringTokenizer(scanner.nextLine());
        for (int i=0; i<n; i++){
            targetArray[i] = Integer.parseInt(st1.nextToken());
        }
        cache1 = new int[n];
        for (int i=0; i<n; i++){
            cache0 = new int[n];
            function1(n, i, targetArray);
            cache1[i] = cache0[i];
        }
        int maxValue = 1;
        for (int i=0; i<n; i++){
            cache2 = new int[n];
            function2(n, i, targetArray);
            int targetValue = cache2[i] + cache1[i] - 1;
            maxValue = (targetValue>maxValue? targetValue: maxValue);
        }
        sb.append(maxValue);

        System.out.println(sb);
    }
    // 반환 최솟값 1
    // 내림차순 진행될 경우 현재 위치 포함 오른쪽 방향 수열의 최대 길이
    public static int function1(int n, int x, int[] targetArray){
        if (cache0[x] != 0){
            return cache0[x];
        }
        if (x==n-1){
            cache0[x] = 1;
            return cache0[x];
        }
        int maxValue = 1;
        for (int i=1; i+x<n; i++){
            if (targetArray[i+x]<targetArray[x]){
                int targetValue = 1 + function1(n, i+x, targetArray);
                maxValue = (targetValue>maxValue? targetValue: maxValue);
            }
        }
        cache0[x] = maxValue;
        return cache0[x];
    }
    // 반환 최솟값 1
    // 오름차순 진행될 경우 현재 위치 포함 왼쪽 방향 수열의 최대 길이
    public static int function2(int n, int x, int[] targetArray){
        if (cache2[x] != 0){
            return cache2[x];
        }
        if (x==0){
            cache2[x] = 1;
            return cache2[x];
        }
        int maxValue = 1;
        for (int i=1; -i+x>=0; i++){
            if (targetArray[-i+x]<targetArray[x]){
                int targetValue = 1 + function2(n, -i+x, targetArray);
                maxValue = (targetValue>maxValue? targetValue: maxValue);
            }
        }
        cache2[x] = maxValue;
        return cache2[x];
    }
}
