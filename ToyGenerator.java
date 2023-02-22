import model.Toy;
import model.ToyEntity;

import java.util.*;

public class ToyGenerator {

    final static private int[] defaultWeights = {30, 25, 20, 15, 10};
    final static private String[] defaultNames = {"Мишка", "Машина", "Кукла", "Поезд", "Солдатик"};

    public static Map<ToyEntity, Integer> generateToyStorage(){
        Map<ToyEntity, Integer> toys = new HashMap<>();
        ArrayList<String> shuffledNames = new ArrayList<>(Arrays.asList(defaultNames));
        Collections.shuffle(shuffledNames);
        for(int i = 0; i < shuffledNames.size(); i++){
            toys.put(new ToyEntity(i, shuffledNames.get(i),defaultWeights[i]), defaultWeights[i]*5);
        }
        return toys;
    }
}
