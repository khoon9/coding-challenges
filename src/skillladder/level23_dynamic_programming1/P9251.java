package skillladder.level23_dynamic_programming1;

/**
 *문제
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
 *
 * 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
 *
 * 입력
 * 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
 *
 * 출력
 * 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
 *
 * 예제 입력 1
 * ACAYKP
 * CAPCAK
 * 예제 출력 1
 * 4
 */

import java.util.*;

public class P9251 {
    // 목적: 두 문자열 사이의 (최장 공통 부분 수열) 겹치는 문자 최대 길이 구하기
    // 유의:
    // 문자 A와 문자 B의 각 문자는 상대적인 순서를 기준으로 겹쳤는지 여부를 본다
    //
    // 해당 idx를 포함하여, 이후 가장 최대 길이로 가질 수 있는 값 -> 추가 여부에 대해 분기점을 만들어 재귀 수행
    // -> 시간 초과. 복잡도 2^n
    // 재귀를 반복문으로 변환 -> 조건에 포함되는 경우 발생시, 소급 적용되는 범위에서 각 이전까지 최대 길이 값 조회 후 +1 값과 비교 반복
    // -> 시간 초과. 복잡도 n^4
    // 현재 idx를 포함하여, 이전 ~ 현재까지 가장 최대 길이로 가질 수 있는 값으로 cache 저장 내용 변경
    // -> 조건에 해당되지 않을 경우에도 최적해를 저장하도록 cache 사용 방법 개선
    // cache[idxA][idxB]: 0(value=0, 공백 문자) ~ idxA,  0(value=0, 공백 문자) ~ idxA 영역 내에서의 최적해 저장
    // - 최적 부분 구조: 새로운 문자가 도입되었을 때, 이전 연산 결과를 고려하여 최적해 반복 도출
    // - 중복되는 하위 문제: 이미 최적해를 구한 영역에 대해 중복되는 연산이 생략됨
    // -> 복잡도 n^2
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        char[] targetA = scanner.nextLine().toCharArray();
        char[] targetB = scanner.nextLine().toCharArray();
        boolean[][] targetBoard = new boolean[targetA.length][targetB.length];
        for (int i=0; i<targetA.length; i++) {
            for (int j=0; j<targetB.length; j++) {
                targetBoard[i][j] = (targetA[i]==targetB[j]);
            }
        }
        // A의 문자에서 B의 문자로 매칭
        // idxA, idxB 를 결정하기 위해 이전에 이미 최적해를 구한 범위만을 대상으로 비교를 수행함
        int[][] cache = new int[targetA.length+1][targetB.length+1];
        for (int i=1; i<=targetA.length; i++){
            // cache의 각 idx는, 현재까지의 idx에서 A영역과 B영역을 사용하여 만들 수 있는 최적해를 저장하는 것
            // -> i=targetA.length, j=targetB.length 에 도달했을 때 해당 cache 배열은 전체 문제에 대한 최적해를 가져야함
            // (기존의 cache는 재귀 과정에서 듬성듬성 사용했다면 이번에는 반복문에 의한 명시를 통하여 빼곡히 사용하는 것이 목표)
            for (int j=1; j<=targetB.length; j++){
                if (targetBoard[i-1][j-1]){
                    // 알고리즘
                    // A[idxA], B[idxB] 비교
                    // 같다 -> 현재 idx와 독립적이면서 최댓값인 cache에 상승값(+1, LCS에 추가하여 발생하는 상승값)을 더한 값을 최적해로 저장한다.
                    // 다르다 -> 현재 idx에서 LCS에 추가하지 않는다는 가정 하에, 가장 근접하지만 독립적인 cache내에서 최적해를 찾는다.
                    // cache[i-1][j-1]: 현재 비교 대상과 별개의 공간. 즉, 추가를 하든 안 하든 독립적인 공간.
                    // cache[i][j-1]: 현재 추가를 안 하는 것을 전제 조건으로 삼고, 이전에 이미 idxA(=i)에서 B영역(=~(j-1))에 대해 추가한 상황 또한 염두에 둔 공간.
                    // cache[i-1][j]: 현재 추가를 안 하는 것을 전제 조건으로 삼고, 이전에 이미 A영역(=~(i-1))에서 idxB(=j)에 대해 추가한 상황 또한 염두에 둔 공간.
                    // 저장하려는 dp 부분에 대해서 진행하는 방향에 대해 비교 연산을 수행하지 않는다.
                    // 이전에 이미 지나갔던 부분은, 주어진 조건 내에서 최적해를 만족한 상태라고 가정.
                    cache[i][j] = 1+cache[i-1][j-1];
                } else {
                    // 조건에 해당되지 않는 곳 또한 최적해를 구하기 위한 가교로 사용.
                    cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
                }
            }
        }
        int maxValue = cache[targetA.length][targetB.length];
        sb.append(maxValue);

        System.out.println(sb);
    }
}
