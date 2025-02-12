

# **Console-Based Email Application (Java)**

## **Project Description**
This is a simple **console-based email application** written in Java that allows users to:  
- **Register** with a username and password  
- **Login** with their credentials  
- **Reset their password** if forgotten  
- **Compose and send emails** to other registered users  
- **View received emails (Inbox)**  
- **Logout and Exit**  

All user credentials and email data are **stored in text files** (`users.txt` and `emails.txt`), making the application **file-based** instead of using a database.

---

## **Features**
✅ **User Registration** – Stores username and password in `users.txt`  
✅ **Login System** – Verifies credentials before allowing access  
✅ **Forgot Password** – Allows password reset for existing users  
✅ **Compose Email** – Saves emails to `emails.txt` with sender, recipient, subject, and message  
✅ **View Inbox** – Displays emails sent to the logged-in user  
✅ **Logout & Exit** – Allows secure logout and termination  

---

## **How to Run the Project**
### **1. Prerequisites**
- Install **Java JDK 8+**
- Use a **command-line terminal** (Windows CMD, PowerShell, Linux Terminal, etc.)

### **2. Compile the Program**
```sh
javac EmailApp.java
```

### **3. Run the Program**
```sh
java EmailApp
```

---

## **File Structure**
```
📂 EmailApp/
│── 📄 EmailApp.java      # Main Java program
│── 📄 FileHandler.java   # Handles file operations
│── 📄 users.txt          # Stores registered users (username, password)
│── 📄 emails.txt         # Stores emails (sender, recipient, subject, message)
```

---

## **Example Usage**
```
Email Application
1. Register
2. Login
3. Forget Password
4. Compose Email
5. View Inbox
6. Logout
7. Exit
Choose an option: 1

Enter username: Mansi
Enter password: mansi123
Registration successful!
```
