package skillladder.level21_recursion;

/**
 *문제
 * 재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 *
 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 *
 * ***
 * * *
 * ***
 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
 *
 * 출력
 * 첫째 줄부터 N번째 줄까지 별을 출력한다.
 *
 * 예제 입력 1
 * 27
 * 예제 출력 1
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * ***   ******   ******   ***
 * * *   * ** *   * ** *   * *
 * ***   ******   ******   ***
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * *********         *********
 * * ** ** *         * ** ** *
 * *********         *********
 * ***   ***         ***   ***
 * * *   * *         * *   * *
 * ***   ***         ***   ***
 * *********         *********
 * * ** ** *         * ** ** *
 * *********         *********
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * ***   ******   ******   ***
 * * *   * ** *   * ** *   * *
 * ***   ******   ******   ***
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 */

import java.util.*;

public class P2447 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        boolean[][] targetArray = new boolean[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                targetArray[i][j] = true;
            }
        }
        function1(targetArray, 0, N, 0, N);
        for (boolean[] targetValueArray: targetArray){
            for (boolean targetValue: targetValueArray){
                if (targetValue){
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void function1(boolean[][] targetArray, int Left, int right, int top, int bottom){
        if (right-Left==1 && bottom-top==1){
            return;
        }
        int squreLength = (right-Left)/3;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (i==1 && j==1){
                    continue;
                }
                function1(
                        targetArray
                        , Left+i*squreLength, Left+(i+1)*squreLength
                        , top+j*squreLength, top+(j+1)*squreLength
                );
            }
        }
        for (int i=Left+squreLength; i<Left+2*squreLength; i++){
            for (int j=top+squreLength; j<top+2*squreLength; j++){
                targetArray[i][j] = false;
            }
        }
    }
}
