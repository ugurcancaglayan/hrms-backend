package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.model.City;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
}
