import java.util.ArrayList;

public class NumberCreator {
    public ArrayList<CustomNumber> create (ArrayList<Double> numbers) {
        ArrayList<CustomNumber> customNumbers = new ArrayList<>();
        for (Double number : numbers) {
            customNumbers.add(new CustomNumber(number));
        }
        return customNumbers;
    }
}
