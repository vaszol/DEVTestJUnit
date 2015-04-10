
// Еще одна "вкусность" Java 5 - можно импортировать static-методы
import java.util.Comparator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;

import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;


public class TestCalc {
    // Обратите внимание на название - оно теперь сделано таким для соблюдения порядка

    @Test
    public void get001SumTest() {
        Calc c = new Calc();
        assertEquals(50, c.getSum(20, 30));
    }

    // Обратите внимание на название - оно теперь сделано таким для соблюдения порядка
    @Test
    public void get002SubtractionTest() {
        Calc c = new Calc();
        assertEquals(-10, c.getSubtraction(20, 30));
    }

    // Метод возвращает компаратор, который позволяет отсортировать методы в алфавитном порядке
    private static Comparator forward() {
        return new Comparator() {

            public int compare(Object o1, Object o2) {
                Description d1 = (Description) o1;
                Description d2 = (Description) o2;
                return d1.getDisplayName().compareTo(d2.getDisplayName());
            }
        };
    }

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalcListener());
        // Обратите внимание на этот вызов - ниже немного комментариев
        core.run(Request.aClass(TestCalc.class).sortWith(forward()));
    }
}

// Ну здесь по идее должно быть все понятно
class CalcListener extends RunListener {

    @Override
    public void testStarted(Description desc) {
        System.out.println("Started:" + desc.getDisplayName());
    }

    @Override
    public void testFinished(Description desc) {
        System.out.println("Finished:" + desc.getDisplayName());
    }

    @Override
    public void testFailure(Failure fail) {
        System.out.println("Failed:" + fail.getDescription().getDisplayName() + " [" + fail.getMessage() + "]");
    }
}