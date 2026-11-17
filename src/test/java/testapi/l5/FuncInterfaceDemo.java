package testapi.l5;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class FuncInterfaceDemo {

    @Test
    void functionalInterfaceDemo(){

    Stream.of(2,3,4,5,6)
        .filter(x->x<4)
        .forEach(System.out::println);

    Function<LocalDate, String> dateToString = date-> date.getDayOfMonth()+" of "+date.getMonth();
    System.out.println(dateToString.apply(LocalDate.now()));
    }
}
