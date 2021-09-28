import com.sun.org.apache.xpath.internal.operations.Div;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.Converter;
import service.CustomFileReader;
import service.Validator;
import service.arithmetic.Adder;
import service.arithmetic.Divider;
import service.arithmetic.Multiplier;
import service.arithmetic.Subtractor;

import java.util.ArrayList;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReader();
        StringBuilder fileInfo = fileReader.readFile("./numbers.txt");
        Validator validator = new Validator();
        fileInfo = validator.validate(fileInfo);
        Converter converter = new Converter();
        ArrayList<Double> doubleNumbers = converter.convert(fileInfo);
        NumberCreator numberCreator = new NumberCreator();
        ArrayList<CustomNumber> customNumbers = numberCreator.create(doubleNumbers);
        int index = 0;
        if (index + 2 <= customNumbers.size()) {
            CustomNumber customNumber1 = customNumbers.get(index);
            CustomNumber customNumber2 = customNumbers.get(index + 1);
            Adder adder = new Adder();
            Subtractor subtractor = new Subtractor();
            Multiplier multiplier = new Multiplier();
            Divider divider = new Divider();
            System.out.println(adder.add(customNumber1.get(), customNumber2.get()));
        }
    }
}
