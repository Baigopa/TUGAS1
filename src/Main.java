import java.util.Scanner;

public class Main {

    private static final String[][] users = {
            {"202310370311069", "Yogi Aditya Narotama", "Student"},
            {"admin", "admin", "Admin", "password"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (login("Student", scanner)) {
                    studentMenu(scanner);
                }
            } else if (choice.equals("2")) {
                if (login("Admin", scanner)) {
                    adminMenu(scanner);
                }
            } else if (choice.equals("3")) {
                System.out.println("BABAY");
                break;
            } else {
                System.out.println("Invalid option, please choose again.");
            }
        }
        scanner.close();
    }

    private static boolean login(String role, Scanner scanner) {
        System.out.print("Enter your " + (role.equals("Student") ? "NIM" : "username") + ": ");
        String identifier = scanner.nextLine();

        for (String[] user : users) {
            if (user[0].equals(identifier) && user[2].equals(role)) {
                if (role.equals("Admin")) {
                    System.out.print("Enter your password (admin): ");
                    String password = scanner.nextLine();
                    if (password.equals(user[3])) {
                        System.out.println("Successful Login as " + role);
                        return true;
                    } else {
                        System.out.println("Invalid password for " + role + " user");
                        return false;
                    }
                } else {
                    System.out.println("Successful Login as " + role);
                    return true;
                }
            }
        }

        System.out.println(role + " User Not Found!!");
        return false;
    }
    private static void studentMenu(Scanner scanner) {
        // Student menu logic here
    }
    private static void adminMenu(Scanner scanner) {
        // Admin menu logic here
    }
}