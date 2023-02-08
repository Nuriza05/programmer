package peaksoft.services;

import peaksoft.entity.Programmer;
import peaksoft.enums.Country;
import peaksoft.repository.ProgrammerRepository;
import peaksoft.repository.ProgrammerRepositoryImpl;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class ProgrammerServiceImpl implements ProgrammerService{
    ProgrammerRepository programmerRep = new ProgrammerRepositoryImpl();
    @Override
    public Programmer saveProgrammer(Programmer programmer, Long id) {
        return programmerRep.saveProgrammer(programmer, id);
    }

    @Override
    public String saveProgrammers(List<Programmer> programmers, Long id) {
        return programmerRep.saveProgrammers(programmers, id);
    }

    @Override
    public void addConstraintToEmail() {
       programmerRep.addConstraintToEmail();
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        return programmerRep.getAllProgrammers();
    }

    @Override
    public Programmer findById(Long id) {
        return programmerRep.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return programmerRep.deleteById(id);
    }

    @Override
    public String deleteAllProgrammers() {
        return programmerRep.deleteAllProgrammers();
    }

    @Override
    public Programmer updateProgrammer(Long id, Programmer programmer) {
        return programmerRep.updateProgrammer(id,programmer);
    }

    @Override
    public int getProgrammersWithSameCountry(Country countryName) {
        return programmerRep.getProgrammersWithSameCountry(countryName);
    }

    @Override
    public Programmer findTheYoungestProgrammer() {
        return programmerRep.findTheYoungestProgrammer();
    }

    @Override
    public Programmer findTheOldestProgrammer() {
        return programmerRep.findTheOldestProgrammer();
    }
}
