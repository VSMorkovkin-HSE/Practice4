package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите ФИО:");

        try {
            String surname = scan.nextLine();
            String name = scan.nextLine();
            String patronymic = scan.nextLine();

            System.out.println("Введите дату рождения(в формате ДД.ММ.ГГГГ):");
            String birthdate = scan.nextLine();

            int birth_day = Integer.parseInt(birthdate.substring(0, 2));
            int birth_month = Integer.parseInt(birthdate.substring(3, 5));
            int birth_year = Integer.parseInt(birthdate.substring(6, 10));

            if (birth_year <= 1900 || birth_year > 2022 ||
                    birth_month <= 0 || birth_month > 12 ||
                    birth_day <= 0 || birth_day > 31 ||
                    birth_year % 4 == 0 && birth_month == 2 && birth_day > 29 ||
                    birth_year % 4 != 0 && birth_month == 2 && birth_day > 28
            ) {
                System.out.println("Неверно введена дата");
                return;
            }

            System.out.printf("%s %s.%s.%n", surname, name.charAt(0), patronymic.charAt(0));

            int pat_len = patronymic.length();
            String pat_end = patronymic.substring(pat_len - 2, pat_len);

            System.out.print("Пол: ");
            if (pat_end.equals("ич")) {
                System.out.println("мужской");
            } else if (pat_end.equals("на")) {
                System.out.println("женский");
            } else {
                System.out.println("невозможно определить");
            }

            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String current_date = df.format(new Date());

            int current_day = Integer.parseInt(current_date.substring(0, 2));
            int current_month = Integer.parseInt(current_date.substring(3, 5));
            int current_year = Integer.parseInt(current_date.substring(6, 10));


            int age = current_year - birth_year;

            if (birth_month > current_month || birth_month == current_month && birth_day > current_day) {
                age--;
            }

            System.out.print("Возраст: " + age);

        } catch (InputMismatchException | NumberFormatException | StringIndexOutOfBoundsException ex) {
            System.out.println(ex.toString());
        }
    }
}
