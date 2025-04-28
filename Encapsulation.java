class Student {
    private int marks;

    public void setMarks(int m) {
        if(m >= 0) marks = m;
    }

    public int getMarks() {
        return marks;
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Student s = new Student();
        s.setMarks(85);
        System.out.println(s.getMarks());
    }
}

