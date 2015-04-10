
// ��� ���� "���������" Java 5 - ����� ������������� static-������
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Ignore;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.assertEquals;

public class TestCalc {
    // @Test - ��� ���������, ������� ����������, ��� ����� ������ ���� ������ ��� ������������ ����-������

    @Test
    public void getSumTest() {
        Calc c = new Calc();
        assertEquals(50, c.getSum(20, 30));
    }

    @Test
    public void getSubtractionTest() {
        Calc c = new Calc();
        assertEquals(-10, c.getSubtraction(20, 30));
    }

    @BeforeClass
    public static void allTestsStarted() {
        System.out.println("All tests started");
    }

    @AfterClass
    public static void allTestsFinished() {
        System.out.println("All tests finished");
    }

    @Before
    public void testStarted() {
        System.out.println("Started");
    }

    @After
    public void testFinished() {
        System.out.println("Finished");
    }

    @Test
    // �������� �������� ��������� - ��� �������, ��� ���� ����� ��������������. ���� �� ������,
    // �� ��������� ���������
    @Ignore
    public void testIgnored() {
        System.out.println("Ignored test");
    }

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.run(TestCalc.class);
    }
}