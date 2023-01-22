//package org.example.repository;
//
//import org.example.entity.Customer;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class CustomerRepositoryTest {
//
//    private CustomerRepository customerRepository;
//    private TestEntityManager entityManager;
//
//    @Test
//    public void testCreateCustomer() {
//        Customer customer = new Customer();
//        customer.setName("Vladeta");
//        customer.setAddress("Alba");
//        customer.setPhoneNumber("0333655584");
//
//        Customer savedCustomer = customerRepository.save(customer);
//        Customer existCustomer = entityManager.find(Customer.class, savedCustomer.getId());
//        assertThat(existCustomer.getName().equals(customer.getName()));
//
//    }
//
//    @Test
//    public void testFindByName() {
//        String name = "Paul";
//
//        Customer customer = customerRepository.findByName(name);
//        assertThat(customer).isNotNull();
//    }
//
//}
