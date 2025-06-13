package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Birthday;

import java.sql.*;
import java.time.LocalDate;

public class BirthdayController {

    @FXML private TextField nameField;
    @FXML private DatePicker dobPicker;
    @FXML private TableView<Birthday> birthdayTable;
    @FXML private TableColumn<Birthday, String> nameCol;
    @FXML private TableColumn<Birthday, LocalDate> dobCol;
    @FXML private TextField searchField;

    private ObservableList<Birthday> birthdayList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
        dobCol.setCellValueFactory(data -> data.getValue().dobProperty());
        loadBirthdays();
        checkTodayBirthdays();
    }

    private void loadBirthdays() {
        birthdayList.clear();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM birthdays ORDER BY MONTH(dob), DAY(dob)";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                birthdayList.add(new Birthday(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob").toLocalDate()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        birthdayTable.setItems(birthdayList);
    }

    @FXML
    public void addBirthday() {
        String name = nameField.getText();
        LocalDate dob = dobPicker.getValue();
        if (name.isEmpty() || dob == null) return;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO birthdays (name, dob) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, Date.valueOf(dob));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadBirthdays();
    }

    @FXML
    public void updateBirthday() {
        Birthday selected = birthdayTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        String name = nameField.getText();
        LocalDate dob = dobPicker.getValue();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE birthdays SET name=?, dob=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDate(2, Date.valueOf(dob));
            ps.setInt(3, selected.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadBirthdays();
    }

    @FXML
    public void deleteBirthday() {
        Birthday selected = birthdayTable.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM birthdays WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, selected.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadBirthdays();
    }

    @FXML
    public void searchBirthday() {
        String keyword = searchField.getText().trim().toLowerCase();
        ObservableList<Birthday> filtered = FXCollections.observableArrayList();
        for (Birthday b : birthdayList) {
            if (b.getName().toLowerCase().contains(keyword) ||
                    b.getDob().getMonth().toString().toLowerCase().contains(keyword)) {
                filtered.add(b);
            }
        }
        birthdayTable.setItems(filtered);
    }

    private void checkTodayBirthdays() {
        for (Birthday b : birthdayList) {
            if (b.getDob().getMonth() == LocalDate.now().getMonth() &&
                    b.getDob().getDayOfMonth() == LocalDate.now().getDayOfMonth()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("আজকের জন্মদিন");
                alert.setContentText(b.getName() + " এর আজ জন্মদিন 🎉");
                alert.show();
            }
        }
    }
}
