package kodlamaio.HRMS.controller;

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.model.City;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/city/")
@CrossOrigin
public class CityController {

    private final CityService cityService;

    @GetMapping("getAll")
    public DataResult<List<City>> getAll( ) {
        return this.cityService.getAll();
    }
}
