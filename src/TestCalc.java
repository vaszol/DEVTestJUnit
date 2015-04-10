
// ��� ���� "���������" Java 5 - ����� ������������� static-������
import java.util.Comparator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.JUnitCore;

import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.Failure;


public class TestCalc {
    // �������� �������� �� �������� - ��� ������ ������� ����� ��� ���������� �������

    @Test
    public void get001SumTest() {
        Calc c = new Calc();
        assertEquals(50, c.getSum(20, 30));
    }

    // �������� �������� �� �������� - ��� ������ ������� ����� ��� ���������� �������
    @Test
    public void get002SubtractionTest() {
        Calc c = new Calc();
        assertEquals(-10, c.getSubtraction(20, 30));
    }

    // ����� ���������� ����������, ������� ��������� ������������� ������ � ���������� �������
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
        // �������� �������� �� ���� ����� - ���� ������� ������������
        core.run(Request.aClass(TestCalc.class).sortWith(forward()));
    }
}

// �� ����� �� ���� ������ ���� ��� �������
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