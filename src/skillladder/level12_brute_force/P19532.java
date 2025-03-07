package skillladder.level12_brute_force;

/**
 *문제
 * (BOJ 19532 참고)
 */

import java.util.*;

public class P19532 {
    // a*x + b*y - c == 0
    // d*x + e*y - f == 0
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        for (int x=-999; x<=999; x++){
            for (int y=-999; y<=999; y++){
                if ((a*x + b*y - c == 0) && (d*x + e*y - f == 0)){
                    sb.append(x+" "+y);
                    break;
                }
            }
            if (sb.toString().length()!=0){
                break;
            }
        }

        System.out.println(sb);
    }
}
