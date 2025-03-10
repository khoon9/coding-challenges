package skillladder.level13_sorting;

/**
 *문제
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 *
 * 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 *
 * 예제 입력 1
 * 5
 * 0 4
 * 1 2
 * 1 -1
 * 2 2
 * 3 3
 * 예제 출력 1
 * 1 -1
 * 1 2
 * 2 2
 * 3 3
 * 0 4
 */

import java.util.*;
import java.io.*;

public class P11651 {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            List<int[]> targetList = new ArrayList<>();
            for (int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                targetList.add(new int[]{
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                });
            }
            targetList.sort(
                    Comparator.comparingInt((int[] point)->point[1])
                            .thenComparing(point->point[0])
            );
            targetList.stream().forEach((int[] point)->sb.append(point[0]+" "+point[1]+"\n"));

            br.close();
            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
