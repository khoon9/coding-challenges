package skillladder.level01_io_arithmetic;

import java.util.Scanner;

// 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
public class P10869 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        // int/int = int
        System.out.println(a/b);
        System.out.println(a%b);
    }
}
