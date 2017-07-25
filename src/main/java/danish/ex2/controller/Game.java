package danish.ex2.controller;

import danish.ex2.model.Service;
import danish.ex2.view.PrintOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static danish.ex2.model.Service.RAND_MAX_NOW;
import static danish.ex2.model.Service.RAND_MIN_NOW;
import static danish.ex2.view.PrintOut.*;

/**
 * Created by denystymoshkevych on 7/21/17.
 */
public class Game {

    private static Service service;
    private static PrintOut printOut;

    public Game(Service service, PrintOut printOut) {

        this.service  = service;
        this.printOut = printOut;
    }

    public static void start() throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        guessNumber(br);
    }

    public static void guessNumber(BufferedReader br) throws IOException {

        service = new Service();
        printOut = new PrintOut();

        String privius = null;

        int point = -1;
        int update = 0;

        printOut.printMessage(FIRST_MESSAGE);

        service.rand();

        while (!(point == 0)) {

            service.countTry++;

            try{
                update = Integer.parseInt(br.readLine());

                if (update > Service.RAND_MAX_NOW || update < Service.RAND_MIN_NOW) {
                    service.countError++;
                    printOut.printMessage(privius);
                } else {
                    point = service.moreBOrSNumber(update);

                    if (point == 1) {
                        service.countMistake++;
                        privius = UP_NUMBER_MESSAGE + RAND_MIN_NOW + " to " + RAND_MAX_NOW;
                        printOut.printMessage(privius);
                    }
                    if (point == -1) {
                        service.countMistake++;
                        privius = DOWN_NUMBER_MESSAGE + + RAND_MIN_NOW + " to " + RAND_MAX_NOW;
                        printOut.printMessage(privius);
                    }
                }
            }catch (NumberFormatException e){
                service.countError++;
                printOut.printMessage(COUNT_MISTAKE + privius);
            }
        }
        
        printOut.printFinalMessage(service.countTry, service.countMistake,
                service.countError, service.getPreviousNumbers());
    }
}
