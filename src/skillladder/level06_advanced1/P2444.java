package skillladder.level06_advanced1;

/**
 * 문제
 * 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
 *
 * 출력
 * 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 *
 * 예제 입력 1
 * 5
 * 예제 출력 1
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 */

import java.util.*;

public class P2444 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int targetN = scanner.nextInt();
        for (int i=1; i<=targetN; i++){
            System.out.println(" ".repeat(targetN-i)+"*".repeat(2*i-1));
        }
        for (int i=1; i<targetN; i++){
            System.out.println(" ".repeat(i)+"*".repeat(2*(targetN-i)-1));
        }
    }
}
