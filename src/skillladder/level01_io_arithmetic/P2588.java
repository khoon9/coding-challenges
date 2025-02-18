package skillladder.level01_io_arithmetic;

import java.util.Scanner;

/**
 * 문제:
 * (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
 * - BOJ 2588 그림 참고
 * (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
 *
 * 입력:
 * 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
 *
 * 출력:
 * 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
 */
public class P2588 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (!((a<1000) && (a>99) && (b<1000) && (b>99))) {
            System.out.print("잘못된 입력입니다");
            return;
        }

        System.out.println(a*(b%10));
        System.out.println(a*((b%100)/10));
        System.out.println(a*(b/100));
        System.out.println(a*b);
    }
}
