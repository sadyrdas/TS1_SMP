import com.opencsv.exceptions.CsvValidationException;
import cz.cvut.fel.ts1.SeleniumTest;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String arg[]) throws CsvValidationException, IOException, InterruptedException {


        SeleniumTest seleniumTest = new SeleniumTest();
        seleniumTest.setup();
        seleniumTest.zmenitheslo();

    }
}
