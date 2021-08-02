package com.practice.springsecurity.bootloader;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.entities.UserRole;
import com.practice.springsecurity.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class Bootloader implements CommandLineRunner {

    private static final int ENTITY_COUNT = 100;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        adminLoader();
        customerLoader();
        log.info("Bootloader successful.");
    }

    private void adminLoader() {
        final Customer admin = new Customer();

        admin.setFirstName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@admin.com");
        admin.setPassword("admin");
        admin.setRole(UserRole.ADMIN);

        customerRepository.save(admin);
    }

    private void customerLoader() {
        for(int i=0; i<ENTITY_COUNT; i++) {
            final Customer customer = new Customer();

            customer.setFirstName(mockNeat.names().first().valStr());
            customer.setLastName(mockNeat.names().last().valStr());
            customer.setEmail(mockNeat.emails().valStr());
            customer.setPassword(mockNeat.passwords().valStr());
            customer.setRole(UserRole.USER);

            customerRepository.save(customer);
        }
    }
}
