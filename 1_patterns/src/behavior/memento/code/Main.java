package behavior.memento.code;

public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(new TextWindow());

        //Ввели две строки
        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");

        //Сохранили ввод
        textEditor.hitSave();

        //Ввели ещё строку
        textEditor.write("Buy milk and eggs before coming home\n");

        //Отменили введенное на последнем шаге
        textEditor.hitUndo();

        //Проверка что в текстовом окне остался текст после
        //двух первых вводов.
        System.out.println((textEditor.print()).equals("The Memento Design Pattern\nHow to implement it in Java?\n"));
    }
}
