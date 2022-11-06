package MySimpleCalc;

//Здесь полученный результат @result конвертируется из арабских в римские цифры
class Roman {
    String[] romanNums = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; //массив римских цифр, из которых составляются числа

   String[] getRomanNums(){  //Внешний доступ к массиву римских цифр
       return romanNums;
   }
    Roman(){
    }
    void toRoman(int result){  //в этом методе результат из арабских чисел конвертируется в римские согласно правилам и выводится на экран
        if(result<=10){        // хотя лучше было бы лучше вернуть результат и вывести его в том же классе, где и арабский вариант
            System.out.println(romanNums[result-1]);
        }else if (result>10 && result<40){
            int dozens = result/10;
            String firstRomanNum = "";
            System.out.println(dozens);
            for (int i=0;i<dozens; i++){
                firstRomanNum += romanNums[9];
            }
            System.out.println(firstRomanNum + romanNums[result-(dozens*10)-1]);
        }else if (result>=40 && result<50){
            if(result == 40){
                System.out.println("XL");
            }else {
                System.out.println("XL" + romanNums[result - 41]);
            }
        }else if (result>=50 && result<60){
            if(result == 50) {
                System.out.println("L");
            }else {
                System.out.println("L" + romanNums[result - 51]);
            }
        }else if (result>=60 && result<90){
            int dozens = (result-50)/10;
            String centralRomanNum = "";
            System.out.println(dozens);
            for (int i=0;i<dozens; i++){
                centralRomanNum += romanNums[9];
            }
            System.out.println("L"+centralRomanNum + romanNums[result-(dozens*10)-51]);
        }else if(result>=90 && result<100){
            if(result == 90) {
                System.out.println("XC");
            }else {
                System.out.println("XC" + romanNums[result - 91]);
            }
        }else if (result==100){
            System.out.println("C" );
        }
    }

}
