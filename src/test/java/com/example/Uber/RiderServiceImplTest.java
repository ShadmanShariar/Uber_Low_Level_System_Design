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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
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

    @Test
    void testGetAllRiders() {
        // Arrange: Create mock Rider entities
        Rider rider1 = Rider.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Smith")
                .phoneNumber("1234567890")
                .email("john.smith@example.com")
                .build();

        Rider rider2 = Rider.builder()
                .id(UUID.randomUUID())
                .firstName("Jane")
                .lastName("Doe")
                .phoneNumber("0987654321")
                .email("jane.doe@example.com")
                .build();

        List<Rider> riders = Arrays.asList(rider1, rider2);
        Page<Rider> page = new PageImpl<>(riders);

        // Create Pageable object
        Pageable pageable = PageRequest.of(0, 2);

        // Mock repository's findAll method
        when(riderRepository.findAll(pageable)).thenReturn(page);

        // Act: Call the getAllRiders method
        List<RiderDto> riderDtos = riderService.getAllRiders(0, 2);

        // Assert: Verify the results
        assertNotNull(riderDtos);
        assertEquals(2, riderDtos.size());

        // Verify first rider details
        RiderDto riderDto1 = riderDtos.get(0);
        assertEquals("John", riderDto1.getFirstName());
        assertEquals("Smith", riderDto1.getLastName());
        assertEquals("1234567890", riderDto1.getPhoneNumber());
        assertEquals("john.smith@example.com", riderDto1.getEmail());

        // Verify second rider details
        RiderDto riderDto2 = riderDtos.get(1);
        assertEquals("Jane", riderDto2.getFirstName());
        assertEquals("Doe", riderDto2.getLastName());
        assertEquals("0987654321", riderDto2.getPhoneNumber());
        assertEquals("jane.doe@example.com", riderDto2.getEmail());
    }
}

