package com.example.services;

import com.example.models.Book;
import com.example.models.Reservation;
import com.example.models.User;
import com.example.repositories.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    private User user;
    private Book book;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("testUser");

        book = new Book();
        book.setTitle("Test Book");
    }

    @Test
    void testCreateReservation() {
        Reservation reservation = new Reservation(user, book);

        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation savedReservation = reservationService.createReservation(user, book);

        assertNotNull(savedReservation);
        assertEquals(user, savedReservation.getUser());
        assertEquals(book, savedReservation.getBook());
        verify(reservationRepository, times(1)).save(any(Reservation.class));
    }

    @Test
    void testCancelReservation() {
        Reservation reservation = new Reservation(user, book);

        when(reservationRepository.findById(anyLong())).thenReturn(Optional.of(reservation));

        boolean result = reservationService.cancelReservation(1L);

        assertTrue(result);
        verify(reservationRepository, times(1)).delete(reservation);
    }
}

@Test
public void testCannotReserveAlreadyReservedBook() {
    // Given an already reserved book
    Long bookId = 1L;
    Long userId1 = 10L;
    Long userId2 = 20L;

    reservationService.reserveBook(bookId, userId1);
    
    // When another user tries to reserve the same book
    boolean result = reservationService.reserveBook(bookId, userId2);

    // Then it should fail
    assertFalse(result, "User should not be able to reserve an already reserved book");
}
