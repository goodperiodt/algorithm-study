package algo2025.august;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ParallelLineCounter {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> xCount=new HashMap<>();
            Map<Integer, Integer> yCount=new HashMap<>();

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 token 값들이 StringTokenizer 인스턴스에 담김.
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                xCount.put(x, xCount.getOrDefault(x, 0)+1);
                yCount.put(y, yCount.getOrDefault(y, 0)+1);
            }

            int result = 0;
            for(int count: xCount.values())
                if(count>1) result++;

            for(int count: yCount.values())
                if(count>1) result++;

            System.out.println(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
