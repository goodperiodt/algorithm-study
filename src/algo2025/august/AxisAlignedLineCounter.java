package algo2025.august;

import lombok.Getter;

import java.io.*;
import java.util.*;

/* x, y 좌표를 가진 n개의 점들을 입력받고,
 x 값 또는 y 값을 기준으로 동일한 값을 가진 점들을(2개 이상) 이은
 평행선의 갯수를 구하기
 --> n개의 점(x,y)들을 입력받아 x/y 축에 평행한 직선을 구한다.
 calculator, counter, 평행선에 해당하는 선들을 감지한다는 의미의 detector?
 AxisAlignedLineCounter: x축 또는 y축에 평행한 선을 카운트함(gpt 가 추천해줌)
 내가 처음에 작성한 클래스명: LineCounter, 그리고 후보 클래스명 하나더: ParallelLineCounter */
@Getter
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

public class AxisAlignedLineCounter {
    public static void main(String[] args) {
        // Point[] points;
        List<Point> points;
        Map<Integer, Integer> xCountMap;
        Map<Integer, Integer> yCountMap;

        int count = 0;
        // try-with-resources
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 점 갯수: dots
            int pointNum = Integer.parseInt(br.readLine());
            // try-with-resources 내부에 선언이 안되는 이유
            if(pointNum>0) {
                points= new ArrayList<>();
                xCountMap=new HashMap<>();
                yCountMap=new HashMap<>();
            }
            else throw new IllegalArgumentException();

            for(int i=0; i<pointNum; i++) {
                String[] parts = br.readLine().split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                points.add(new Point(x, y));
            }

            for(Point p: points) {
                // Map.getOrDefault(Object key, V defaultValue);
                // key 가 map 에 존재하고, 그 값이 null 이 아니면 그 값을 반환
                // key 가 존재하지 않으면 defaultValue 를 반환, --> defaultValue 는 default
                // key 가 존재하지만 값이 null 이면 null 을 반환

                // key 가 처음 등장할 때, get()은 null 을 반환한다.
                // key 가 처음 등장했을 때를 대비해 getOrDefault() 메서드를 사용,
                // defaultValue 를 지정한다.
                xCountMap.put(p.getX(), xCountMap.getOrDefault(p.getX(), 0)+1);
                yCountMap.put(p.getY(), yCountMap.getOrDefault(p.getY(), 0)+1);
            }
            // Map 타입에서 key 만 가져오는 메서드 map.keySet()
            // keySet() 으로 가져온 Set 은 원본 맵과 연결되어 있어, keySet 에서 값을 제거하면 원본 Map 에서도 제거된다.
            Set<Integer> xCountMapGetKeys = xCountMap.keySet();
            Set<Integer> yCountMapGetKeys = yCountMap.keySet();

            for(int xKey: xCountMapGetKeys) {
                if(xCountMap.get(xKey)>1) count++;
            }

            for(int yKey: yCountMapGetKeys) {
                if(yCountMap.get(yKey)>1) count++;
            }

            System.out.println("평행선 갯수: "+count);


            // xCountMap, yCountMap 에서 key 에 해당하는 value 가 2 이상인 경우 count++ 한다.



            // points 배열에 담긴 Point 인스턴스의 int x 값만 모아서 중복되는 수를 제거한 수를 모으면 y축에 평행한 세로 직선 n개
            // 배열을 Set 타입으로 변환하기?
            // Call to 'asList()' to create an empty List

            // 평행한 직선 개수 구하기, x 좌표가 같은 점이 2개 이상 --> y축에 평행한 세로 직선 n개
            // y 좌표가 같은 점이 2개 이상 --> x 축에 평행한 가로직선 n개

            // Set+Map 의 사용 또는 2번 이상 등장한 좌표 값만 카운트하기
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
