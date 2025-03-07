package skillladder.level10_geometry_rectangles_triangles;

/**
 *문제
 * 삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.
 *
 * Equilateral :  세 변의 길이가 모두 같은 경우
 * Isosceles : 두 변의 길이만 같은 경우
 * Scalene : 세 변의 길이가 모두 다른 경우
 * 단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.
 *
 * 세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.
 *
 * 입력
 * 각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.
 *
 * 출력
 * 각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.
 *
 * 예제 입력 1
 * 7 7 7
 * 6 5 4
 * 3 2 5
 * 6 2 6
 * 0 0 0
 * 예제 출력 1
 * Equilateral
 * Scalene
 * Invalid
 * Isosceles
 */

import java.util.*;
import java.io.*;

public class P5073 {
    // 큰 변 < 작은 두 변 합 -> 삼각형
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb =new StringBuilder();

            String line;
            while ((line=br.readLine())!=null) {
                if (line.equals("0 0 0")){
                    break;
                }
                StringTokenizer st = new StringTokenizer(line);
                int[] targetValue = new int[3];
                targetValue[0] = Integer.parseInt(st.nextToken());
                targetValue[1] = Integer.parseInt(st.nextToken());
                targetValue[2] = Integer.parseInt(st.nextToken());
                int maxValue = targetValue[0];
                int maxIdx = 0;
                if (targetValue[1]>maxValue){
                    maxValue = targetValue[1];
                    maxIdx = 1;
                }
                if (targetValue[2]>maxValue){
                    maxValue = targetValue[2];
                    maxIdx = 2;
                }
                int restValue = 0;
                for (int i=0; i<targetValue.length; i++){
                    if (i!=maxIdx){
                        restValue += targetValue[i];
                    }
                }
                if (maxValue>=restValue) {
                    sb.append("Invalid").append("\n");;
                } else if ((targetValue[0]==targetValue[1]) && (targetValue[1]==targetValue[2]) && (targetValue[0]==targetValue[2])){
                    sb.append("Equilateral").append("\n");
                } else if ((targetValue[0]==targetValue[1]) || (targetValue[1]==targetValue[2]) || (targetValue[0]==targetValue[2])){
                    sb.append("Isosceles").append("\n");
                } else {
                    sb.append("Scalene").append("\n");
                }
            }

            System.out.println(sb);
        } catch (IOException e){
            System.out.println("IOException");
        }
    }
}
