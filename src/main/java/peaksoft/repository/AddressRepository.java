package peaksoft.repository;

import peaksoft.entity.Address;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public interface AddressRepository {
    Address saveAddress(Address address, Long id);
    //SaveWithCountry
    String saveAddresses(List<Address> addresses, Long id);
    List<Address> getAllAddresses();
    Address findById(Long id);
    String removeById(Long id);
    String removeAllAddresses();
    Address updateAddress(Long id, Address address);

}
