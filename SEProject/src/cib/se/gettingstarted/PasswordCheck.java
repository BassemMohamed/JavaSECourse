package cib.se.gettingstarted;

public class PasswordCheck {
    public static int rec(int x) {
        if (x == 1) {
            return 1;
        }

        return (x * rec(x - 1));
    }

    public static boolean check(String pass) {

        boolean Up = false;
        boolean D = false;
        char[] chs = pass.toCharArray();
        for (int i = 0; i < chs.length; i++) {

            if (Character.isUpperCase(chs[i])) {
                Up = true;
            }
            if (Character.isDigit(chs[i])) {
                D = true;
            }
        }

        return (Up && D);
    }

    public static void main(String[] args) {
        System.out.println(check("weElome1"));
    }
}
