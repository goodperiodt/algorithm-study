package algo2025.august;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;

public class ParallelLineCounter {
    public static void main(String[] args) {
        HashMap<Integer, Integer> xCountMap;
        HashMap<Integer, Integer> yCountMap;

        int count=0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int pointNum = Integer.parseInt(br.readLine()); // pointNum: 좌표 갯수
            if(pointNum>0) {
                xCountMap = new HashMap<>();
                yCountMap = new HashMap<>();
            }
            // 좌표 갯수가 0 또는 음수 일경우 예외발생 시킴.
            else throw new IllegalArgumentException();

            // x 좌표별로 점의 개수를 HashMap 으로 센다
            // y 좌표별로 점의 개수를 HashMap 으로 센다
            for(int i=0; i<pointNum; i++) {
                String[] line = br.readLine().split(" ");
                // key 값이 존재하면 해당 key 값과 매핑된 value 의 값을 꺼내 + 1 한 후 해당 key 값에 put 한다.
                // key 값이 존재하지 않으면 defaultValue(0) 의 값에 + 1 한 후 해당 key 값에 put 한다.
                xCountMap.put(Integer.valueOf(line[0]), xCountMap.getOrDefault(Integer.valueOf(line[0]), 0)+1);
                yCountMap.put(Integer.valueOf(line[1]), yCountMap.getOrDefault(Integer.valueOf(line[1]), 0)+1);
            }
            // 개수가 2 이상인 경우만 직선 1개로 카운트
            Collection<Integer> xValues = xCountMap.values();
            Collection<Integer> yValues = yCountMap.values();

            for(int i: xValues)
                if(i>1) count++;

            for(int i: yValues)
                if(i>1) count++;

            System.out.println("평행선 갯수: "+count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
