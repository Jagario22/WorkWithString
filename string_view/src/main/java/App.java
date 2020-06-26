import dataReader.FileReader;
import util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private static int chooseOperation() throws IOException {
        System.out.println();
        System.out.println("1. подсчет всех символов и отсортировать по порядку количества встречаний");
        System.out.println("2. подсчет всех слов и отсортировать по порядку количества встречаний");
        System.out.println("3. реверс всех слов");
        System.out.println("Введите номер операции (для выхода 0): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        if (num >= 0 && num <= 3) {
            return num;
        }
        else {
            System.out.println("Неверный номер операции");
            return -1;
        }
    }

    private static void makeOperation(int num, String data) {

        switch (num) {
            case 1:
                System.out.println(StringUtil.countOfAllCharacters(data));
                break;
            case 2:
                System.out.println(StringUtil.countOfAllWords(data));
                break;
            case 3:
                System.out.println(StringUtil.reverseWords(data));
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        String data = FileReader.getData();
        int num = 1;
        while (num != 0) {
            num = chooseOperation();
            if (num != -1 && num != 0) {
                makeOperation(num, data);
            }
        }

    }
}
