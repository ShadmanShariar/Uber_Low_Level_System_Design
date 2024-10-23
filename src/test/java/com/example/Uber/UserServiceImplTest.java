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

}
