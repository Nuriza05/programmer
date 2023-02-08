package peaksoft.repository;

import peaksoft.entity.Programmer;
import peaksoft.entity.Project;
import peaksoft.enums.Country;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface ProgrammerRepository {
    //WithAddress
    Programmer saveProgrammer(Programmer programmer, Long id);
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
