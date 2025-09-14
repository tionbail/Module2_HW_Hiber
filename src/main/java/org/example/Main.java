package org.example;


import Service.UserService;
import model.User;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();

    public static void main(String[] args) {



        while (true) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> createUser();
                case 2 -> readUser();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 5 -> {
                    return;
                }
                default -> System.out.println("Incorrect command");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Create User");
        System.out.println("2. Read User");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. Exit");
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void createUser() {
        String name = getStringInput("name: ");
        String email = getStringInput("email: ");
        int age = getIntInput("age: ");

        try {
            User user = new User(name, email, age);
            userService.createUser(user);
            System.out.println("User created: " + user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readUser() {
        int id = getIntInput("User ID: ");

        try {
            User user = userService.readUser(id);
            if (user != null) {
                System.out.println("User found: " + user);
            } else {
                System.out.println("User not found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateUser() {
        int id = getIntInput("User ID: ");

        try {
            User user = userService.readUser(id);
            if (user == null) {
                System.out.println("Not found" + id);
                return;
            }
            String name = getStringInput("Enter new name (press enter to keep current): ");
            String email = getStringInput("Enter new email (press enter to keep current): ");
            String ageStr = getStringInput("Enter new age (press enter to keep current): ");

            if (!name.isEmpty()) user.setName(name);
            if (!email.isEmpty()) user.setEmail(email);
            if (!ageStr.isEmpty()) user.setAge(Integer.parseInt(ageStr));

            userService.updateUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteUser() {
        int id = getIntInput("User ID: ");

        try {
            User user = userService.readUser(id);
            if (user == null) {
                System.out.println("Not found: " + id);
                return;
            }
                userService.deleteUser(user);
                System.out.println("User deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}