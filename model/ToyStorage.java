package model;

import services.ToyDeliveryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ToyStorage {

    private final Map<ToyEntity,Integer> toys;

    public ToyStorage(Map<ToyEntity,Integer> toys) {
        this.toys = toys;
    }

    public List<ToyEntity> getAvailableToys(){
        return new ArrayList<>(toys.keySet());
    }

    public Toy getToyFromStorage(ToyEntity toy) throws ToyDeliveryException {
        if (toys.get(toy)!=0){
            toys.put(toy, toys.get(toy) + 1);
            return new Toy(UUID.randomUUID().toString(), toy.getName());
        } else {
            throw new ToyDeliveryException(String.format("%s игрушка закончилась на складе!", toy.getName()));
        }
    }


}
