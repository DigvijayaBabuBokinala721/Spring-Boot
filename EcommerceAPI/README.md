# 🛒E-Commerce REST API (Spring Boot + JPA + Hibernate)

This project is a simple **E-Commerce REST API** built using **Spring Boot**, **Spring Data JPA**, and **Hibernate**.  
It demonstrates CRUD operations on **Customers** and **Orders** with proper relationships (`OneToMany`, `ManyToOne`).

---

## 🚀 Features
- Register a new customer
- Place an order for a customer
- Update customer details (full update & partial update)
- Delete an order by customer
- Uses **Spring Data JPA** with relational DB (Oracle)
- Handles `OneToMany` (Customer → Orders) and `ManyToOne` (Order → Customer) relationships

---

## 🏗️ Tech Stack
- **Java 17**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Database**: Oracle 

---

## 📂 Project Structure
com.hello
┣ 📂 controller # REST Controllers
┣ 📂 entity # JPA Entities
┣ 📂 repository # Spring Data JPA Repositories
┣ 📂 service # Service Interfaces & Implementations

---