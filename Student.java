package Module1;

public class Student implements Comparable<Student> {
	String name;
	int grade;
	public Student(String n, int g) {
		name=n;
		grade=g;
	}
	public void setname(String n) {
		name=n;
	}
	public void setgrade(int g) {
		grade=g;
	}
	public String getname() {
		return name;
	}
	public int getgrade() {
		return grade;
	}
	
	@Override
    public int compareTo(Student otherStudent) {
        // Compare students based on their grades
        return Integer.compare(this.grade, otherStudent.grade);
    }

}
