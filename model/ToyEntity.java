package model;

public class ToyEntity {

    private final int id;
    private final String name;
    private final int weight;

    public ToyEntity(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", id, name, weight);
    }
}
