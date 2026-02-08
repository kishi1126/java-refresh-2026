import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<Integer, User> users = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = readInt("選択: ");

            switch (choice) {
                case 1 -> createUser();
                case 2 -> listUsers();
                case 3 -> updateUser();
                case 4 -> deleteUser();
                case 0 -> {
                    System.out.println("終了します");
                    return;
                }
                default -> System.out.println("0〜4で選んでね");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- User CRUD ---");
        System.out.println("1: 追加");
        System.out.println("2: 一覧");
        System.out.println("3: 更新");
        System.out.println("4: 削除");
        System.out.println("0: 終了");
    }

    private static void createUser() {
        String name = readLine("名前: ");
        int id = nextId++;
        users.put(id, new User(id, name));
        System.out.println("追加しました: id=" + id);
    }

    private static void listUsers() {
    if (users.isEmpty()) {
        System.out.println("ユーザーがいません");
        return;
    }
    System.out.println("--- 一覧 ---");
    users.keySet().stream().sorted().forEach(id -> System.out.println(users.get(id)));
    }

    private static void updateUser() {
        int id = readInt("更新するid: ");
        User u = users.get(id);
        if (u == null) {
            System.out.println("そのidは存在しません");
            return;
        }
        String newName = readLine("新しい名前: ");
        u.setName(newName);
        System.out.println("更新しました: " + u);
    }

    private static void deleteUser() {
        int id = readInt("削除するid: ");
        User removed = users.remove(id);
        if (removed == null) {
            System.out.println("そのidは存在しません");
        } else {
            System.out.println("削除しました: " + removed);
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してね");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
}
