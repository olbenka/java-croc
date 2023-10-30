package six;

import six.figures.Circle;
import six.figures.Rectangle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4,4, 2);
        Rectangle rectangle = new Rectangle(1,6,1,6);
        AnnotatedImage ai = new AnnotatedImage("jndhjfh",
                new Annotation(circle, "first"), new Annotation(rectangle, "second"));
        if (ai.findByDescription("first") != null){
            System.out.println(ai.findByDescription("first").toString());
        }
        if (ai.findByPoint(2,2) != null){
            System.out.println(ai.findByPoint(2,2).toString());
        }

        for (Annotation annotation : ai.getAnnotations()){
            System.out.println("До move: ");
            System.out.println(annotation.toString());
            annotation.getFigure().move(4,4);
            System.out.println("После move: ");
            System.out.println(annotation.toString());
        }




    }
}
