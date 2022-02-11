package kodlamaio.HRMS.dto.mapper;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DtoConverterManager implements DtoConverterService{

    private ModelMapper modelMapper;

    @Override
    public <S, T> List<T> dtoConverter(List<S> source, Class<T> targetClass){
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    @Override
    public <T> Object dtoClassConverter(Object source,Class<T> baseClass) {
        return modelMapper.map(source,baseClass);
    }
}
