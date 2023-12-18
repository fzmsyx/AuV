import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("welcome to student system");
            System.out.println("plz choose：1.login 2.register 3.forget password");
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetpassword(list);
                case "4" -> {
                    System.out.println("thx for using,bye");
                    System.exit(0);
                }
                default -> System.out.println("option illegal");
            }
        }

    }

    public static void login(ArrayList<User> list) {

    }

    public static void forgetpassword(ArrayList<User> list) {

    }

    private static void register(ArrayList<User> list) {
        System.out.println("register");
        User u = new User();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("plz enter username");
            String username = sc.next();
            boolean flag1 = checkUsername(username);
            if (!flag1) {
                System.out.println("format wrong,enter again");
                continue;
            }
            boolean flag2 = contains(list, username);
            if (flag2) {
                System.out.println("username" + username + "already exist,plz reenter");
            } else {
                System.out.println("username" + username + "avaabile");
                break;
            }
        }
        while (true) {
            System.out.println("plz enter password");
            String password = sc.next();
            System.out.println("plz reenter password");
            String againPassword = sc.next();
            if (!password.equals(againPassword)) {
                System.out.println("password unmatch,reenter plz");
                continue;
            } else {
                System.out.println("password match,continue to input");
                break;
            }
        }
        System.out.println("请输入身份证号");
        String personID = sc.next();
        Boolean FLAG = checkPersonID(personID);
    }

    private static Boolean checkPersonID(String personID) {
        if (personID.length() != 18) {
            return false;
        }
        boolean flag = personID.startsWith("0");
        if (flag) {
            return false;
        }
        for (int i = 0; i < personID.length() - 1; i++) {
            char c = personID.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }char endChar=personID.charAt(personID.length()-1);
        if(())

    }

    private static boolean contains(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String rightUsername = user.getUsername();
            if (rightUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUsername(String username) {
        int len = username.length();
        if (len > 15 || len < 3) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!(c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }
}
