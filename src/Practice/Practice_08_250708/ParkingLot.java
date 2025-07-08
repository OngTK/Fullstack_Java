package Practice.Practice_08_250708;

public class ParkingLot {

    int calculateFee(int time) {
        int price;
        if (time <= 30) {
            price = 1000;
        } else {
            price = 1000 + ((time - 30) / 10 * 500);
        }
        if (price >= 20000) {
            price = 20000;
        }
        return price;
    }
}
