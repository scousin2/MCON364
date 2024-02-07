package Module1;

import java.util.ArrayList;
import java.util.List;


// sorts a list of elements using the Quick Sort algorithm.
public class QuickSort<T extends Comparable<T>> {
    public List<T> sort(List<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }

        T pivot = list.get(0); // first element of the list as the pivot
        List<T> less = new ArrayList<>();
        List<T> equal = new ArrayList<>();
        List<T> greater = new ArrayList<>();
     // split the list into three sublists based on the pivot
        for (T item : list) {
            int temp = item.compareTo(pivot);
            if (temp < 0) {
                // If the item is less than the pivot, add it to the 'less' list
                less.add(item);
            } else if (temp > 0) {
                // If the item is greater than the pivot, add it to the 'greater' list
                greater.add(item);
            } else {
                // If the item is equal to the pivot, add it to the 'equal' list
                equal.add(item);
            }
        }
     // Recursively sort the 'less' and 'greater' sublists
        List<T> sorted = new ArrayList<>();
        sorted.addAll(sort(less));
        sorted.addAll(equal);
        sorted.addAll(sort(greater));
        
        return sorted;  // Return the sorted list
    }
}
