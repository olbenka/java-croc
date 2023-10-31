package seven;

// мне просто было интересно создать свою ошибку, хоть она и бесполезна
public class OrderException extends Exception {
    public OrderException(String message) {
        super(message);
    }
}
