
class Book {
    private String title;

    public void setTitle(String newTitle) {
        title = newTitle;
    }

    public String getTitle() {
        return title;
    }
}

public class Modifiers {
    public static void main(String[] args) {
        Book b = new Book();
        b.setTitle("Java");
        System.out.println(b.getTitle());
    }
}
