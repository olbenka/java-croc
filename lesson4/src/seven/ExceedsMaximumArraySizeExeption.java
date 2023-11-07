package seven;

// мне просто было интересно создать свою ошибку, хоть она и бесполезна
public class ExceedsMaximumArraySizeExeption extends Exception {
    public ExceedsMaximumArraySizeExeption(String message) {
        super(message);
    }
}
