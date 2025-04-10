package skillladder.level26_divide_and_conquer;

/**
 *문제
 * 히스토그램은 직사각형 여러 개가 아래쪽으로 정렬되어 있는 도형이다. 각 직사각형은 같은 너비를 가지고 있지만, 높이는 서로 다를 수도 있다. 예를 들어, 왼쪽 그림은 높이가 2, 1, 4, 5, 1, 3, 3이고 너비가 1인 직사각형으로 이루어진 히스토그램이다.
 *
 *
 *
 * 히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 입력은 테스트 케이스 여러 개로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, 직사각형의 수 n이 가장 처음으로 주어진다. (1 ≤ n ≤ 100,000) 그 다음 n개의 정수 h1, ..., hn (0 ≤ hi ≤ 1,000,000,000)가 주어진다. 이 숫자들은 히스토그램에 있는 직사각형의 높이이며, 왼쪽부터 오른쪽까지 순서대로 주어진다. 모든 직사각형의 너비는 1이고, 입력의 마지막 줄에는 0이 하나 주어진다.
 *
 * 출력
 * 각 테스트 케이스에 대해서, 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 출력한다.
 *
 * 예제 입력 1
 * 7 2 1 4 5 1 3 3
 * 4 1000 1000 1000 1000
 * 0
 * 예제 출력 1
 * 8
 * 4000
 */

import java.util.*;
import java.io.*;

public class P6549 {
    // 목표: 히스트그램에서 직사각형 넓이 최대값 구하기
    // 유의:
    // 최댓값 구하기
    // 개수 최대 10^5, 높이 최대 10^9 이므로
    // 너비는 1 고정
    // 마지막 입력 0
    // 시간복잡도:
    // n이 최대 10^5 이므로, O(n^2) 불가. O(n) 또는 O(nlogn) 가능
    // -> 넓이 결정되는 요소 -> 너비, 높이
    // 가운데를 지나는 경우, 지나지 않는 경우
    // left, mid, right -> 분할하여 탐색하고자 하는 배열 영역 좁히기
    // 주어진 배열 영역에서의 넓이 최댓값 구하기 반복
    // 범위를 지정하는 수단(idx)을 통해 배열의 재사용 가능
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            List<long[]> targetList = new ArrayList<>();
            String line;
            while ((line=br.readLine())!=null && !line.equals("0")){
                StringTokenizer st1 = new StringTokenizer(line);
                int n = Integer.parseInt(st1.nextToken());
                long[] arr = new long[n];
                for (int i=0; i<n; i++){
                    arr[i] = Long.parseLong(st1.nextToken());
                }
                targetList.add(arr);
            }
            for (int i=0; i<targetList.size(); i++){
                long[] arr = targetList.get(i);

                long maxValue = function1(arr, 0, arr.length-1);

                sb.append(maxValue+"\n");
            }

            System.out.println(sb);
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // left ~ right: arr에서의 탐색 범위
    // 주어진 범위 내에서 최댓값을 반환
    public static long function1(long[] arr, int left, int right){
        if (left<0 || right>arr.length){
            return 0;
        }
        if (right-left == 0){
            return arr[left];
        }
        if (right-left == 1){
            long maxValue = (arr[right]>arr[left]? arr[right]: arr[left]);
            long minValue = (arr[right]<arr[left]? arr[right]: arr[left]);
            return (maxValue>minValue*2? maxValue: minValue*2);
        }
        int half = (right-left)/2;
        int mid = left + half;
        long targetLeft = function1(arr, left, mid);
        long targetRight = function1(arr, mid+1, right);
        // 인접한 높이 중 더 큰 높이에 먼저 진행. 현재까지의 최솟값을 높이로 설정.
        long targetContainsMid;
        long nowHeight = arr[mid];
        int width = 1;
        int l = mid-1;
        int r = mid+1;
        targetContainsMid = nowHeight*width;
        while (l>=left || r<=right){
            if (l<left){
                nowHeight = (arr[r]<nowHeight? arr[r]: nowHeight);
                width++;
                targetContainsMid = (nowHeight*width>targetContainsMid)? nowHeight*width: targetContainsMid;
                r++;
                continue;
            }
            if (r>right){
                nowHeight = (arr[l]<nowHeight? arr[l]: nowHeight);
                width++;
                targetContainsMid = (nowHeight*width>targetContainsMid)? nowHeight*width: targetContainsMid;
                l--;
                continue;
            }
            if (arr[l]>arr[r]) {
                nowHeight = (arr[l]<nowHeight? arr[l]: nowHeight);
                width++;
                targetContainsMid = (nowHeight*width>targetContainsMid)? nowHeight*width: targetContainsMid;
                l--;
            } else{
                nowHeight = (arr[r]<nowHeight? arr[r]: nowHeight);
                width++;
                targetContainsMid = (nowHeight*width>targetContainsMid)? nowHeight*width: targetContainsMid;
                r++;
            }
        }
        long maxValue = (targetLeft>targetRight? targetLeft: targetRight);
        maxValue = (targetContainsMid>maxValue? targetContainsMid: maxValue);
        return maxValue;
    }
}
