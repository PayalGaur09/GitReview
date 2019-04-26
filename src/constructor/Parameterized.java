package constructor;

public class Parameterized {
    public String name1;
    public int age1;
    public Parameterized(String name, int age) {
        name1 = name;
        age1 = age;
    }

    public void printOutput() {
        System.out.println(name1);
        System.out.println(age1);
        System.out.println(100-age1);
    }
}
