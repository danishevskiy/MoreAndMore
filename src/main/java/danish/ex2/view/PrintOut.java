package danish.ex2.view;

import java.util.List;

/**
 * Created by denystymoshkevych on 7/21/17.
 */
public class PrintOut {

    public static final String FIRST_MESSAGE = "Please, guess a number from 0 to 100";
    public static final String SUCCESS_MESSAGE = "Congratulation, You are Winner";
    public static final String UP_NUMBER_MESSAGE = "Enter a larger number";
    public static final String DOWN_NUMBER_MESSAGE = "Enter a smaller number";
    public static final String COUNT_MISTAKE = "Mistake : ";
    public static final String COUNT_TRY = "All try : ";
    public static final String COUNT_ERROR = "Error : ";
    public static final String ALL_TRY_NUMBER = "All try number: ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printFinalMessage(int countTry, int countMistake, int countError, List<Integer> previousNumbers){

        StringBuilder sb = new StringBuilder();

        sb.     append(COUNT_TRY + countTry + '\n').
                append(COUNT_MISTAKE + countMistake + '\n').
                append(COUNT_ERROR + countError + '\n').
                append(ALL_TRY_NUMBER + previousNumbers);

        System.out.println(sb);

        printMessage(SUCCESS_MESSAGE);
    }
}
