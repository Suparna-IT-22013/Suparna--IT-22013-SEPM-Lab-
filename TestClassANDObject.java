class Animal {
    String name;
    String type;

    void sound() {
        System.out.println(name + " is a " + type + " and makes a sound");
    }
}

public class TestClassANDObject {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "Lion";
        a.type = "Wild Animal";
        a.sound();
    }
}


