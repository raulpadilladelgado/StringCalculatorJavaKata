public class NegativesNotAllowedException extends RuntimeException {
    public NegativesNotAllowedException(int negativeNumber) {
        super("No se permiten números negativos".concat(String.valueOf(negativeNumber)));
    }
}
