package views;

import controllers.ToyController;
import model.Toy;
import model.ToyStorage;
import services.ToyDeliveryException;

import java.util.Scanner;

public class LotteryView {

    final static private String TITLE = "Добро пожаловать в розыгрыш призов!\n" +
            "Сегодня можно выиграть игрушки:";

    final static private String INPUT_MESSAGE = "Начните розыгрыш, введите: " + InputAction.SELECT + "\n" +
            "Чтобы выйти введите: " + InputAction.EXIT + "\n" +
            "Чтобы получить игрушку, введите: " + InputAction.DELIVER + "\n" +
            "Чтобы посмотреть корзину, введите: " + InputAction.SHOW_ALL;

    final private ToyController controller;
    final private ToyStorage storage;

    public LotteryView(ToyStorage storage, ToyController controller){
        this.controller = controller;
        this.storage = storage;
    }

    public void start(){
        System.out.println(TITLE);

        System.out.println("\n" + storage.getAvailableToys().toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(", ", "\n")
                .replaceAll("\\d", "")
                .replaceAll(":", "") + "\n"
        );

        while (true){
            try {
                InputAction inputAction = InputAction.fromString(prompt(INPUT_MESSAGE));

                switch (inputAction) {
                    case SELECT:
                        Toy toy = controller.selectToy();
                        System.out.printf("'%s' Игрушка выиграна!\n", toy);
                        break;
                    case SHOW_ALL:
                        if (controller.getCollectedToys().isEmpty()){
                            System.out.println("У Вас нет игрушек в корзине!");
                        } else {
                            System.out.println("У Вас в корзине:");
                            System.out.println("\n" + controller.getCollectedToys().toString()
                                    .replaceAll("\\[", "")
                                    .replaceAll("]", "")
                                    .replaceAll(", ", "\n") + "\n"
                            );
                        }
                        break;
                    case DELIVER:
                        controller.deliverToy();
                        break;
                    case EXIT:
                        return;
                    default:
                        throw new InputException();
                }
            } catch (ToyDeliveryException | InputException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + "\n");
        return in.nextLine();
    }

}
