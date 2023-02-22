package services;

import model.Toy;

import java.io.*;

public class FileDelivery implements Delivery{
    public void deliver(Toy toy) throws ToyDeliveryException {
        createToyFile(String.format("%s%s.txt", toy.getId(), toy.getName()), toy);
    }

    private void createToyFile(String fileName, Toy toy) throws ToyDeliveryException {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.printf("'%s' игрушка выдана!%n", toy);
            } else {
                System.out.printf("'%s' такая игрушка уже выдана, странно...%n", toy);
            }
        } catch (IOException e) {
            throw new ToyDeliveryException(e.getMessage());
        }
    }


}
