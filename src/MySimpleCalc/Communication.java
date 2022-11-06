package MySimpleCalc;

import java.util.*;
public class Communication { //вычисление и вывод результата (хотя вывод лучше сделать отдельным классом)

    Definition expression = new Definition();

    int indexSubString = 0;
    int indexOperation = 0;
    int result = 0;

    void Communication(){}

    void sayHello(){
        System.out.println("╔═╗╔═╗╔╗──╔╗╔═══╗╔══╗╔═╗╔═╗╔═══╗╔╗───╔═══╗╔═══╗╔═══╗╔╗───╔═══╗\n" +
                "║║╚╝║║║╚╗╔╝║║╔═╗║╚╣─╝║║╚╝║║║╔═╗║║║───║╔══╝║╔═╗║║╔═╗║║║───║╔═╗║\n" +
                "║╔╗╔╗║╚╗╚╝╔╝║╚══╗─║║─║╔╗╔╗║║╚═╝║║║───║╚══╗║║─╚╝║║─║║║║───║║─╚╝\n" +
                "║║║║║║─╚╗╔╝─╚══╗║─║║─║║║║║║║╔══╝║║─╔╗║╔══╝║║─╔╗║╚═╝║║║─╔╗║║─╔╗\n" +
                "║║║║║║──║║──║╚═╝║╔╣─╗║║║║║║║║───║╚═╝║║╚══╗║╚═╝║║╔═╗║║╚═╝║║╚═╝║\n" +
                "╚╝╚╝╚╝──╚╝──╚═══╝╚══╝╚╝╚╝╚╝╚╝───╚═══╝╚═══╝╚═══╝╚╝─╚╝╚═══╝╚═══╝");
        System.out.println("===============================================================");
        System.out.println("Вас приветствует калькулятор!");
        System.out.println("Введите выражение из двух чисел, каждое из которых не более 10");
        System.out.println("Вам доступны операции: +, -, *, /");
    }
   String communicator() { //получаем выражение из командной строки
       Scanner scanner = new Scanner(System.in);
       String string = scanner.nextLine();
       string = string.replaceAll("\\s+", "");
       string = string.replaceAll("\\+", "#");
       string = string.replaceAll("\\*", "@");
       return string;
   }
   void calculation (String string){ //вычисляем
       for (int i = 0; i<expression.getOperations().length; i++) {
           indexSubString = string.indexOf(expression.getOperations()[i]);
           if (indexSubString != -1 && indexSubString != 0 && indexSubString != string.length()-1){
               indexOperation = i;
               break;
           }else  if(indexSubString == 0 || (i==expression.getOperations().length-1 && indexSubString == -1) || indexSubString == string.length()-1){
               System.out.println("Недопустимое выражение");
               expression.setError(true);
               break;
           }
       }
       if (indexSubString != 0 && !expression.getError()) {
           String[] expressionArray = expression.defineNums(string, indexOperation);
           if (!expression.getError()){
               switch (indexOperation) { //вычисляем исходя из нужной операции
                   case 0:
                       result = Integer.parseInt(expressionArray[0]) + Integer.parseInt(expressionArray[1]);
                       break;
                   case 1:
                       result = Integer.parseInt(expressionArray[0]) - Integer.parseInt(expressionArray[1]);
                       break;
                   case 2:
                       result = Integer.parseInt(expressionArray[0]) / Integer.parseInt(expressionArray[1]);
                       break;
                   case 3:
                       result = Integer.parseInt(expressionArray[0]) * Integer.parseInt(expressionArray[1]);
                       break;
               }
               if (expression.getIsRoman()){//если числа римские, выводим результат в римских числах
                   Roman toRoman = new Roman();
                   toRoman.toRoman(result);
               }else {
                   System.out.println(result); //если арабские, то в арабских
               }
           }
       }
       if(expression.getError()){ //отлов ошибок кривым спобом
           System.out.println("Недопустимое выражение");
       }
   }
}
