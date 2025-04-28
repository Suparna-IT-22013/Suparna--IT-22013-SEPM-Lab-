abstract class Poet {
    abstract void writePoem();
    void rest() { System.out.println("Taking a break..."); }
}

class ShakespearePoet extends Poet {
    void writePoem() { System.out.println("To be, or not to be..."); }
}

class ModernPoet extends Poet {
    void writePoem() { System.out.println("The world spins..."); }
}

public class Abstract {
    public static void main(String[] args) {
        Poet shakespeare = new ShakespearePoet();
        Poet modernPoet = new ModernPoet();
        shakespeare.writePoem(); modernPoet.writePoem();
        shakespeare.rest(); modernPoet.rest();
    }
}


