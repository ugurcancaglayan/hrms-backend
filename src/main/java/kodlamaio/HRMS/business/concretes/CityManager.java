package kodlamaio.HRMS.business.concretes;

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.dataAccess.abstracts.CityDao;
import kodlamaio.HRMS.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(this.cityDao.findAll(),
                "Cities listed successfully.");
    }
}
