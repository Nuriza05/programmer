package peaksoft.services;

import peaksoft.entity.Programmer;
import peaksoft.enums.Country;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface ProgrammerService {
    //WithAddress
    Programmer saveProgrammer(Programmer programmer,Long id);
    String saveProgrammers(List<Programmer> programmers, Long id);
    void addConstraintToEmail();
    List<Programmer> getAllProgrammers();
    Programmer findById(Long id);
    String deleteById(Long id);
    String deleteAllProgrammers();
    Programmer updateProgrammer(Long id, Programmer programmer);
    int getProgrammersWithSameCountry(Country countryName);
    //Age and name
    Programmer findTheYoungestProgrammer();
    Programmer findTheOldestProgrammer();

}
