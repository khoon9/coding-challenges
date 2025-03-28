package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
 *
 * 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 *
 * 입력
 * 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
 *
 * 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
 *
 * 출력
 * 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 *
 * 예제 입력 1
 * 6
 * 10 20 10 30 20 50
 * 예제 출력 1
 * 4
 */

import java.util.*;

public class P11053 {
    // 목표: (증가하는 수열의 길이) 최대값 구하기
    // 유의:
    // 수열의 요소는 입력값에서 임의로 건너뛰어 추출할 수 있다. 단, 순서는 유지된다.
    // 현재 위치 기준 -> cache
    private static int[] cache;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer st1 = new StringTokenizer(scanner.nextLine());
        int[] targetArray = new int[n];
        for (int i=0; i<n; i++){
            targetArray[i] = Integer.parseInt(st1.nextToken());
        }
        int maxValue = 0;
        for (int i=0; i<n; i++){
            cache = new int[n];
            function1(n, i, targetArray);
            maxValue = (cache[i]>maxValue? cache[i]: maxValue);
        }
        sb.append(maxValue);

        System.out.println(sb);
    }
    public static int function1(int n, int idx, int[] targetArray){
        if (cache[idx]!=0){
            return cache[idx];
        }
        if (idx==n-1){
            cache[idx] = 1;
            return cache[idx];
        }
        int maxValue = 1;
        for (int i=1; i+idx<n; i++){
            if (targetArray[i+idx]>targetArray[idx]){
                int targetValue = 1 + function1(n, i+idx, targetArray);
                maxValue = (targetValue>maxValue? targetValue: maxValue);
            }
        }
        cache[idx] = maxValue;
        return cache[idx];
    }
}
