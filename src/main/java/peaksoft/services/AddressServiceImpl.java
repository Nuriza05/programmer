package peaksoft.services;

import peaksoft.entity.Address;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.AddressRepositoryImpl;

import java.util.List;

/**
 * @created : Lenovo Nuriza
 **/
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRep = new AddressRepositoryImpl();
    @Override
    public Address saveAddress(Address address, Long id) {
       return addressRep.saveAddress(address, id);
    }

    @Override
    public String saveAddresses(List<Address> addresses, Long id) {
        return addressRep.saveAddresses(addresses, id);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRep.getAllAddresses();
    }

    @Override
    public Address findById(Long id) {
        return addressRep.findById(id);
    }

    @Override
    public String removeById(Long id) {
        return addressRep.removeById(id);
    }

    @Override
    public String removeAllAddresses() {
        return addressRep.removeAllAddresses();
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        return addressRep.updateAddress(id,address);
    }
}
