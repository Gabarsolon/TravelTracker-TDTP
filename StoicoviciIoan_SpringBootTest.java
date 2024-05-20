package com.bucketlist;

import com.bucketlist.destinations.model.Destination;
import com.bucketlist.destinations.repository.DestinationRepository;
import com.bucketlist.destinations.service.DestinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MainTests {

    @Mock
    private DestinationRepository destinationRepository;

    @InjectMocks
    private DestinationService destinationService;

    private List<Destination> mockDestinations;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockDestinations = createMockDestinations(100);
    }

    @Test
    public void testGetAllDestinations_LowerBoundaryPageNumber() {
        int pageNumber = 0;
        int pageSize = 100;
        setUpMockFindAll();

        List<Destination> result = destinationService.getAllDestinations(pageNumber, pageSize);
        assertEquals(mockDestinations.subList(0, pageSize), result);
    }

    @Test
    public void testGetAllDestinations_UpperBoundaryPageNumber() {
        int pageNumber = 100;
        int pageSize = 1;
        setUpMockFindAll();

        List<Destination> result = destinationService.getAllDestinations(pageNumber, pageSize);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testGetAllDestinations_LowerBoundaryPageSize() {
        int pageNumber = 0;
        int pageSize = 1;
        setUpMockFindAll();

        List<Destination> result = destinationService.getAllDestinations(pageNumber, pageSize);
        assertEquals(mockDestinations.subList(pageNumber, pageNumber + pageSize), result);
    }

    @Test
    public void testGetAllDestinations_UpperBoundaryPageSize() {
        int pageNumber = 1;
        int pageSize = 100;
        setUpMockFindAll();

        List<Destination> result = destinationService.getAllDestinations(pageNumber, pageSize);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testGetAllDestinations_NegativeBoundaryPageNumber() {
        int pageNumber = -1;
        int pageSize = 10;

        assertThrows(IllegalArgumentException.class, () -> {
            destinationService.getAllDestinations(pageNumber, pageSize);
        });
    }

    @Test
    public void testGetAllDestinations_ZeroBoundaryPageSize() {
        int pageNumber = 1;
        int pageSize = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            destinationService.getAllDestinations(pageNumber, pageSize);
        });
    }

	@Test
    public void testGetAllDestinations_OverTheTopBoundaryPageNumber() {
        int pageNumber = Integer.MAX_VALUE;
        int pageSize = 10;

        assertThrows(NullPointerException.class, () -> {
            destinationService.getAllDestinations(pageNumber, pageSize);
        });
    }

    @Test
    public void testGetAllDestinations_OverTheTopBoundaryPageSize() {
        int pageNumber = 1;
        int pageSize = Integer.MAX_VALUE;

        assertThrows(NullPointerException.class, () -> {
            destinationService.getAllDestinations(pageNumber, pageSize);
        });
    }

    private void setUpMockFindAll() {
        when(destinationRepository.findAll(any(PageRequest.class))).thenAnswer(invocation -> {
            PageRequest pageRequest = invocation.getArgument(0);
            int start = (int) pageRequest.getOffset();
            int end = Math.min((start + pageRequest.getPageSize()), mockDestinations.size());
            return new PageImpl<>(mockDestinations.subList(start, end), pageRequest, mockDestinations.size());
        });
    }

    private List<Destination> createMockDestinations(int count) {
        List<Destination> destinations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Destination destination = new Destination((long) i, "Country " + i, "City " + i, true, "Destination " + i, "Description " + i);
            destinations.add(destination);
        }
        return destinations;
    }
}