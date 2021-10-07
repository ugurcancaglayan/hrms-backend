package kodlamaio.HRMS.core.services.converter;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtoConverterManager implements DtoConverterService{

    private ModelMapper modelMapper;

    @Autowired
    public DtoConverterManager() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public <S, T> List<T> dtoConverter(List<S> source, Class<T> targetClass){
        return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
    }

    @Override
    public <T> Object dtoClassConverter(Object source,Class<T> baseClass) {
        return modelMapper.map(source,baseClass);
    }
}
