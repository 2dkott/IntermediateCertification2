package services;

import model.Toy;

public interface Delivery {
    void deliver(Toy toy) throws ToyDeliveryException;
}
