import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static uk.co.craigbass.absorb.Absorb.absorb;

@SuppressWarnings("ALL")
public class AbsorbTest {
    private int called = 0;

    private void notExceptional() throws IOException {
        this.called++;
    }

    class TestException extends Exception {}

    private void isExceptional() throws TestException {
        throw new TestException();
    }

    @Test
    public void testCallsBlock() {
        absorb(() -> {
            notExceptional();
        });
        Assert.assertEquals(1, this.called);
    }

    @Test(expected = TestException.class)
    public void testExceptionIsThrown() {
        absorb(() -> {
            isExceptional();
        });
    }
}
