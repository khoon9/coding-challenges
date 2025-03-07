package skillladder.level10_geometry_rectangles_triangles;

/**
 *문제
 * 영선이는 길이가 a, b, c인 세 막대를 가지고 있고, 각 막대의 길이를 마음대로 줄일 수 있다.
 *
 * 영선이는 세 막대를 이용해서 아래 조건을 만족하는 삼각형을 만들려고 한다.
 *
 * 각 막대의 길이는 양의 정수이다
 * 세 막대를 이용해서 넓이가 양수인 삼각형을 만들 수 있어야 한다.
 * 삼각형의 둘레를 최대로 해야 한다.
 * a, b, c가 주어졌을 때, 만들 수 있는 가장 큰 둘레를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 a, b, c (1 ≤ a, b, c ≤ 100)가 주어진다.
 *
 * 출력
 * 첫째 줄에 만들 수 있는 가장 큰 삼각형의 둘레를 출력한다.
 *
 * 예제 입력 1
 * 1 2 3
 * 예제 출력 1
 * 5
 * 예제 입력 2
 * 2 2 2
 * 예제 출력 2
 * 6
 * 예제 입력 3
 * 1 100 1
 * 예제 출력 3
 * 3
 * 예제 입력 4
 * 41 64 16
 * 예제 출력 4
 * 113
 */

import java.util.*;

public class P14215 {
    // 각 변 1~100 양의 정수
    // 입력된 a,b,c -> 넓이 > 0 삼각형 만들 수 있다
    // 삼각형의 둘레를 최대로 만들어야 한다
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        List<Integer> targetValues = new ArrayList<>();
        targetValues.add(scanner.nextInt());
        targetValues.add(scanner.nextInt());
        targetValues.add(scanner.nextInt());
        Collections.sort(targetValues);
        if ((targetValues.get(0)+targetValues.get(1))<=targetValues.get(2)){
            sb.append(targetValues.get(0)+targetValues.get(1)+(targetValues.get(0)+targetValues.get(1)-1));
        } else {
            sb.append(targetValues.get(0)+targetValues.get(1)+targetValues.get(2));
        }

        System.out.println(sb);
    }
}
