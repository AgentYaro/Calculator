import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, RomanException {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        input = new Scanner(line);
        int num1, num2;
        Roman n1, n2;
        String w1, w2, op;
        w1 = input.next();
        if (input.hasNext()) {
            op = input.next();
            w2 = input.next();
            if (input.hasNext())
                throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            if ((op.contains("+")) || (op.contains("-")) || (op.contains("*")) || (op.contains("/"))) {
                if (Roman.IsRoman(w1) && Roman.IsRoman(w2)) {
                    n1 = Roman.NameSearch(w1);
                    n2 = Roman.NameSearch(w2);
                    if ((n1.getValue() > 10) || (n2.getValue() > 10))
                        throw new IOException("Необходимо ввести числа от 1 до 10");
                    switch (op) {
                        case "+" -> System.out.println(Roman.ValSearch(n1.getValue() + n2.getValue()));
                        case "-" -> System.out.println(Roman.ValSearch(n1.getValue() - n2.getValue()));
                        case "*" -> System.out.println(Roman.ValSearch(n1.getValue() * n2.getValue()));
                        case "/" -> System.out.println(Roman.ValSearch(n1.getValue() / n2.getValue()));
                        default -> {
                        }
                    }
                } else try {
                    num1 = Integer.parseInt(w1);
                    num2 = Integer.parseInt(w2);
                    if ((num1 > 10) || (num2 > 10) || (num1 < 1) || (num2 < 1))
                        throw new IOException("Необходимо ввести числа от 1 до 10");
                    switch (op) {
                        case "+" -> System.out.println(num1 + num2);
                        case "-" -> System.out.println(num1 - num2);
                        case "*" -> System.out.println(num1 * num2);
                        case "/" -> System.out.println(num1 / num2);
                    }
                } catch (NumberFormatException e) {
                    throw new IOException("Используются одновременно разные системы счисления");
                }
            } else throw new IOException("строка не является математической операцией");
        }
        else throw new IOException("строка не является математической операцией");
    }
}
