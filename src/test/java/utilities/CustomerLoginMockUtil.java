package utilities;

import com.flsoft.bankxp.edge.entities.model.*;

import java.util.ArrayList;
import java.util.Date;

public class CustomerLoginMockUtil {

    public static CustomerLogin mockCustomerLogin() {
        CustomerLogin customerLogin = new CustomerLogin();

        customerLogin.setId(1L);
        customerLogin.setUsername("9860465427");
        customerLogin.setPassword("$2a$12$lszC6Q2FCT1NiUx.OG9BWeYmWLyQpZvZHHdYeOSH86QuOYpbTPxra");
        customerLogin.setTxnPassword("$2a$12$tW7du5g4ecN7Xc7sRJuo7.wFvxrzU.kR4gmNWrHj6JmzJdezvCy8C");
        customerLogin.setActive('Y');
        customerLogin.setPasswordFlag("PA");
        customerLogin.setCustomerId(1L);
        customerLogin.setCustomerDelete('N');
        customerLogin.setLatestChangedUsername("");
        customerLogin.setApplicationPattern(new ApplicationPattern());
        customerLogin.setIsInitialPassword('N');
        customerLogin.setIsInitialTxnPassword('N');
        customerLogin.setLastLoginPasswordChanged(new Date());
        customerLogin.setLastTxnPasswordChanged(new Date());
        customerLogin.setIsPrimary('Y');
        customerLogin.setLoginAccessChannels(new ArrayList<LoginAccessChannel>());
        customerLogin.setLastForgotPasswordChanged(new Date());
        customerLogin.setAddedBy(new ApplicationUser());
        customerLogin.setAddedDate(new Date());
        customerLogin.setLastModifiedBy(new ApplicationUser());
        customerLogin.setLastModifiedDate(new Date());
        customerLogin.setHasTermsAccepted('Y');
        customerLogin.setActivationDate(new Date());
        customerLogin.setFirstLoginDate(new Date());
        customerLogin.setCustomer(CustomerMockUtil.mockCustomer(customerLogin));

        return customerLogin;
    }
}
