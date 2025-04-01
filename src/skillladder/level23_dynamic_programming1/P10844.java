package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 45656이란 수를 보자.
 *
 * 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
 *
 * N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
 *
 * 출력
 * 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 *
 * 예제 입력 1
 * 1
 * 예제 출력 1
 * 9
 * 예제 입력 2
 * 2
 * 예제 출력 2
 * 17
 */

import java.util.*;

public class P10844 {
    // 목적: (길이 N인 수에 대하여) 계단 수 값 구하기
    // 유의:
    // 10^9 의 나머지 값만 필요
    // 계단수는 옆 자릿수와 1차이만 나는 것을 의미
    // 0 또는 9의 경우 다음 수 혹은 이전 수가 한 가지임
    // 맨 왼쪽자리는 0이 올 수 없음

    // 호출된 수, 그리고 호출된 수 기준 자릿수에 대해 cache 저장. 왼쪽부터 시작
    // 기준 수가 이미 정해져 있으므로 이후(오른쪽 방향)만 정하면 됨
    private static int[][] cache;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        cache = new int[10][n];
        int sumValue = 0;
        for (int i=1; i<=9; i++){
            function(n, i, 0);
            sumValue += cache[i][0];
            sumValue %= 1000000000;
        }
        sb.append(sumValue);

        System.out.println(sb);
    }
    public static int function(int n, int x, int idx){
        if (idx==n-1){
            cache[x][idx] = 1;
            return cache[x][idx];
        }
        if (cache[x][idx] != 0){
            return cache[x][idx];
        }
        int sumValue = 0;
        if (x-1>=0){
            sumValue += function(n, x-1, idx+1);
        }
        if (x+1<=9){
            sumValue += function(n, x+1, idx+1);
        }
        sumValue %= 1000000000;
        cache[x][idx] = sumValue;
        return sumValue;
    }
}
