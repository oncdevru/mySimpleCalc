package MySimpleCalc;
import javax.lang.model.type.NullType;

public class Main {
    public static void main(String[] args) {
        Communication communicator = new Communication();
        communicator.sayHello(); // приветствие
        String string = communicator.communicator(); //запрашиваем ввод выражения
        communicator.calculation(string); //вычисляем и выводим результат
    }
}