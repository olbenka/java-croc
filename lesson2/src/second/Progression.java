package second;

public class Progression {
    public static void main(String[] args) {
        int init = Integer.parseInt(args[0]);
        int diff = Integer.parseInt(args[1]);
        int amount = Integer.parseInt(args[2]);
        if (amount >= 0) {
            long result = 0;
            for (int i = 0; i < amount; ++i) {
                result += init;
                init += diff;
            }
            System.out.print(result);
        } else {
            System.out.print("Error: Amount value is negative");
        }
    }
}

/* Написать программу, которая принимает 3 аргумента, и считает сумму арифметической прогрессии.
Аргументы: начальный элемент, разность арифметической прогрессии и кол-во членов прогрессии.
Каждое число от -10 000 до +10 000
Решить с помощью использования циклов, а не формулы суммы.
*/