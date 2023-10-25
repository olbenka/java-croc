package six;

import six.figures.Circle;
import six.figures.Rectangle;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4,4, 2);
        Rectangle rectangle = new Rectangle(1,6,1,6);
        //Annotation one = new Annotation(circle, "first");
        //Annotation two = new Annotation(rectangle, "second");
        //System.out.println(one.toString());
        //System.out.println(two.toString());
        Annotation[] arr = new Annotation[2];
        arr[0] = new Annotation(circle, "first");
        arr[1] = new Annotation(rectangle, "second");
        AnnotatedImage ai = new AnnotatedImage("jndhjfh", arr);
        if (ai.findByDescription("first") != null){
            System.out.println(ai.findByDescription("first").toString());
        }
        if (ai.findByPoint(2,2) != null){
            System.out.println(ai.findByPoint(2,2).toString());
        }

    }
}
