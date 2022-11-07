package MySimpleCalc;

public class Definition {
    void Definition(){

    }
    String[] expression = new String[2];
    boolean isRomanOne = false;
    boolean isRomanTwo = false;
    int romanIndexOne=0;
    int romanIndexTwo=0;
    boolean isRoman = false;
    boolean isError = false;
    String[] operations = {"#", "-", "/", "@"}; //массиы операций. + заменен #, * заменено @

    String[] getOperations(){ //внешний доступ к массиву операций
        return  operations;
    }
    String[] defineNums(String string, int indexOperation){ //определяем, являются ли числа римскими
        expression = string.split(operations[indexOperation]);
        Roman roman = new Roman();
        if (expression.length==2) {
            for (int i = 0; i < roman.getRomanNums().length; i++) {
                String r = roman.getRomanNums()[i];
                if (expression[0].equalsIgnoreCase(r)) {
                    isRomanOne = true;
                    romanIndexOne = i;
                }
                if (expression[1].equalsIgnoreCase(r)) {
                    isRomanTwo = true;
                    romanIndexTwo = i;
                }
            }
            if (isRomanOne && isRomanTwo) {
                isRoman = setIsRoman(true);
                expression[0] = Integer.toString(romanIndexOne + 1);
                expression[1] = Integer.toString(romanIndexTwo + 1);
            } else if ((isRomanOne && !isRomanTwo) || (!isRomanOne && isRomanTwo)) {
                isError = setError(true);
            } else if (!isRoman && (Integer.parseInt(expression[0]) > 10 || Integer.parseInt(expression[1]) > 10)) {
                isError = setError(true);
                System.out.println("Введено число больше 10");
            }
        }else {
            isError = setError(true);
            System.out.println("Вы ввели больше 2х чисел");
        }
        return expression;
    }
    boolean getError(){
        return isError;
    }
    boolean setError(boolean error){
        this.isError = error;
        return true;
    }

    boolean getIsRoman(){
        return isRoman;
    }
    boolean setIsRoman(boolean isRoman){
        this.isRoman = isRoman;
        return  isRoman;
    }
}
