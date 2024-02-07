package Module1;

import java.util.ArrayList;
import java.util.List;
//sort using the Merge Sort algorithm.

public class MergeSort<T extends Comparable<T>> {
    public List<T> sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2; // divide the list in 2
        List<T> left = sort(list.subList(0, mid));// Sort the left half
        List<T> right = sort(list.subList(mid, list.size())); // Sort the right half

        return merge(left, right); // Merge the sorted halves
    }
    
    //merge two sorted lists into a single sorted list.

    private List<T> merge(List<T> left, List<T> right) {
        List<T> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;
        
        // Compare elements from both lists and merge them into the merged list
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                // If the element in the left list is smaller or equal, add it to the merged list
                merged.add(left.get(leftIndex++));
            } else {
                // If the element in the right list is smaller, add it to the merged list

                merged.add(right.get(rightIndex++));
            }
        }
        // Add any remaining elements from the left and right lists to the merged list
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        
        return merged;  // Return the merged list
    }
}

