# 🏦 Banking Application with Email Notification

This project is a **Spring Boot application** that simulates a mini banking system.  
It supports **Person registration**, **Bank account management**, and sends **email notifications** on account creation, deposits, and withdrawals.

---

## 🚀 Features
- Register a `Person` with:
  - Aadhaar details (One-to-One)
  - Multiple Bank Accounts (One-to-Many)
- Perform:
  - **Deposit** → adds money to account and notifies via email  
  - **Withdraw** → deducts money, prevents overdraft, and notifies via email
- Oracle Database integration using **Spring Data JPA**
- Sends **email notifications** via Gmail SMTP
- Transaction management with `@Transactional`

---

## 🛠 Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Oracle Database**
- **Spring Mail (JavaMailSender)**
- **Lombok**

---

## 📂 Project Structure
src/main/java/com/hello
│── entity/ # JPA Entities (Person, Aadhaar, BankAccount)
│── repository/ # Spring Data JPA Repositories
│── service/ # Business logic + Mail service
│── runner/ # CommandLineRunner for testing
│── SpringBootMailApplication.java


---

## ⚙️ Database Schema
- **Person** (`person_bk`)
- **Aadhaar** (One-to-One with Person)
- **BankAccount** (Many-to-One with Person)

---


## 📨 Email Notifications
- On **registration** → "Your account has been created"
- On **deposit** → "Amount deposited: X, New balance: Y"
- On **withdrawal** → "Amount withdrawn: X, Remaining balance: Y"

---

## ⚡ Configuration (`application.properties`)
```properties
# Oracle DB
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=system
spring.datasource.password=123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

# Mail Server (Gmail)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=vijaycpye@gmail.com
spring.mail.password=xncmaylitqsebwdm
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

