package algo2025.august;

import java.util.HashSet;
import java.util.Set;

public class IntersectionFinder {
    public int[] getIntersection(int[] nums1, int[] nums2) {
        /* Set<Integer> set = new HashSet<>();

        for (int j : nums1) {
            for (int k : nums2) {
                if (j == k) {
                    set.add(j);
                }
            }
        }
        // Set 타입의 컬렉션을 배열로 반환하기.
        // return set.stream().mapToInt(n->n.intValue()).toArray();
        return set.stream().mapToInt(Integer::intValue).toArray();
    */
    // 두 배열중 하나를 Set 에 저장하고, 나머지 배열을 순회하며 존재 여부를 체크한다.
        Set<Integer> set1 = new HashSet<>(); // nums1 의 배열에 저장된 요소들 중복없이 담기 위한 Set 타입 자료구조
        Set<Integer> result = new HashSet<>(); // set 과 nums2 에 담긴 공통 요소를 담기위한 자료구조

        for(int i: nums1)
            set1.add(i);

        // set 에는 중복되지 않은 nums1 의 요소들이 들어있는 상태
        /* for(int i: set1) {
            for(int j:nums2) {
                if(i==j) result.add(i);
            }
        } */

        for(int num: nums2) {
            if(set1.contains(num))
                result.add(num);
        }

        int[] intersections = new int[result.size()];
        int i=0;
        for(int num:result) {
            intersections[i]=num; // intersections[i++]=num;
            i++;
        }
        return intersections;
    }
}
