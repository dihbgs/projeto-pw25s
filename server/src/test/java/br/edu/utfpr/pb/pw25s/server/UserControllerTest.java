package br.edu.utfpr.pb.pw25s.server;

import br.edu.utfpr.pb.pw25s.server.model.User;
import br.edu.utfpr.pb.pw25s.server.error.APIError;
import br.edu.utfpr.pb.pw25s.server.shared.GenericResponse;
import br.edu.utfpr.pb.pw25s.server.repository.UserRepository;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {

    private static final String API_USERS = "/users";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void cleanup() {
        userRepository.deleteAll();
        testRestTemplate.getRestTemplate().getInterceptors().clear();
    }

    @Test
    @DisplayName("Post user - Whend user is valid - Receive OK")
    public void postUser_whenUserIsValid_receiveOk() {
        User user = createValidUser();

        ResponseEntity<Object> response = testRestTemplate.postForEntity(API_USERS, user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DisplayName("Post user - Whend user is valid - User saved to database")
    public void postUser_whenUserIsValid_userSavedToDatabase() {
        User user = createValidUser();

        testRestTemplate.postForEntity(API_USERS, user, Object.class);

        assertThat(userRepository.count()).isEqualTo(1);
    }

    @Test
    @DisplayName("Post user - Whend user is valid - Receive succed message")
    public void postUser_whenUserIsValid_receiveSuccedMessage() {
        User user = createValidUser();

        ResponseEntity<GenericResponse> response = testRestTemplate.postForEntity(API_USERS, user,
                GenericResponse.class);

        assertThat(response.getBody().getMessage()).isNotNull();
    }

    @Test
    @DisplayName("Post user - Whend user is valid - Password is hashed in database")
    public void postUser_whenUserIsValid_passwordIsHashedInDatabase() {
        User user = createValidUser();

        testRestTemplate.postForEntity(API_USERS, user, Object.class);

        List<User> users = userRepository.findAll();

        User userDB = users.get(0);

        assertThat(userDB.getPassword()).isNotEqualTo(user.getPassword());
    }

    @Test
    public void postUser_whenUserHasNullUsername_receiveBadRequest() {
        User user = createValidUser();
        user.setName(null);
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_whenUserHasNullPassword_receiveBadRequest() {
        User user = createValidUser();
        user.setPassword(null);
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_whenUserUsernameWithLessThanRequired_receiveBadRequest() {
        User user = createValidUser();
        user.setName("abc");
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_whenUserUsernameExceedsTheLengthLimit_receiveBadRequest() {
        User user = createValidUser();
        String usernameWith256Chars = IntStream.rangeClosed(1, 256).mapToObj(x -> "a")
                .collect(Collectors.joining());
        user.setName(usernameWith256Chars);
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_whenUserHasPasswordAllLowercase_receiveBadRequest() {
        User user = createValidUser();
        user.setPassword("password");
        ResponseEntity<Object> response = postSignUp(user, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postUser_whenUserIsInvalid_receiveAPIError() {
        User user = new User();
        ResponseEntity<APIError> response = postSignUp(user, APIError.class);
        assertThat(response.getBody().getUrl()).isEqualTo(API_USERS);
    }

    private User createValidUser() {
        User user = new User();

        user.setName("test-user");
        user.setDisplayName("test-display");
        user.setPassword("P4ssword");

        return user;
    }

    private <T> ResponseEntity<T> postSignUp(Object request, Class<T> responseType) {
        return testRestTemplate.postForEntity(API_USERS, request, responseType);
    }
}