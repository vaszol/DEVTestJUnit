
// ��� ���� "���������" Java 5 - ����� ������������� static-������
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import static org.junit.Assert.assertEquals;

public class TestCalc {
    // @Test - ��� ���������, ������� ����������, ��� ����� ������ ���� ������ ��� ������������ ����-������

    @Test
    public void getSumTest() {
        Calc c = new Calc();
        // ���� ����� ������� ����������, ���� ��������� ������ ������������ ����� ������� �� 50
        assertEquals(c.getSum(20, 30), 50);
    }

    @Test
    public void getSubtractionTest() {
        Calc c = new Calc();
        // ���� ����� ������� ����������, ���� ��������� ������ ������������ ����� ������� �� -10
        assertEquals(-10, c.getSubtraction(20, 30));
    }

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        // ��� ����������� ������ ������������ ���������/���������
        core.addListener(new CalcListener());
        core.run(TestCalc.class);
    }
}

// � ��� ��� ����������
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