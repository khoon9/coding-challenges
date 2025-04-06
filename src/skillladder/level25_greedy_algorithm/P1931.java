package skillladder.level25_greedy_algorithm;

/**
 *문제
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 *
 * 입력
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 *
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
 *
 * 예제 입력 1
 * 11
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 * 예제 출력 1
 * 4
 */

import java.util.*;
import java.io.*;

public class P1931 {
    // 목표: 회의실 한 개에 대해 일정을 구성할 떄, 완료 회의 개수 최댓값 구하기
    // 유의:
    // 회의 시작 후 중단 불가. 한 회의 끝나는 동시에 다음회의 시작 가능.
    // 회의의 시작시간과 완료 시간이 같을 수 있다.(이 경우 시작하자마자 끝나는 것으로 생각)
    // 실행 시간 및 메모리:
    // n^2이 10^10에 근접 -> O(n^2) 불가
    // 범위: 시간 -> 최대 2^31-1 -> int

    // 정렬 후에
    // 회의 시간 짧은 것만 오름차순으로 선택하면 최댓값이 나올까? X
    // 반례 -> 1 1, 1 4, 2 2, 2 2, 2 2
    // 도중에 건너 뛰는 작업을 선택하도록, 혹은 특정 조건에 따라 건너뛰도록 설정 필요
    // .. 1 1 수행 후 1 4에 대해 1~4 사이에서 회의 진행 가능한 대상이 하나라도 있을 경우 -> 1 4를 수행하는 것 이상의 회의 횟수 보장됨
    // -> 그중, 유효한 탐색 범위 중 끝나는 시간을 기준으로 가장 작은 값을 가지는 회의를 다음 회의로 선택
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for (int i=0; i<n; i++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                list.add(
                        new int[]{
                                Integer.parseInt(st1.nextToken()),
                                Integer.parseInt(st1.nextToken())
                        }
                );
            }
            Collections.sort(list, Comparator
                    .comparing((int[] target)->target[0])
                    .thenComparing(target->target[1])
            );
            int time = 0;
            int cnt = 0;
            int skipIdx = -1;
            for (int i=0; i<n; i++){
                if (list.get(i)[0]<time){
                    continue;
                }
                if (i<=skipIdx){
                    continue;
                }
                int minValue = Integer.MAX_VALUE;
                int minValueIdx = -1;
                for (int j=1; i+j<n; j++){
                    if (list.get(i+j)[0]>=list.get(i)[1]){
                        break;
                    }
                    if (list.get(i+j)[1]<list.get(i)[1] ){
                        if (list.get(i+j)[1]<minValue){
                            minValue = list.get(i+j)[1];
                            minValueIdx = i+j;
                        }
                    }
                }
                if (minValueIdx!=-1){
                    time = list.get(minValueIdx)[1];
                    cnt++;
                    skipIdx = minValueIdx;
                } else {
                    time = list.get(i)[1];
                    cnt++;
                }
            }
            sb.append(cnt);

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
