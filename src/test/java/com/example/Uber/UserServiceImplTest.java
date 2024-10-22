package com.example.Uber;

import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;
import com.example.Uber.model.User;
import com.example.Uber.repository.UserRepository;
import com.example.Uber.service.Implementation.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    void testSaveUser() {
        // Arrange: Create a SaveUserDto object with all required fields
        SaveUserDto saveUserDto = SaveUserDto.builder()
                .image("image-url")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("1234567890")
                .email("john.doe@example.com")
                .build();

        UUID mockUUID = UUID.randomUUID();

        // Mock the User entity that will be saved in the repository
        User user = User.builder()
                .id(mockUUID)  // Assuming the UUID is auto-generated
                .image("image-url")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("1234567890")
                .email("john.doe@example.com")
                .build();

        // Mock repository's save method to return the User object
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act: Call the save method
        UserDto savedUserDto = userService.save(saveUserDto);

        // Assert: Verify that the returned UserDto matches the expected values
        assertNotNull(savedUserDto);  // Ensure the object is not null
        assertEquals("John", savedUserDto.getFirstName());
        assertEquals("Doe", savedUserDto.getLastName());
        assertEquals("image-url", savedUserDto.getImage());
        assertEquals("1234567890", savedUserDto.getPhoneNumber());
        assertEquals("john.doe@example.com", savedUserDto.getEmail());
    }

    @Test
    void testGetAllUsers() {
        // Arrange: Create a list of User objects
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        User user1 = User.builder()
                .id(uuid1)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("1234567890")
                .email("john.doe@example.com")
                .image("image-url-1")
                .build();

        User user2 = User.builder()
                .id(uuid2)
                .firstName("Jane")
                .lastName("Doe")
                .phoneNumber("0987654321")
                .email("jane.doe@example.com")
                .image("image-url-2")
                .build();

        List<User> users = Arrays.asList(user1, user2);
        Page<User> page = new PageImpl<>(users); // Simulate a paginated result

        Pageable pageable = PageRequest.of(0, 2);
        when(userRepository.findAll(pageable)).thenReturn(page);

        // Act: Call the getAllUsers method
        List<UserDto> userDtos = userService.getAllUsers(0, 2);

        // Assert: Verify the results
        assertNotNull(userDtos); // Check the list is not null
        assertEquals(2, userDtos.size()); // Check the number of users

        // Verify details of the first user
        UserDto userDto1 = userDtos.get(0);
        assertEquals("John", userDto1.getFirstName());
        assertEquals("Doe", userDto1.getLastName());
        assertEquals("john.doe@example.com", userDto1.getEmail());
        assertEquals("image-url-1", userDto1.getImage());
        assertEquals("1234567890", userDto1.getPhoneNumber());

        // Verify details of the second user
        UserDto userDto2 = userDtos.get(1);
        assertEquals("Jane", userDto2.getFirstName());
        assertEquals("Doe", userDto2.getLastName());
        assertEquals("jane.doe@example.com", userDto2.getEmail());
        assertEquals("image-url-2", userDto2.getImage());
        assertEquals("0987654321", userDto2.getPhoneNumber());
    }

}
