package skillladder.level01_io_arithmetic;

import java.util.Scanner;

// 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.(0 < A, B < 10, 10^-9 이하의 상대오차 요구)
public class P1008 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        System.out.printf("%.10f", a/b);
    }
}
