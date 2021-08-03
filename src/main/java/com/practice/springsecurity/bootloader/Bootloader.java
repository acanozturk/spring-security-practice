package com.practice.springsecurity.bootloader;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.entities.UserRole;
import com.practice.springsecurity.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class Bootloader implements CommandLineRunner {

    private static final int ENTITY_COUNT = 50;

    private final MockNeat mockNeat = MockNeat.threadLocal();
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setRole(UserRole.ADMIN);

        customerRepository.save(admin);
    }

    private void customerLoader() {
        for(int i=1; i<ENTITY_COUNT; i++) {
            final Customer customer = new Customer();
            final String email = "user" + i + "@user.com";
            final String password = "user" + i;

            customer.setFirstName(mockNeat.names().first().valStr());
            customer.setLastName(mockNeat.names().last().valStr());
            customer.setEmail(email);
            customer.setPassword(bCryptPasswordEncoder.encode(password));
            customer.setRole(UserRole.USER);

            customerRepository.save(customer);
        }
    }
}
