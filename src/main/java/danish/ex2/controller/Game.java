package danish.ex2.controller;

import danish.ex2.model.Service;
import danish.ex2.view.PrintOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        int point = -1;
        int update = 0;

        printOut.printMessage(FIRST_MESSAGE);

        service.rand();

        while (!(point == 0)) {

            service.countTry++;

            try{
                update = Integer.parseInt(br.readLine());

                if (update > 100 || update < 0) {
                    service.countError++;
                    printOut.printMessage(FIRST_MESSAGE);
                } else {
                    point = service.moreBOrSNumber(update);

                    if (point == 1) {
                        service.countMistake++;
                        printOut.printMessage(UP_NUMBER_MESSAGE);
                    }
                    if (point == -1) {
                        service.countMistake++;
                        printOut.printMessage(DOWN_NUMBER_MESSAGE);
                    }
                }
            }catch (NumberFormatException e){
                service.countError++;
                printOut.printMessage(FIRST_MESSAGE);
            }
        }
        
        printOut.printFinalMessage(service.countTry, service.countMistake,
                service.countError, service.getPreviousNumbers());
    }
}
