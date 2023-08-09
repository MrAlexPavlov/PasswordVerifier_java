import java.util.Scanner;

/**
 * Создайте класс PasswordVerifier. 
 * Этот класс должен содержать метод, который принимает строку пароля и проверяет его на соответствие следующим правилам:
 *      Пароль должен быть не менее 8 символов.
 *      Пароль должен содержать хотя бы одну цифру.
 *      Пароль должен содержать хотя бы одну заглавную букву.
 *      Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.
 */
public class PasswordVerifier {
    private Scanner scan;
    private String password;
    private int len = 8;
    private boolean case_sensetive = true;
    private boolean didgit = true;
    private String help = "Пароль должен быть не менее 8 символов\n содержать хотябы одну цифру и заглавную букву";

    public PasswordVerifier(int len, boolean case_sensetive, boolean didgit){
        this.len = len;
        this.case_sensetive = case_sensetive;
        this.didgit = didgit;
        setPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        System.out.println(help);

        try {
            this.password = this.input("Введите пароль!");
        } catch (LenghtPasswordException e) {
            System.out.println(e.getMessage());
            this.password = null;
        } catch (LowerUpperCaseException e) {
            System.out.println(e.getMessage());
            this.password = null;
        } catch (DigitPasswordException e) {
            System.out.println(e.getMessage());
            this.password = null;
        }
    }

    private String input(String text) throws LenghtPasswordException, LowerUpperCaseException, DigitPasswordException {
        this.scan = new Scanner(System.in);
        System.out.println(text);
        String result = scan.nextLine();

        if (result.length() < this.len) {
            throw new LenghtPasswordException("Ошибка!\nПароль должен быть не менее 8 символов.");
        }

        if (didgit & !searchDigit(result)) {
            throw new DigitPasswordException("Ошибка!\nПароль должен содержать хотя бы одну цифру");
        }

        if (case_sensetive & result.toLowerCase() == result) {
            throw new LowerUpperCaseException("Ошибка!\nПароль должен содержать хотя бы одну заглавную букву.");
        }
        return result;
    }

    private boolean searchDigit(String text){
        for (int i = 0; i < text.length(); i++)
            if (Character.isDigit(text.charAt(i)) )
                return true;
        return false;
    }
}



class LenghtPasswordException extends Exception {
    public LenghtPasswordException(String message) {
        super(message);
    }
}

class LowerUpperCaseException extends Exception {
    public LowerUpperCaseException(String message) {
        super(message);
    }
}

class DigitPasswordException extends Exception {
    public DigitPasswordException(String message) {
        super(message);
    }
}