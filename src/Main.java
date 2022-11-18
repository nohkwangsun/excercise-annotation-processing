import org.pieuler.domain.Book;
import org.pieuler.domain.ProxyBuilder;
import org.pieuler.domain.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(ProxyBuilder.builder(User.class));
        System.out.println(ProxyBuilder.builder(Book.class));

        /**
         * refs.
         * https://medium.com/@joachim.beckers/debugging-an-annotation-processor-using-intellij-idea-in-2018-cde72758b78a
         * https://hannesdorfmann.com/annotation-processing/annotationprocessing101/
         * https://www.javacodegeeks.com/2015/09/java-annotation-processors.html
         * https://www.baeldung.com/java-annotation-processing-builder
         * https://www.youtube.com/playlist?list=PLQH14oBwDThItQZa8S9r_Tcc3cADt7Fq_
         */
    }
}