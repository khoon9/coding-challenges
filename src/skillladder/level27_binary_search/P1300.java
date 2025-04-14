package skillladder.level27_binary_search;

/**
 * 문제
 * 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
 *
 * 배열 A와 B의 인덱스는 1부터 시작한다.
 *
 * 입력
 * 첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.
 *
 * 출력
 * B[k]를 출력한다.
 *
 * 예제 입력 1
 * 3
 * 7
 * 예제 출력 1
 * 6
 */

import java.util.*;
import java.io.*;

public class P1300 {
    // 목표: B 오름차순 정렬 -> B[k] = ? 구하기
    // 유의:
    // 구하기 문제
    // k값은 B의 크기 이내
    // 단위: N 10^5, N*N 10^10 -> 배열 직접 표현 불가능
    // value(~N*N), idx(=k)(~N*N),

    // 행렬 예시
    // 1 2  3  4  5  6
    // 2 4  6  8  10 12
    // 3 6  9  12 15 18
    // 4 8  12 16 20 24
    // 5 10 15 20 25 30
    // 6 12 18 24 30 36
    // 각 요소 -> A[i][j] = i*j -> B[i*N + j] = i*j
    // B -> sort -> 값이 오를 수록 idx 또한 높아진다
    // 특정 값 선택  -> idx 구하기 -> k와 비교 후 이분 탐색 수행
    // 범위가 가장 큰 대상은 누군가? i*j
    // value/j -> i, value/i -> j
    // idx -> value
    // value -> idx 이게 더 심플한 시간복잡도로 도출 가능하다면 value에 이분 탐색 적용
    // value = T -> idx = G 이걸 알 수 있는 특수한 조건을 찾아야함
    // value = i*j
    // 행 기준 나눗셈 반복하면 O(N)이내에 value의 idx 알 수 있음
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            long N = Long.parseLong(br.readLine());
            long K = Long.parseLong(br.readLine());
            long left = 1;
            long right = Math.min(1000000000, N*N);
            long targetValue = 0;
            while (left<=right){
                long mid = (left + right)/2;
                if (check(N, K, mid)){
                    targetValue = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(targetValue);

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static boolean check(long n, long k, long mid) {
        long cnt = 1;
        for (int i=1; i<=n; i++){
            cnt += (n*i<mid? n*i: mid-1)/i;
        }
        return cnt<=k;
    }
}
