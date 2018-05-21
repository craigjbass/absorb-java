package uk.co.craigbass.absorb;

public class Absorb {
    public interface Block {
        void call() throws Exception;
    }

    public static void absorb(Block block) {
        try {
            block.call();
        } catch (Exception e) {
            castToRunTimeException(e);
        }
    }

    private static RuntimeException castToRunTimeException(Exception e) {
        return unsafeCast(e);
    }

    private static <T extends Exception> T unsafeCast(Exception e) throws T {
        throw (T) e;
    }
}
