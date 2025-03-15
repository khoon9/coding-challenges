package skillladder.level19_combinatorics;

/**
 *문제
 * 자연수
 * \(N\)과 정수
 * \(K\)가 주어졌을 때 이항 계수
 * \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에
 * \(N\)과
 * \(K\)가 주어진다. (1 ≤
 * \(N\) ≤ 10, 0 ≤
 * \(K\) ≤
 * \(N\))
 *
 * 출력
 *
 * \(\binom{N}{K}\)를 출력한다.
 *
 * 예제 입력 1
 * 5 2
 * 예제 출력 1
 * 10
 */

import java.util.*;

public class P11050 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int facNK = 1;
        for (int i=N; i>(N-K); i--){
            facNK *= i;
        }
        int facK = 1;
        for (int i=K; i>0; i--){
            facK *= i;
        }
        sb.append(facNK/facK);

        System.out.println(sb);
    }
}
