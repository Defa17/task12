package task.bhh.logic;

public class ConvertAnswer {
    public static String getAnswer(String s){
        Main m = new Main();
        if (m.isValid(s)){
            return "Правильная последовательность";
        } else return "Неправильная последовательность";
    }
}
