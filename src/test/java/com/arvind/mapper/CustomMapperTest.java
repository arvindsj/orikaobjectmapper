package com.arvind.mapper;

import com.arvind.mapperfactory.ObjectMapperFactory;
import com.arvind.pojo.Address;
import com.arvind.pojo.AddressDTO;
import com.arvind.pojo.Country;
import ma.glasnost.orika.MapperFacade;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jan on 12/17/16.
 */
public class CustomMapperTest {
    MapperFacade mapper;

    @Test
    public void testNestedObjectProperty() {
        Address address = getAddress();
        AddressDTO addressDTO = new AddressDTO();
        mapper = ObjectMapperFactory.getMapper(address, addressDTO, getFieldMappers());
        AddressDTO newAddress = mapper.map(address, AddressDTO.class);
        Assert.assertSame("UnitedStates", newAddress.getCountryName());
    }

    private static Address getAddress() {
        Address address = new Address();
        List<String> newList = new ArrayList<>();
        newList.add("airforceone");
        address.setAddressLine1("1600 Amphitheatre Parkway");
        address.setAddressLine2("12");
        address.setCity("Mountain View, CA");
        address.setPostCode("94043");
        Country country = new Country();
        country.setName("UnitedStates");
        address.setCountry(country);
        address.setCheckList(newList);
        return address;
    }

    private static Map<String, String> getFieldMappers() {
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("addressLine1", "addressLine1");
        fieldMap.put("addressLine2", "addressLine2");
        fieldMap.put("country.name", "countryName");
        fieldMap.put("checkList", "checkList");
        return fieldMap;
    }
}