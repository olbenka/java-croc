package first;

import java.util.Scanner; // для ввода данных с консоли

public class Prime {
    public static boolean isSimple(long num) {
        for (int i = 2; i <= (num/2); ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        long number = in.nextLong();
        in.close();
        System.out.printf("Проверка %d на простоту: ", number);
        boolean result = isSimple(number);
        if (result) {
            System.out.println("Простое");
            System.out.printf("Является ли %d числом-близнецом: ", number);
            long checkOne = number - 2;
            long checkTwo = number + 2;
            boolean simpleOne = false;
            if (checkOne >= 2){
                simpleOne = isSimple(checkOne);
            }
            boolean simpleTwo = isSimple(checkTwo);

            if (simpleOne && simpleTwo){
                System.out.printf("%d является числом-близнецом в паре с %d \n", number, checkOne);
                System.out.printf("%d является числом-близнецом в паре с %d \n", number, checkTwo);
            } else if (simpleOne){
                System.out.printf("%d является числом-близнецом в паре с %d \n", number, checkOne);
            } else if (simpleTwo){
                System.out.printf("%d является числом-близнецом в паре с %d \n", number, checkTwo);
            } else {
                System.out.printf("%d не является числом-близнецом \n", number);
            }
        } else {
            System.out.println("Составное");
        }
    }
}

/* Напишите программу, которая для заданного числа от 2 до 10^10 (10 000 000 000)
проверит является ли это число простым. Вывести на экран “Простое” или “Составное” число.
*  проверить является ли число - числом-близнецом */