import controllers.ToyController;
import model.ToyStorage;
import services.FileDelivery;
import views.LotteryView;


public class GameMain {

    public static void main(String arg[]){
        ToyStorage storage = new ToyStorage(ToyGenerator.generateToyStorage());
        LotteryView view = new LotteryView(storage, new ToyController(storage, new FileDelivery()));
        view.start();
    }

}
