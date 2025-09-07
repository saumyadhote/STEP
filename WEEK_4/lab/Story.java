class Story {
String title; List<String> choices = new ArrayList<>();
Story(String t) { title = t; }
void addChoice(String c) { choices.add(c); }
void show() {
System.out.println("Story: " + title);
for (int i = 0; i < choices.size(); i++)
System.out.println((i+1) + ". " + choices.get(i));
}
}

class StoryDemo {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Story st = new Story("Lost on Mars");
st.addChoice("Build a shelter");
st.addChoice("Search for water");
st.show();
int choice = sc.nextInt();
System.out.println("You chose: " + st.choices.get(choice-1));
}
}
