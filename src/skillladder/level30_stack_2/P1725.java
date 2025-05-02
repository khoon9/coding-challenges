package skillladder.level30_stack_2;


/**
 * 문제
 * 히스토그램에 대해서 알고 있는가? 히스토그램은 아래와 같은 막대그래프를 말한다.
 *
 *
 *
 * 각 칸의 간격은 일정하고, 높이는 어떤 정수로 주어진다. 위 그림의 경우 높이가 각각 2 1 4 5 1 3 3이다.
 *
 * 이러한 히스토그램의 내부에 가장 넓이가 큰 직사각형을 그리려고 한다. 아래 그림의 빗금 친 부분이 그 예이다. 이 직사각형의 밑변은 항상 히스토그램의 아랫변에 평행하게 그려져야 한다.
 *
 *
 *
 * 주어진 히스토그램에 대해, 가장 큰 직사각형의 넓이를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 행에는 N (1 ≤ N ≤ 100,000) 이 주어진다. N은 히스토그램의 가로 칸의 수이다. 다음 N 행에 걸쳐 각 칸의 높이가 왼쪽에서부터 차례대로 주어진다. 각 칸의 높이는 1,000,000,000보다 작거나 같은 자연수 또는 0이다.
 *
 * 출력
 * 첫째 줄에 가장 큰 직사각형의 넓이를 출력한다. 이 값은 20억을 넘지 않는다.
 *
 * 예제 입력 1
 * 7
 * 2
 * 1
 * 4
 * 5
 * 1
 * 3
 * 3
 * 예제 출력 1
 * 8
 */

import java.util.*;
import java.io.*;

public class P1725 {
    // 목적: 히스토그램에서 가장 큰 직사각형 넓이 구하기
    // 유의:
    // N, H -> 10^5, 10^9
    // N*H -> 10^14 -> long -> but 최대 크기 20억
    // O(N^2) -> 10^10 -> 불가
    // 예시 기반 분석
    // 5 3 4 6 8 2 4 6
    // 16 14 12 6 8 2 4 6
    // 각 스택마다 <높이, 최초 발견 idx> 기록
    // 현재 높이 기준, 보다 높은 높이들 싹다 pop 하고 pop 했을 때 최초 발견 위치 교체
    // 동일한 높이 나와도 pop 하고 최초 발견 위치 교체
    // 이후 미만 높이 나오면 그때 <높이, 최초 발견 idx>을 스택에 추가
    // 스택에 남은 걸로 현재 idx 기준 최대 넓이 탐색 후 다음 idx로 이동
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            List<int[]> list = new ArrayList<>();
            int maxValue = 0;
            for (int i=N-1; i>=0; i--) {
                int targetValue = arr[i];
                int targetIdx = i;
                while (list.size()!=0){
                    if (targetValue<=list.get(list.size()-1)[0]){
                        targetIdx = list.get(list.size()-1)[1];
                        list.remove(list.size()-1);
                    } else {
                        break;
                    }
                }
                list.add(new int[]{
                        targetValue,
                        targetIdx
                });
                // 스택은 현재 내림차순으로 구성
                for (int j=list.size()-1; j>=0; j--) {
                    int target = list.get(j)[0]*(list.get(j)[1]-i+1);
                    maxValue = (target>maxValue? target: maxValue);
                }
            }
            sb.append(maxValue);

            System.out.println(sb);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
