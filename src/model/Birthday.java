package model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Birthday {
    private final int id;
    private final StringProperty name;
    private final ObjectProperty<LocalDate> dob;

    public Birthday(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.dob = new SimpleObjectProperty<>(dob);
    }

    public int getId() { return id; }
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public LocalDate getDob() { return dob.get(); }
    public void setDob(LocalDate dob) { this.dob.set(dob); }

    public StringProperty nameProperty() { return name; }
    public ObjectProperty<LocalDate> dobProperty() { return dob; }
}
