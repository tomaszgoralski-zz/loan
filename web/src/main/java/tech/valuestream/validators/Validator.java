package tech.valuestream.validators;

/**
 * Created by goralskt on 2017-04-27.
 */
public interface Validator<T> {
    boolean isValid(T t);
}
