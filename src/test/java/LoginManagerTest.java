import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginManagerTest {
    @Mock
    AuthenticationService authenticationService;

    @InjectMocks
    LoginManager loginManager;


    @Test
    void testValidAuthentication(){
        when(authenticationService.authenticate("shagor", "password")).thenReturn(true);

        assertTrue(authenticationService.authenticate("shagor", "password"));

        verify(authenticationService).authenticate("shagor", "password");
    }

    @Test
    void testInvalidAuthentication(){
        when(authenticationService.authenticate("mh", "password")).thenReturn(false);

        assertFalse(authenticationService.authenticate("mh", "password"));

        verify(authenticationService).authenticate("mh", "password");
    }

    @Test
    void testLoginThrowsExceptionWhenUsernameOrPasswordIsNull() {
        assertThrows(Exception.class, () -> loginManager.login(null, null));
    }

}