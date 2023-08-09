public class pass {
    public static void main(String[] args) {
        PasswordVerifier passwordVerifier = new PasswordVerifier();
        System.out.println("Ваш пароль корректен!:"+ passwordVerifier.getPassword());
    }
}
