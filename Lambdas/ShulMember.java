package Module5;

import java.util.Date;

public class ShulMember implements Comparable{
	String lastNameOfMember;
	String firstNameOfMember;
	Date birthDateOfMember;
	String spouseFirstName;
	String spouseLastName;
	String[] childrenNames;
	int yearsOfMembership;
	
	
	public ShulMember(String lastNameOfMember,String firstNameOfMember,Date birthDateOfMember, 
		String spouseFirstName, String spouseLastName,String[] childrenNames,int yearsOfMembership) {
		this.lastNameOfMember=lastNameOfMember;
		this.firstNameOfMember=firstNameOfMember;
		this.birthDateOfMember=birthDateOfMember;
		this.spouseFirstName=spouseFirstName;
		this.spouseLastName=spouseLastName;
		this.childrenNames=childrenNames;
		this.yearsOfMembership=yearsOfMembership;
	}
	
	public String getLastNameOfMember() {
		return lastNameOfMember;
	}

	public void setLastNameOfMember(String lastNameOfMember) {
		this.lastNameOfMember = lastNameOfMember;
	}

	public String getFirstNameOfMember() {
		return firstNameOfMember;
	}

	public void setFirstNameOfMember(String firstNameOfMember) {
		this.firstNameOfMember = firstNameOfMember;
	}

	public Date getBirthDateOfMember() {
		return birthDateOfMember;
	}

	public void setBirthDateOfMember(Date birthDateOfMember) {
		this.birthDateOfMember = birthDateOfMember;
	}

	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	public void setSpouseFirstName(String spouseFirstName) {
		this.spouseFirstName = spouseFirstName;
	}

	public String getSpouseLastName() {
		return spouseLastName;
	}

	public void setSpouseLastName(String spouseLastName) {
		this.spouseLastName = spouseLastName;
	}

	public String[] getChildrenNames() {
		return childrenNames;
	}

	public void setChildrenNames(String[] childrenNames) {
		this.childrenNames = childrenNames;
	}

	public int getYearsOfMembership() {
		return yearsOfMembership;
	}

	public void setYearsOfMembership(int yearsOfMembership) {
		this.yearsOfMembership = yearsOfMembership;
	}

	// @Override
	    public int compareTo(ShulMember other) {
	        // Compare birth years
	        return this.birthDateOfMember.compareTo(other.birthDateOfMember);
	    }

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
	    public String toString() {
	        return "Member{" +
	                "first name='" + firstNameOfMember + '\'' +
	                ", last nanme=" + lastNameOfMember +
	                '}';
	    }
	

}
