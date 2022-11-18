import org.pieuler.domain.Book;
import org.pieuler.domain.ProxyBuilder;
import org.pieuler.domain.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(ProxyBuilder.builder(User.class));
        System.out.println(ProxyBuilder.builder(Book.class));
    }
}