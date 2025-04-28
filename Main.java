interface Growable {
    void grow();
}

interface Shadable {
    void provideShade();
}

class Tree implements Growable, Shadable {
    public void grow() {
        System.out.println("Tree is growing...");
    }

    public void provideShade() {
        System.out.println("Tree is providing shade...");
    }
}

public class Main {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.grow();
        t.provideShade();
    }
}

