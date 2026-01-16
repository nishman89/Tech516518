package com.sparta.northwindapi;

import com.sparta.northwindapi.dtos.CustomerDTO;
import com.sparta.northwindapi.dtos.CustomerMapper;
import com.sparta.northwindapi.entities.Customer;
import com.sparta.northwindapi.repositories.CustomerRepository;
import com.sparta.northwindapi.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceTests {

    private final CustomerRepository mockRepository = Mockito.mock(CustomerRepository.class);
    private final CustomerMapper customerMapper = Mockito.mock(CustomerMapper.class);
    private final CustomerService sut = new CustomerService(mockRepository,customerMapper);

     // Dummies
    @Test
    @DisplayName("Ensure CustomerService is constructed correctly")
    public void constructServiceTest(){
        Assertions.assertInstanceOf(CustomerService.class, sut);
    }

    @Test
    @DisplayName("Constructor should throw exception with null repository")
    public void constructorWithNullRepositoryTest(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new CustomerService(null, null));
    }

    // Stubs
    @Test
    @DisplayName("Get All Customer Test")
    public void getAllCustomersTest(){
        // Arrange
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setCustomerID("MANDA");
        Customer customer2 = new Customer();
        customer2.setCustomerID("WINDR");
        customers.add(customer1);
        customers.add(customer2);


        CustomerDTO customerDto1 = new CustomerDTO();
        customerDto1.setCustomerID("MANDA");
        CustomerDTO customerDto2 = new CustomerDTO();
        customerDto2.setCustomerID("WINDR");

        Mockito.when(customerMapper.toDTO(customer1)).thenReturn(customerDto1);
        Mockito.when(customerMapper.toDTO(customer2)).thenReturn(customerDto2);
        //// Define mock behaviour
        Mockito.when(mockRepository.findAll()).thenReturn(customers);
        // Act
        List<CustomerDTO> result = sut.getAllCustomers();
        //Assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.get(0).getCustomerID().equals("MANDA"));
        Assertions.assertTrue(result.get(1).getCustomerID().equals("WINDR"));
    }


//    @Test
//    @DisplayName("Get Customer Happy Path")
//    public void getCustomerTest() {
//        Customer customer = new Customer();
//        customer.setCustomerID("MANDA");
//        customer.setCity("Birmingham");
//        customer.setCompanyName("Sparta Global");
//        customer.setContactName("Nish Mandal");
//
//        Mockito.when(mockRepository.findById("MANDA")).thenReturn(java.util.Optional.of(customer));
//
//        Customer result = sut.getCustomerByID("MANDA");
//
//        Assertions.assertNotNull(result, "Customer should not be null");
//        Assertions.assertEquals("MANDA", result.getCustomerID(), "Customer ID should match");
//    }
//
//    @Test
//    @DisplayName("Get Customer Unhappy Path - no such element exception")
//    public void findCustomerUnhappyPathTest() {
//        Mockito.when(mockRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
//        Assertions.assertThrows(NoSuchElementException.class, () -> sut.getCustomerByID("MANDA"));
//    }
//    @Test
//    @DisplayName("Save Customer Happy Path")
//    public void saveCustomerHappyPathTest() {
//        Customer customer = new Customer();
//        customer.setCustomerID("MANDA");
//        customer.setCity("Birmingham");
//        customer.setCompanyName("Sparta Global");
//        customer.setContactName("Nish Mandal");
//
//        Mockito.when(mockRepository.save(customer)).thenReturn(customer);
//
//        Customer savedCustomer = sut.saveCustomer(customer);
//
//        Assertions.assertNotNull(savedCustomer, "The saved customer should not be null");
//        Assertions.assertEquals("MANDA", savedCustomer.getCustomerID(), "Customer ID should match");
//    }
//    @Test
//    @DisplayName("Check findById is called once")
//    void checkFindByIdIsCalledOnceOnRepository() {
//        sut.getCustomerByID("TEST");
//        Mockito.verify(mockRepository).findById(Mockito.anyString());
//        // Mockito.verify(mockRepository, Mockito.times(1)).findById(Mockito.anyString());
//    }
//    @Test
//    @DisplayName("Delete Customer Happy Path")
//    public void deleteCustomerHappyPathTest() {
//        Mockito.when(mockRepository.existsById("MANDA")).thenReturn(true);
//
//        boolean result = sut.deleteCustomer("MANDA");
//
//        Assertions.assertTrue(result, "The customer should be deleted successfully");
//        Mockito.verify(mockRepository, Mockito.times(1)).deleteById("MANDA");
//    }
//
//    @Test
//    @DisplayName("Test correct parameter passed")
//    void testCorrectParameterPassed() {
//        Customer customer = new Customer();
//        customer.setCustomerID("CATHY");
//        customer.setCompanyName("Sparta Global");
//
//        sut.saveCustomer(customer);
//        Mockito.verify(mockRepository).save(customer);
//        Mockito.verifyNoMoreInteractions(mockRepository);
//    }

}
