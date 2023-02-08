package peaksoft;
import peaksoft.entity.Address;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;
import peaksoft.enums.Country;
import peaksoft.enums.Status;
import peaksoft.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        AddressService address = new AddressServiceImpl();
        CountryService country = new CountryServiceImpl();
       ProjectService project =  new ProjectServiceImpl();
        ProgrammerService programmer = new ProgrammerServiceImpl();
//        int number = new Scanner(System.in).nextInt();
//        switch (number){
//            case 1 -> System.out.println(country.saveCountry(new Country(peaksoft.enums.Country.Kyrgyzstan, "Beautiful")));
//            case 2 -> System.out.println(country.saveCountries(new ArrayList<>(Arrays.asList(new Country(peaksoft.enums.Country.USA, "Popular"), new Country(peaksoft.enums.Country.Russia, "Big"), new Country()))));
//
//            System.out.println(country.getAllCountries());
//
//           System.out.println(country.findCountryById(202L));
//         System.out.println(country.deleteCountryById(202L));
//           System.out.println(country.removeAllCountries());
//            case 7 -> System.out.println(country.findTheLongestDescription());
//           System.out.println(country.updateCountry(152L, new Country(peaksoft.enums.Country.Russia, "Big")));
//             System.out.println(country.CountProgrammerInSameCountry(Country.Russia));

//        System.out.println(address.saveAddress(new Address("Nooken", "Abdykadyrov", 23), 153L));
//        System.out.println(address.saveAddresses(new ArrayList<>(Arrays.asList(new Address("Aksy","Mamatov",12), new Address("Talas","Askarov",32), new Address("Lenin","Ashyrbaev",21))), 152L));
//        System.out.println(address.getAllAddresses());
//        System.out.println(address.findById(2L));
//        System.out.println(address.removeById(2L));
//        System.out.println(address.removeAllAddresses());
//        System.out.println(address.updateAddress(9L, new Address("Alamedin", "Leninskoye", 22)));

       // System.out.println(programmer.saveProgrammer(new Programmer("Nuriza Muratova", "nuriz@", LocalDate.of(2005, 2, 2), Status.Owner), 9L));
  //      System.out.println(programmer.saveProgrammers(new ArrayList<>(Arrays.asList(new Programmer("Asel", "asel@", LocalDate.of(2003, 3, 2), Status.Collaborator), new Programmer("Alibek", "ali@", LocalDate.of(2000, 3, 2), Status.Owner))), 10L));
//   programmer.addConstraintToEmail();
       // System.out.println(programmer.deleteAllProgrammers());
//        System.out.println(programmer.getAllProgrammers());
//        System.out.println(programmer.findById(10L));
//        System.out.println(programmer.deleteAllProgrammers());
     //   System.out.println(programmer.updateProgrammer(12L, new Programmer("Eliz", "eliz@", LocalDate.of(1999, 2, 2), Status.Owner)));
//        System.out.println(programmer.getProgrammersWithSameCountry(Country.Russia));
//        System.out.println(programmer.findTheYoungestProgrammer());
//        System.out.println(programmer.findTheOldestProgrammer());

        //      System.out.println(project.saveProject(new Project("Task", "long", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1), 3000)));
//        System.out.println(project.findById(1L));
//        System.out.println(project.removeById(1L));
 //       System.out.println(project.updateProject(1L, new Project("TAsks", "descr", LocalDate.of(2010, 2, 2), LocalDate.of(2012, 3, 4), 1111)));
   //     System.out.println(project.assignProgrammerToProject(12L, 2L));
//        System.out.println(project.findTheBestExpensiveProject());
//        System.out.println(project.findTheFastWrittenProject());


    }


//
//

    }

