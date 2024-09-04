import java.util.HashMap;
import java.util.Scanner;

public class UserManager {
    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter user age:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter user ID:");
        String id = scanner.nextLine();

        User newUser = new User(name, age, id);
        users.put(id, newUser);
        System.out.println("User created successfully!");
    }

    public void updateUser(String id) {
        if (users.containsKey(id)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Updating user: " + id);
            System.out.println("Enter new name:");
            String name = scanner.nextLine();
            System.out.println("Enter new age:");
            int age = scanner.nextInt();
            scanner.nextLine();

            User user = users.get(id);
            user.setName(name);
            user.setAge(age);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    public void deleteUser(String id) {
        if (users.containsKey(id)) {
            users.remove(id);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }
}
