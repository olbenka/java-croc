package six;

public class AnnotatedImage {
    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    Annotation findByPoint(int x, int y) {
        for (Annotation annotation : annotations) {
            if (annotation.getFigure().inFigure(x, y)) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByDescription(String description) {
        for (Annotation annotation : annotations) {
            if (annotation.getDescription().contains(description)) {
                return annotation;
            }
        }
        return null;
    }
}
