package kodlamaio.HRMS.dto.mapper;

import java.util.List;

public interface DtoConverterService {
    <S, T> List<T> dtoConverter(List<S> source, Class<T> targetClass);
    public <T> Object dtoClassConverter(Object source,Class<T> baseClass);
}