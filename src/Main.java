import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Note> notes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Записная книга
        // Заметка: текст + дата/время
        // Храним сколько угодно
        // Можем выводить на экран, добавлять, удалять

        while (true) {
            printMenu();

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                processMenuItemSelect(number);
//            System.out.println("Номер:" + number);
            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - вывести список заметок");
        System.out.println("2 - вывести заметку с номером");
        System.out.println("3 - удалить заметку");
        System.out.println("4 - добавить заметку");
        System.out.println("5 - выйти");
    }

    public static void processMenuItemSelect(int number) {
        switch (number) {
            case 1: {
                // вывести список заметок
                printAllNotes();
                break;
            }
            case 4: {
                // добавить заметку
                addNote();
                break;
            }
            case 5: {
                // выйти
                System.exit(0);
            }
        }
    }

    public static void addNote() {
        System.out.println("Введите текст заметки:");
        String text = scanner.nextLine();
        long datetime = System.currentTimeMillis();

        Note note = new Note();
        note.datetime = datetime;
        note.text = text;

        notes.add(note);
    }

    public static void printAllNotes() {
        System.out.println("Все заметки:");

        int index = 0;
        for (Note note : notes) {
            System.out.println(index + " " + note.text.substring(0, 16) + "...");
        }
    }
}