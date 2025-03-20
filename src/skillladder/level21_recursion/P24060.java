package skillladder.level21_recursion;

/**
 *문제
 * 오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
 *
 * N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
 *
 * 크기가 N인 배열에 대한 병합 정렬 의사 코드는 다음과 같다.
 *
 * merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
 *     if (p < r) then {
 *         q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
 *         merge_sort(A, p, q);      # 전반부 정렬
 *         merge_sort(A, q + 1, r);  # 후반부 정렬
 *         merge(A, p, q, r);        # 병합
 *     }
 * }
 *
 * # A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
 * # A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
 * merge(A[], p, q, r) {
 *     i <- p; j <- q + 1; t <- 1;
 *     while (i ≤ q and j ≤ r) {
 *         if (A[i] ≤ A[j])
 *         then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
 *         else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
 *     }
 *     while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
 *         tmp[t++] <- A[i++];
 *     while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
 *         tmp[t++] <- A[j++];
 *     i <- p; t <- 1;
 *     while (i ≤ r)  # 결과를 A[p..r]에 저장
 *         A[i++] <- tmp[t++];
 * }
 * 입력
 * 첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 저장 횟수 K(1 ≤ K ≤ 108)가 주어진다.
 *
 * 다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
 *
 * 출력
 * 배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력한다.
 *
 * 예제 입력 1
 * 5 7
 * 4 5 1 3 2
 * 예제 출력 1
 * 3
 * 4 5 1 3 2 -> 4 5 1 3 2 -> 4 5 1 3 2 -> 1 5 1 3 2 -> 1 4 1 3 2 -> 1 4 5 3 2 -> 1 4 5 2 2 -> 1 4 5 2 3 -> 1 4 5 2 3 -> 1 2 5 2 3 -> 1 2 3 2 3 -> 1 2 3 4 3 -> 1 2 3 4 5. 총 12회 저장이 발생하고 일곱 번째 저장되는 수는 3이다.
 *
 * 예제 입력 2
 * 5 13
 * 4 5 1 3 2
 * 예제 출력 2
 * -1
 * 저장 횟수 12가 K 보다 작으므로 -1을 출력한다.
 */

import java.util.*;

public class P24060 {
    // 병합 정렬
    // k 번째 저장되는 수 구하기
    // 배열 A[]에 값이 저장되는 순간을 말하는 것으로 판단됨
    private static long targetCnt = 0;
    private static long K;
    private static int targetValue = -1;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        StringTokenizer st1 = new StringTokenizer(scanner.nextLine());
        int N = Integer.parseInt(st1.nextToken());
        K = Long.parseLong(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(scanner.nextLine());
        int[] targetArray = new int[N];
        for (int i=0; i<N; i++){
            targetArray[i] = Integer.parseInt(st2.nextToken());
        }
        mergeSort(targetArray, 0, N-1);
        sb.append(targetValue);

        System.out.println(sb);
    }
    public static void mergeSort(int[] A, int p, int r){
        if (p < r){
            int q = (p+r)/2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }
    public static void merge(int[] A, int p, int q, int r){
        int i = p;
        int j = q+1;
        int t = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j <= r){
            if (A[i]<=A[j]){
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        while (i<=q){
            tmp[t++] = A[i++];
        }
        while (j<=r){
            tmp[t++] = A[j++];
        }
        i = p;
        t = 0;
        while (i<=r){
            targetCnt++;
            if (targetCnt==K){
                targetValue = tmp[t];
            }
            A[i++] = tmp[t++];
        }
    }
}
