package skillladder.level08_basic_math1;

/**
 *문제
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 *
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 *
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 *
 * 입력
 * 첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)
 *
 * B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.
 *
 * 출력
 * 첫째 줄에 B진법 수 N을 10진법으로 출력한다.
 *
 * 예제 입력 1
 * ZZZZZ 36
 * 예제 출력 1
 * 60466175
 */

import java.util.*;

public class P2745 {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);

        String[] targetStrings =  scanner.nextLine().split(" ");
        char[] targetValue = targetStrings[0].toCharArray();
        int targetFormat = Integer.parseInt(targetStrings[1]);
        int sum = 0;
        for (int i=0; i<targetValue.length; i++){
            int targetNumber;
            if (((int) targetValue[i]>='A') && ((int) targetValue[i]<='Z')){
                targetNumber = 10 + targetValue[i] - 'A';
            } else {
                targetNumber = targetValue[i] - '0';
            }
            sum += targetNumber * Math.pow(targetFormat,targetValue.length-i-1);
        }
        System.out.println(sum);
    }
}
