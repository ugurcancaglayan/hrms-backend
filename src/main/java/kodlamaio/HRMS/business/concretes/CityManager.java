package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.repository.CityDao;
import kodlamaio.HRMS.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityManager implements CityService {

    private final CityDao cityDao;

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(this.cityDao.findAll(),
                "Cities listed successfully.");
    }
}
