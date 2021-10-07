package kodlamaio.HRMS.core.services.converter;

import java.util.List;

public interface DtoConverterService {
    <S, T> List<T> dtoConverter(List<S> source, Class<T> targetClass);
    public <T> Object dtoClassConverter(Object source,Class<T> baseClass);
}