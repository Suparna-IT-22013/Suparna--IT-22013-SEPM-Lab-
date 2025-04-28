interface Patient {
    void checkIn();
}

class Doctor implements Patient {
    public void checkIn() {
        System.out.println("The patient is checking in to the hospital.");
    }
}

public class Interface {
    public static void main(String[] args) {
        Doctor d = new Doctor();
        d.checkIn();
    }
}

