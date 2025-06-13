সহপাঠীর জন্মদিন ম্যানেজার 

 টেকনোলজি:
- Java FX (UI)
- MySQL (Database)
- JDBC (Connectivity)

ডেটাবেস স্ট্রাকচার:
```sql
CREATE DATABASE birthday_db;
USE birthday_db;

CREATE TABLE birthdays (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    dob DATE
);
