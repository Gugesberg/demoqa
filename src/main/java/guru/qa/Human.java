package guru.qa;

public class Human {
    private final String name;
    private final int age;
    private final boolean isCute;



    public Human(String name, int age, boolean isCute) {
        this.name = name;
        this.age = age;
        this.isCute = isCute;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCute() {
        return isCute;
    }

}
