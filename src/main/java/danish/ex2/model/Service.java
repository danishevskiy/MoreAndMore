package danish.ex2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by denystymoshkevych on 7/21/17.
 */
public class Service {

    private static final int RAND_MAX = 100;
    private static final int RAND_MIN = 0;

    public static int RAND_MAX_NOW = 100;
    public static int RAND_MIN_NOW = 0;

    public static int countError = 0;
    public static int countMistake = 0;
    public static int countTry = 0;

    private static int RAND_NOW;

    private List<Integer> previousNumbers = new ArrayList<>();

    private Random random;

    public int rand(){

        random = new Random();
        RAND_NOW = random.nextInt(RAND_MAX);
        return RAND_NOW;
    }

    public int moreBOrSNumber(int c){

        previousNumbers.add(c);

        if(c == RAND_NOW)
            return 0;

        if(c > RAND_NOW){
            RAND_MAX_NOW = c;
            return -1;
        }

        if(c < RAND_NOW){
            RAND_MIN_NOW = c;
            return 1;
        }

        return -2;
    }

    public List<Integer> getPreviousNumbers() {
        return previousNumbers;
    }

}
