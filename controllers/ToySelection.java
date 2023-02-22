package controllers;

import model.ToyEntity;
import model.ToyStorage;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class ToySelection {
    private final NavigableMap<Double, ToyEntity> map = new TreeMap<Double, ToyEntity>();
    private double total = 0;

    public ToySelection(List<ToyEntity> toyEntities){
        toyEntities.forEach(toy -> {
            add(toy.getWeight(), toy);
        });
    }

    private void add(double weight, ToyEntity result) {
        if (weight <= 0 || map.containsValue(result))
            return;
        total += weight;
        map.put(total, result);
    }

    public ToyEntity next() {
        double value = ThreadLocalRandom.current().nextDouble() * total;
        return map.ceilingEntry(value).getValue();
    }
}
