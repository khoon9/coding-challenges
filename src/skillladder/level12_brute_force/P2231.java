package skillladder.level12_brute_force;

/**
 *문제
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 *
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 *
 * 출력
 * 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 *
 * 예제 입력 1
 * 216
 * 예제 출력 1
 * 198
 */

import java.util.*;

public class P2231 {
    // N = M + 각 자릿수 합 -> M은 N의 생성자다.
    // N은 1 ~ 1,000,000 자연수
    // N>M
    // 1~N-1까지 생성자 여부 검사. 가장 먼저 나온 생성자 저장 후 break
    // 만약 안 나왔으면 0 출력
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int targetRes = 0;
        for (int i=0; i<N; i++){
            int placeNum = 0;
            int NumState = i;
            while (NumState>0){
                placeNum += (NumState%10);
                NumState = (NumState/10);
            }
            if ((i + placeNum) == N){
                targetRes = i;
                break;
            }
        }
        sb.append(targetRes);

        System.out.println(sb);
    }
}
