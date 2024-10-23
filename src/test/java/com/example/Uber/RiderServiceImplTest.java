package com.example.Uber;

import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.model.Rider;
import com.example.Uber.repository.RiderRepository;
import com.example.Uber.service.Implementation.RiderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RiderServiceImplTest {

    @Mock
    private RiderRepository riderRepository;

    @InjectMocks
    private RiderServiceImpl riderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    void testSaveRider() {
        // Arrange: Create a SaveRiderDto object with required fields
        SaveRiderDto saveRiderDto = SaveRiderDto.builder()
                .firstName("John")
                .lastName("Smith")
                .phoneNumber("1234567890")
                .email("john.smith@example.com")
                .build();

        // Create a mock Rider entity
        Rider rider = Rider.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Smith")
                .phoneNumber("1234567890")
                .email("john.smith@example.com")
                .build();

        // Mock repository's save method
        when(riderRepository.save(any(Rider.class))).thenReturn(rider);

        // Act: Call the save method
        RiderDto savedRiderDto = riderService.save(saveRiderDto);

        // Assert: Verify the returned RiderDto
        assertNotNull(savedRiderDto);
        assertEquals("John", savedRiderDto.getFirstName());
        assertEquals("Smith", savedRiderDto.getLastName());
        assertEquals("1234567890", savedRiderDto.getPhoneNumber());
        assertEquals("john.smith@example.com", savedRiderDto.getEmail());
    }

}

