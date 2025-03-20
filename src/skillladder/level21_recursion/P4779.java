package skillladder.level21_recursion;

/**
 * 문제
 * 칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.
 *
 * 전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.
 *
 * 1. -가 3N개 있는 문자열에서 시작한다.
 *
 * 2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
 *
 * 3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
 *
 * 예를 들어, N=3인 경우, 길이가 27인 문자열로 시작한다.
 *
 * ---------------------------
 * 여기서 가운데 문자열을 공백으로 바꾼다.
 *
 * ---------         ---------
 * 남은 두 선의 가운데 문자열을 공백으로 바꾼다.
 *
 * ---   ---         ---   ---
 * 한번 더
 *
 * - -   - -         - -   - -
 * 모든 선의 길이가 1이면 멈춘다. N이 주어졌을 때, 마지막 과정이 끝난 후 결과를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력을 여러 줄로 이루어져 있다. 각 줄에 N이 주어진다. 파일의 끝에서 입력을 멈춘다. N은 0보다 크거나 같고, 12보다 작거나 같은 정수이다.
 *
 * 출력
 * 입력으로 주어진 N에 대해서, 해당하는 칸토어 집합의 근사를 출력한다.
 *
 * 예제 입력 1
 * 0
 * 1
 * 3
 * 2
 * 예제 출력 1
 * -
 * - -
 * - -   - -         - -   - -
 * - -   - -
 */

import java.util.*;

public class P4779 {
    // 3의 12제곱 -> 9의 6제곱 < 10의 6제곱 => int
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = 0;
        while (scanner.hasNext()) {
            N = scanner.nextInt();
            boolean[] targetArray = new boolean[(int) Math.pow(3,N)];
            for (int i=0; i<targetArray.length; i++){
                targetArray[i] = true;
            }
            function1(targetArray,0,targetArray.length);
            for (int i=0; i<targetArray.length; i++){
                if(targetArray[i]){
                    sb.append("-");
                } else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void function1(boolean[] targetArray, int l, int r){
        if (r-l==1){
            return;
        }
        int q1 = l+(r-l)/3;
        int q2 = l+2*(r-l)/3;
        for (int i=q1; i<q2; i++){
            targetArray[i] = false;
        }
        function1(targetArray,l,q1);
        function1(targetArray,q2,r);
    }
}
