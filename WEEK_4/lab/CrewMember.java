import java.util.*;

class CrewMember {
String name, role;
CrewMember(String n, String r) { name = n; role = r; }
public String toString() { return name + " - " + role; }
}

class SpaceStation {
List<CrewMember> crew = new ArrayList<>();
void addCrew(String n, String r) { crew.add(new CrewMember(n, r)); }
void listCrew() { crew.forEach(System.out::println); }
}

class SpaceStationDemo {
public static void main(String[] args) {
SpaceStation s = new SpaceStation();
s.addCrew("Alice", "Commander");
s.addCrew("Bob", "Engineer");
System.out.println("Crew Members:");
s.listCrew();
}
}