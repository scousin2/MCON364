package Module5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ShulMain1 {
    private List<ShulMember> members = new ArrayList<>();

    public ShulMain1() {
        initializeMembers();
    }

    // Method to initialize members
    private void initializeMembers() {

        String[] goldKids = {"Aliza", "Atara", "Penina", "Nechama"};
        ShulMember member1 = new ShulMember("Gold", "Chanoch", new Date(1965-20-05), "Aliza", "Gold", goldKids, 5);

        String[] cousinKids = {"Mushka", "Sara", "Shmuel"};
        ShulMember member2 = new ShulMember("Cousin", "Zalman", new Date(1976-10-07), "Raizy", "Cousin", cousinKids, 2);

        String[] bierKids = {"Rachel", "Esther"};
        ShulMember member3 = new ShulMember("Bier", "Rabbi", new Date(1972-12-10), "Rebetzin", "Bier", bierKids, 8);

        members.addAll(Arrays.asList(member1, member2, member3));
    }

    // 1) Print how many families belong to your shul
    public void printNumberOfFamilies() {
        long numberOfFamilies = members.stream()
                .map(ShulMember::getLastNameOfMember)
                .distinct()
                .count();
        System.out.println("Number of families: " + numberOfFamilies);
    }

    // 2) Print in sorted order how long each family has been a member of your shul
    public void printYearsOfMembership() {
        members.stream()
                .sorted(Comparator.comparingInt(ShulMember::getYearsOfMembership))
                .forEach(member -> System.out.println(member.getLastNameOfMember() + ": " + member.getYearsOfMembership() + " years"));
    }

    // 3) Print out from oldest to youngest the ages of your members (not spouses)
    public void printAgesOfMembers() {
        members.stream()
                .sorted(Comparator.comparing(ShulMember::getBirthDateOfMember))
                .forEach(member -> System.out.println(member.getFirstNameOfMember() + " " + member.getLastNameOfMember() + ": " + member.getBirthDateOfMember()));
    }

    // 4) Sort the names of the spouses of all members
    public void printSortedSpouseNames() {
        members.stream()
                .map(ShulMember::getSpouseFirstName)
                .sorted()
                .forEach(System.out::println);
    }

    // 5) Print out all families who have more than 3 children
    public void printFamiliesWithMoreThan3Children() {
        members.stream()
                .filter(member -> member.getChildrenNames().length > 3)
                .map(member -> member.getLastNameOfMember() + " family")
                .distinct()
                .forEach(System.out::println);
    }

    // 6) Print out the names of all children whose name is larger than "c" alphabetically
    public void printChildrenNamesLargerThanC() {
    	 members.stream()
         .flatMap(member -> Arrays.stream(member.getChildrenNames())
                 .filter(childName -> childName.compareToIgnoreCase("c") > 0)
                 .map(childName -> member.getLastNameOfMember() + ": " + childName))
         .forEach(System.out::println);
    }
}
