package skillladder.level10_geometry_rectangles_triangles;

/**
 *문제
 * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
 *
 * 입력
 * 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
 *
 * 출력
 * 직사각형의 네 번째 점의 좌표를 출력한다.
 *
 * 예제 입력 1
 * 5 5
 * 5 7
 * 7 5
 * 예제 출력 1
 * 7 7
 * 예제 입력 2
 * 30 20
 * 10 10
 * 10 20
 * 예제 출력 2
 * 30 10
 */

import java.util.*;

public class P3009 {
    // 서로 가장 먼 거리에 위치한 두 점을 이은 직선을 기준으로
    // 그 두 점에 해당하지 않는 점을 대칭이동한 점이 네 번째 점의 좌표라고 할 수 있다.
    // 하지만, 이 경우 방정식에 기반하여 풀 경우 그 식이 매우 복잡해진다.
    // 따라서, x축과 y축에 평행한 직사각형임을 활용하여 문제를 풀고자 한다.
    // 5 6  5 7  7 6  7 7
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        // 서로 가장 먼 두 점 찾기
        int targetx1 = x1;
        int targety1 = y1;
        int targetx2 = x2;
        int targety2 = y2;
        int targetx3 = x3;
        int targety3 = y3;
        int targetX = targetx3;
        int targetY = targety3;
        double maxDistance = getDistance(x1,y1,x2,y2);
        if (getDistance(x2,y2,x3,y3)>maxDistance){
            maxDistance = getDistance(x1,y1,x2,y2);
            targetx1 = x2;
            targety1 = y2;
            targetx2 = x3;
            targety2 = y3;
            targetx3 = x1;
            targety3 = y1;
        }
        if (getDistance(x1,y1,x3,y3)>maxDistance){
            maxDistance = getDistance(x1,y1,x2,y2);
            targetx1 = x1;
            targety1 = y1;
            targetx2 = x3;
            targety2 = y3;
            targetx3 = x2;
            targety3 = y2;
        }
        if (targetx1 != targetx3) {
            targetX = targetx1;
        }
        if (targety1 != targety3) {
            targetY = targety1;
        }
        if (targetx2 != targetx3) {
            targetX = targetx2;
        }
        if (targety2 != targety3) {
            targetY = targety2;
        }

        System.out.println(targetX+" "+targetY);
    }
    public static double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
