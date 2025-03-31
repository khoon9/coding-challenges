package skillladder.level23_dynamic_programming1;

/**
 *문제
 * 이 문제는 아주 평범한 배낭에 관한 문제이다.
 *
 * 한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
 *
 * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 *
 * 입력
 * 첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다. 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
 *
 * 입력으로 주어지는 모든 수는 정수이다.
 *
 * 출력
 * 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
 *
 * 예제 입력 1
 * 4 7
 * 6 13
 * 4 8
 * 3 6
 * 5 12
 * 예제 출력 1
 * 14
 */

import java.util.*;
import java.io.*;

public class P12865 {
    // 목표: V합 최대값
    // 유의:
    // 무게 K까지 가능
    // 물건별 무기(W) 가치(V) 존재
    // 가치/무게 무의미 -> 전역 순회 필요
    // but 같은 무게 기준 낮은 가치를 가지는 대상은 생략
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            int[][] board = new int[2][n];
            String line;
            int boardIdx = 0;
            while ((line=br.readLine())!=null){
                StringTokenizer st2 = new StringTokenizer(line);
                board[0][boardIdx] = Integer.parseInt(st2.nextToken());
                board[1][boardIdx] = Integer.parseInt(st2.nextToken());
                boardIdx++;
            }
            // 이전 동작사항 저장. 사용하는 값만 저장.
            // Key Value로 풀기 -> 현재 무게보다 낮은 가치일 경우 저장 X
            Map<Integer, Integer> targetMap = new HashMap<>();
            for (int i=0; i<n; i++){
                if (board[0][i]>k){
                    continue;
                }
                List<int[]> targetList = new ArrayList<>();
                for (Map.Entry<Integer, Integer> target: targetMap.entrySet()){
                    if (target.getKey()+board[0][i]<=k){
                        targetList.add(new int[]{target.getKey()+board[0][i], target.getValue()+board[1][i]});
                    }
                }
                for (int[] target: targetList){
                    if (targetMap.containsKey(target[0])){
                        if (targetMap.get(target[0])<target[1]){
                            targetMap.put(target[0],target[1]);
                        }
                    } else{
                        targetMap.put(target[0],target[1]);
                    }
                }
                if (targetMap.containsKey(board[0][i])){
                    if (targetMap.get(board[0][i])<board[1][i]){
                        targetMap.put(board[0][i],board[1][i]);
                    }
                } else{
                    targetMap.put(board[0][i],board[1][i]);
                }
            }
            int maxValue = targetMap.entrySet().stream().mapToInt(target->target.getValue()).max().orElse(0);
            sb.append(maxValue);

            System.out.println(sb);
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
