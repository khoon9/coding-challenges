package skillladder.level21_recursion;

/**
 *문제
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.
 *
 * 출력
 * 첫째 줄에 N!을 출력한다.
 *
 * 예제 입력 1
 * 10
 * 예제 출력 1
 * 3628800
 * 예제 입력 2
 * 0
 * 예제 출력 2
 * 1
 */

import java.util.*;
import java.math.*;

public class P27433 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        sb.append(targetFunction(N, BigInteger.valueOf(1))+"\n");

        System.out.println(sb);
    }
    public static BigInteger targetFunction(int nowNum, BigInteger bi){
        if (nowNum<=1){
            return bi.multiply(BigInteger.valueOf(1));
        }
        return targetFunction(nowNum-1,bi.multiply(BigInteger.valueOf(nowNum)));
    }
}
