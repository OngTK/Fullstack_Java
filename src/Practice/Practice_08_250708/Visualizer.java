package Practice.Practice_08_250708;

public class Visualizer {

    String getStars (int x){
        String result = "";
        for (int i = 1 ; i <= x ; i++ ){
            result += "★";
        }
        return result;
    }
}
