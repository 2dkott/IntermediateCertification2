package controllers;

import model.Toy;
import model.ToyEntity;
import model.ToyStorage;
import services.Delivery;
import services.ToyDeliveryException;

import java.util.ArrayList;
import java.util.List;

public class ToyController {

    final private Delivery delivery;
    final private ToyStorage toyStorage;
    final private List<Toy> collectedToys = new ArrayList<>();

    public ToyController(ToyStorage toyStorage, Delivery delivery){
        this.delivery = delivery;
        this.toyStorage = toyStorage;
    }

    public Toy selectToy() throws ToyDeliveryException {
        ToyEntity toyEntity = new ToySelection(toyStorage.getAvailableToys()).next();
        Toy toyToDeliver = toyStorage.getToyFromStorage(toyEntity);
        collectedToys.add(toyToDeliver);
        return toyToDeliver;
    }

    public void deliverToy() throws ToyDeliveryException {
        if (!collectedToys.isEmpty()){
            delivery.deliver(collectedToys.get(0));
            collectedToys.remove(0);
        } else {
            throw new ToyDeliveryException("У Вас нет игрушек в корзине!");
        }
    }

    public List<Toy> getCollectedToys() {
        return collectedToys;
    }
}
