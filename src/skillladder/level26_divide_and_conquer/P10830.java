package skillladder.level26_divide_and_conquer;

/**
 *문제
 * 크기가 N*N인 행렬 A가 주어진다. 이때, A의 B제곱을 구하는 프로그램을 작성하시오. 수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.
 *
 * 입력
 * 첫째 줄에 행렬의 크기 N과 B가 주어진다. (2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)
 *
 * 둘째 줄부터 N개의 줄에 행렬의 각 원소가 주어진다. 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0이다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 걸쳐 행렬 A를 B제곱한 결과를 출력한다.
 *
 * 예제 입력 1
 * 2 5
 * 1 2
 * 3 4
 * 예제 출력 1
 * 69 558
 * 337 406
 * 예제 입력 2
 * 3 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 예제 출력 2
 * 468 576 684
 * 62 305 548
 * 656 34 412
 * 예제 입력 3
 * 5 10
 * 1 0 0 0 1
 * 1 0 0 0 1
 * 1 0 0 0 1
 * 1 0 0 0 1
 * 1 0 0 0 1
 * 예제 출력 3
 * 512 0 0 0 512
 * 512 0 0 0 512
 * 512 0 0 0 512
 * 512 0 0 0 512
 * 512 0 0 0 512
 */

import java.util.*;
import java.io.*;

public class P10830 {
    // 목표: 정방행렬 A의 B제곱 구하기
    // 유의:
    // 구하기 문제
    // B -> B/2 B/2 또는 1 B/2 B/2
    private static Map<Long, int[][]> cache = new HashMap<>();;
    private static int[][] A;
    private static int[][] I;
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            long B = Long.parseLong(st1.nextToken());
            A = new int[N][N];
            for (int i=0; i<N; i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    A[i][j] = Integer.parseInt(st2.nextToken());
                    A[i][j] %= 1000;
                }
            }
            // 항등 행렬
            I = new int[N][N];
            for (int i=0; i<N; i++){
                I[i][i] = 1;
            }
            function1(N, B);
            int[][] answer = cache.get(B);
            Arrays.stream(answer).forEach(target->{
                Arrays.stream(target).forEach(target2->sb.append((target2)+" "));
                sb.append("\n");
            });

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // 분할 정복
    public static int[][] function1(int n, long b){
        if (cache.containsKey(b)){
            return cache.get(b);
        }
        if (b==1){
            cache.put(b, A);
            return cache.get(b);
        }
        if (b==0){
            cache.put(b, I);
            return cache.get(b);
        }
        int[][] targetA;
        int[][] targetB;
        // 분할
        if (b%2==0l){
            targetA = function1(n, b/2);
            targetB = function1(n, b/2);
        } else {
            targetA = function1(n, b/2);
            targetB = function1(n, b/2+1);
        }
        // 정복
        int[][] res = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    res[i][j] += targetA[i][k]*targetB[k][j];
                }
                res[i][j] %= 1000;
            }
        }
        cache.put(b, res);
        return cache.get(b);
    }
}
