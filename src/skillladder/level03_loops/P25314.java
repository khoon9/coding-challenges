package skillladder.level03_loops;

/**
 * BOJ 25314 참고
 */

import java.util.Scanner;

public class P25314 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int byte_num = scanner.nextInt();
        for (int i=0; i<(byte_num/4); i++){
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
