package peaksoft.services;

import peaksoft.entity.Country;
import peaksoft.repository.CountryRepository;
import peaksoft.repository.CountryRepositoryImpl;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class CountryServiceImpl implements CountryService{
    CountryRepository countryRep = new CountryRepositoryImpl();
    @Override
    public Country saveCountry(Country country) {
        return countryRep.saveCountry(country);
    }

    @Override
    public String saveCountries(List<Country> countries) {
        return countryRep.saveCountries(countries);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRep.getAllCountries();
    }

    @Override
    public Country findCountryById(Long id) {
        return countryRep.findCountryById(id);
    }

    @Override
    public String deleteCountryById(Long id) {
        return countryRep.deleteCountryById(id);
    }

    @Override
    public String removeAllCountries() {
        return countryRep.removeAllCountries();
    }

    @Override
    public List<Country> findTheLongestDescription() {
        return countryRep.findTheLongestDescription();
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        return countryRep.updateCountry(id,country);
    }

    @Override
    public int CountProgrammerInSameCountry(peaksoft.enums.Country countryName) {
        return countryRep.CountProgrammerInSameCountry(countryName);
    }
}
