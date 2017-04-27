package tech.valuestream.converters;

/**
 * Created by goralskt on 2017-04-27.
 */
public interface Converter<M,D> {
    D convertToDTO(M m);
    M convertToModel(D d);
}
