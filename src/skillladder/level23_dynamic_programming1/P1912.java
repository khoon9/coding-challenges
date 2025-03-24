package skillladder.level23_dynamic_programming1;

/**
 *문제
 * n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.
 *
 * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
 *
 * 입력
 * 첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄에 답을 출력한다.
 *
 * 예제 입력 1
 * 10
 * 10 -4 3 1 5 6 -35 12 21 -1
 * 예제 출력 1
 * 33
 * 예제 입력 2
 * 10
 * 2 1 -4 3 4 -4 6 5 -5 1
 * 예제 출력 2
 * 14
 * 예제 입력 3
 * 5
 * -1 -2 -3 -4 -5
 * 예제 출력 3
 * -1
 */

import java.util.*;

public class P1912 {
    // 연속
    // 목적: 최대합 구하기
    // targetCache -> 해당 idx에서 시작해서 최댓값
    private static int[] targetCache;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer st1 = new StringTokenizer(scanner.nextLine());
        int[] board = new int[n];
        for (int i=0; i<n; i++){
            board[i] = Integer.parseInt(st1.nextToken());
        }
        targetCache = new int[n];
        for (int i=0; i<n; i++){
            targetCache[i] = Integer.MIN_VALUE;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--){
            int targetValue = function1(i, n, board);
            if (targetValue>maxValue){
                maxValue = targetValue;
            }
        }
        sb.append(maxValue);

        System.out.println(sb);
    }
    // nowIdx부터 최대값 구하기
    public static int function1(int nowIdx, int n, int[] board){
        if (targetCache[nowIdx]!=Integer.MIN_VALUE){
            return targetCache[nowIdx];
        }
        if (nowIdx+1<n){
            int targetValue = function1(nowIdx+1, n, board);
            if (targetValue>0){
                targetCache[nowIdx] = board[nowIdx] + targetValue;
                return targetCache[nowIdx];
            }
        }
        targetCache[nowIdx] = board[nowIdx];
        return targetCache[nowIdx];
    }
}
