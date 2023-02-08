package peaksoft.services;

import peaksoft.entity.Country;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface CountryService {
    Country saveCountry(Country country);
    String saveCountries(List<Country> countries);
    List<Country> getAllCountries();
    Country findCountryById(Long id);
    String deleteCountryById(Long id);
    String removeAllCountries();
    List<Country> findTheLongestDescription();
    Country updateCountry(Long id, Country country);
    int CountProgrammerInSameCountry(peaksoft.enums.Country countryName);
}
