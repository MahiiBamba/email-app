import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmailManager {
    public static final Scanner sc = new Scanner(System.in);
    private static String loggedUser = null;
    public static void main(String[] args) {
        while(true){
            System.out.println("\nEmail Application");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Compose Email");
            System.out.println("4. View Inbox");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.println("7. Forgot Password");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1: register();
                break;
                case 2: login();
                break;
                case 3: composeEmail();
                break;
                case 4: inbox();
                break;
                case 5: logOut();
                break;
                case 6:
                    System.out.println("Exiting the application.....");
                    return;
                case 7: forgotPass();
                break;
                default:
                    System.out.println("Please Enter a valid choice");
            }
        }
    }

    private static void register(){
        System.out.print("Enter username: ");
        String userName = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        FileHandler.writeIntoFile(FileHandler.USERS_FILE,userName +":"+ password);
        System.out.println("Registration done");
    }

    private static void login(){
        System.out.print("Enter username: ");
        String userName = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        List<String> users = FileHandler.readFromFile(FileHandler.USERS_FILE);
        for(String user : users){
            String[] parts = user.split(":");
            if(parts[0].equals(userName) && parts[1].equals(password)){
                loggedUser = userName;
                System.out.println("Login successfully");
                return;
            }
        }
        System.out.println("Invalid Credentials");
    }

    private static void composeEmail(){
        if(loggedUser == null){
            System.out.println("Please login to compose email");
            return;
        }

        System.out.print("Enter recipient: ");
        String recipient = sc.nextLine();
        System.out.print("Enter subject: ");
        String subject = sc.nextLine();
        System.out.print("Enter message: ");
        String message = sc.nextLine();
        FileHandler.writeIntoFile(FileHandler.EMAILS_FILE, loggedUser +":"+ recipient+":"+subject+":"+message);
        System.out.println("Email Composed successfully");
    }
    private static void inbox(){
        if(loggedUser == null){
            System.out.println("Please login to view emails");
            return;
        }

        System.out.println("\nInbox");
        List<String> emails = FileHandler.readFromFile(FileHandler.EMAILS_FILE);
        boolean found = false;
        for(String email : emails){
            String[] parts = email.split(":");
            if (parts[0].equals(loggedUser)) {
                System.out.println("From: " + parts[0] + " | Subject: " + parts[2] + " | Message: " + parts[3]);
                found = true;
            }
        }
        if(!found) System.out.println("No Emails Found");
    }
    private static void logOut(){
        loggedUser = null;
        System.out.println("Logged Out !!!");
    }

    private static void forgotPass(){
        System.out.println("Enter your username: ");
        String username = sc.nextLine().trim();
        List<String> users = FileHandler.readFromFile(FileHandler.USERS_FILE);
        List<String> update = new ArrayList<>();
        boolean found = false;

        for(String user : users){
            String[] parts = user.split(":");
            if(parts[0].trim().equals(username)){
                System.out.println("Enter a new password: ");
                String newPass = sc.nextLine().trim();
                update.add(username+":"+newPass);
                found = true;
            } else {
                update.add(user);
            }
        }
        if(found){
            FileHandler.updateFile(FileHandler.USERS_FILE, update);
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("User not found.");
        }
    }

}
