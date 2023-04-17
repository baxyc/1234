import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите данные в формате Фамилия Имя Отчество датарождения номертелефона пол: ");
        String input = scanner.nextLine();

        try {
            String[] tokens = input.split(" ");

            if (tokens.length != 6) {
                throw new IllegalArgumentException("Неверное количество параметров");
            }

            String lastName = tokens[0];
            String firstName = tokens[1];
            String middleName = tokens[2];
            String birthDate = tokens[3];
            long phoneNumber = Long.parseLong(tokens[4]);
            char gender = tokens[5].charAt(0);

            if (gender != 'f' && gender != 'm') {
                throw new IllegalArgumentException("Неверный формат пола");
            }

            String filename = lastName + ".txt";
            FileWriter writer = new FileWriter(filename, true);
            writer.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + filename);

        } catch (NumberFormatException e) {
            System.out.println("Неверный формат номера телефона");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
    }
}
