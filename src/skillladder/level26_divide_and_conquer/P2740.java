package skillladder.level26_divide_and_conquer;

/**
 *문제
 * N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 행렬 A의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다. 그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다. 이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다. N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 *
 * 예제 입력 1
 * 3 2
 * 1 2
 * 3 4
 * 5 6
 * 2 3
 * -1 -2 0
 * 0 0 3
 * 예제 출력 1
 * -1 -2 6
 * -3 -6 12
 * -5 -10 18
 */

import java.util.*;
import java.io.*;

public class P2740 {
    // 목표: 행렬곱 구하기
    // 유의:
    // 구하기 문제
    // 크기 -> (100*100)*(100) <= 10^6 -> int
    // 방법1: 10^6 회 연산 O(n^3)
    // 방법2: 분할 정복 방식으로 접근
    // 분할 정복 -> 범위 구분 후 연산 반복
    // N*M M*K -> T*T, T*T
    // zero-padding을 넣어, 정방행렬곱으로 표현 후
    // 4등분 하여 재귀 반복
    // C1 = A1*B1+A2*B3
    // C2 = A3*B1+A4*B3
    // C3 = A1*B2+A2*B4
    // C4 = A3*B2+A4*B4
    // -> 메모리 초과
    // 단순 계산 후 저장 방식 O(N*M*K) <= 10^6 이하 반복
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());
            int[][] A = new int[N][M];
            for (int i=0; i<N; i++){
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int j=0; j<M; j++){
                    A[i][j] = Integer.parseInt(st3.nextToken());
                }
            }
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            Integer.parseInt(st2.nextToken());
            int K = Integer.parseInt(st2.nextToken());
            int[][] B = new int[M][K];
            for (int i=0; i<M; i++){
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                for (int j=0; j<K; j++){
                    B[i][j] = Integer.parseInt(st3.nextToken());
                }
            }
            int[][] C = new int[N][K];
            for (int i=0; i<N; i++){
                for (int j=0; j<K; j++){
                    for (int l=0; l<M; l++){
                        C[i][j] += A[i][l]*B[l][j];
                    }
                    sb.append(C[i][j]+" ");
                }
                sb.append("\n");
            }

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
