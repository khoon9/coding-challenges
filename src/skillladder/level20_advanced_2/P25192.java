package skillladder.level20_advanced_2;

/**
 *문제
 * 인사하는 곰곰이
 *
 * 알고리즘 입문방 오픈 채팅방에서는 새로운 분들이 입장을 할 때마다 곰곰티콘을 사용해 인사를 한다. 이를 본 문자열 킬러 임스는 채팅방의 기록을 수집해 그 중 곰곰티콘이 사용된 횟수를 구해 보기로 했다.
 *
 * ENTER는 새로운 사람이 채팅방에 입장했음을 나타낸다. 그 외는 채팅을 입력한 유저의 닉네임을 나타낸다. 닉네임은 숫자 또는 영문 대소문자로 구성되어 있다.
 *
 * 새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사를 한다. 그 외의 기록은 곰곰티콘을 쓰지 않은 평범한 채팅 기록이다.
 *
 * 채팅 기록 중 곰곰티콘이 사용된 횟수를 구해보자!
 *
 * 입력
 * 첫 번째 줄에는 채팅방의 기록 수를 나타내는 정수
 * $N$ 이 주어진다. (
 * $1 \le N \le 100\,000$)
 *
 * 두 번째 줄부터
 * $N$ 개의 줄에 걸쳐 새로운 사람의 입장을 나타내는 ENTER, 혹은 채팅을 입력한 유저의 닉네임이 문자열로 주어진다. (문자열길이
 * $1 \le \texttt{문자열 길이} \le 20$)
 *
 * 첫 번째 주어지는 문자열은 무조건 ENTER이다.
 *
 * 출력
 * 채팅 기록 중 곰곰티콘이 사용된 횟수를 출력하시오.
 *
 * 예제 입력 1
 * 9
 * ENTER
 * pjshwa
 * chansol
 * chogahui05
 * lms0806
 * pichulia
 * r4pidstart
 * swoon
 * tony9402
 * 예제 출력 1
 * 8
 * 예제 입력 2
 * 7
 * ENTER
 * pjshwa
 * chansol
 * chogahui05
 * ENTER
 * pjshwa
 * chansol
 * 예제 출력 2
 * 5
 * 첫번째 새로운 사람이 들어온 뒤  pjshwa, chansol, chogahui05은 모두 곰곰티콘으로 인사했다.
 *
 * 두번째 새로운 사람이 들어온 뒤  pjshwa와 chansol은 다시 곰곰티콘으로 인사했다.
 *
 * 예제 입력 3
 * 3
 * ENTER
 * lms0806
 * lms0806
 * 예제 출력 3
 * 1
 */

import java.util.*;
import java.io.*;

public class P25192 {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            List<String> targetList = new ArrayList<>();
            for (int i=0; i<N; i++){
                targetList.add(br.readLine());
            }
            Set<String> targetNowSet = new HashSet<>();
            int targetCnt = 0;
            for (String targetValue: targetList){
                if (targetValue.equals("ENTER")){
                    targetNowSet.clear();
                    continue;
                }
                if (!targetNowSet.contains(targetValue)){
                    targetCnt++;
                    targetNowSet.add(targetValue);
                }
            }
            sb.append(targetCnt);

            System.out.println(sb);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
