package algo2025.august;

import java.util.HashSet;
import java.util.Set;

public class IntersectionFinder {
    public int[] getIntersection(int[] nums1, int[] nums2) { // findIntersection() 메서드명도 괜찮은 듯
        Set<Integer> set1 = toSet(nums1);
        Set<Integer> set2 = toSet(nums2);
        Set<Integer> commonElements = findCommonElements(set1, set2);
        return convertSetToArray(commonElements);
    }

    // 배열을 전달받고, Set 자료 구조를 사용하여 배열의 중복된 요소를 제거하기에
    // 처음에 removeDuplicates 를 작명했는데, 반환 타입이 set 이고,
    // Set 을 이용한다는 것 자체가 요소의 중복이 없다는 것을 의미하니까
    // toSet() 으로 메서드명을 작명해도 될 것 같다.
    private Set<Integer> toSet(int[] nums) {
        Set<Integer> toUniqueSet = new HashSet<>();
        for(int num:nums) {
            toUniqueSet.add(num);
        }
        return toUniqueSet;
    }

    private Set<Integer> findCommonElements(Set<Integer> set1, Set<Integer> set2) {
        if(set1.size()>set2.size())
            return findCommonElements(set2, set1);

        Set<Integer> commonElementsSet = new HashSet<>();
        for(int num:set1)
            if(set2.contains(num)) commonElementsSet.add(num);
        return commonElementsSet;
    }

    private int[] convertSetToArray(Set<Integer> commonElements) {
        int[] intersections = new int[commonElements.size()];
        int i=0;
        for(int num:commonElements)
            intersections[i++]=num;
        return intersections;
    }
}
