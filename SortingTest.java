package Module1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

class SortingTest {
	
	 @Test
	    public void testQuickSortWithRandomList() {
	        List<Student> students = new ArrayList<>();
	        Random random = new Random();
	        for (int i = 0; i < 100; i++) {
	            students.add(new Student("Student" + i, random.nextInt(101)));
	        }

	        QuickSort<Student> quickSort = new QuickSort<>();
	        List<Student> sortedStudents = quickSort.sort(new ArrayList<>(students));

	        for (int i = 1; i < sortedStudents.size(); i++) {
	            assertTrue(sortedStudents.get(i - 1).getgrade() <= sortedStudents.get(i).getgrade());
	        }
	    }

	    @Test
	    public void testMergeSortWithRandomList() {
	        List<Student> students = new ArrayList<>();
	        Random random = new Random();
	        for (int i = 0; i < 100; i++) {
	            students.add(new Student("Student" + i, random.nextInt(101)));
	        }

	        MergeSort<Student> mergeSort = new MergeSort<>();
	        List<Student> sortedStudents = mergeSort.sort(new ArrayList<>(students));

	        for (int i = 1; i < sortedStudents.size(); i++) {
	            assertTrue(sortedStudents.get(i - 1).getgrade() <= sortedStudents.get(i).getgrade());
	        }
	    }

	    @Test
	    public void testQuickSortWithEmptyList() {
	        List<Student> students = new ArrayList<>();
	        
	        QuickSort<Student> quickSort = new QuickSort<>();
	        List<Student> sortedStudents = quickSort.sort(new ArrayList<>(students));

	        assertEquals(0, sortedStudents.size());
	    }

	    @Test
	    public void testMergeSortWithEmptyList() {
	        List<Student> students = new ArrayList<>();
	        
	        MergeSort<Student> mergeSort = new MergeSort<>();
	        List<Student> sortedStudents = mergeSort.sort(new ArrayList<>(students));

	        assertEquals(0, sortedStudents.size());
	    }
}
	
	


