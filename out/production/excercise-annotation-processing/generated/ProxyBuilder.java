package org.pieuler.domain;
public class ProxyBuilder {
    public static <T> T builder(Class<T> clazz) {
        if (clazz.isAssignableFrom(User.class)) {
            return clazz.cast(new User());
        }
        if (clazz.isAssignableFrom(Book.class)) {
            return clazz.cast(new Book());
        }
        if (clazz.isAssignableFrom(Todo.class)) {
            return clazz.cast(new Todo());
        }
        throw new RuntimeException("Unsupported Type");
    }
}
