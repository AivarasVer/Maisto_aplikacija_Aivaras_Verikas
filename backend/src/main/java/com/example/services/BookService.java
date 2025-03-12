
package com.example.services;

import com.example.models.Book;
import com.example.models.User;
import com.example.repositories.BookRepository;
import com.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public String reserveBook(Long bookId, Long userId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (bookOpt.isPresent() && userOpt.isPresent()) {
            Book book = bookOpt.get();
            if (!book.isReserved()) {
                book.setReserved(true);
                book.setReservedBy(userOpt.get());
                bookRepository.save(book);
                return "Book reserved successfully.";
            } else {
                return "Book is already reserved.";
            }
        }
        return "Book or User not found.";
    }

    public String unreserveBook(Long bookId) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.isReserved()) {
                book.setReserved(false);
                book.setReservedBy(null);
                bookRepository.save(book);
                return "Book reservation cancelled.";
            } else {
                return "Book was not reserved.";
            }
        }
        return "Book not found.";
    }

    public String addBookToFavorites(Long userId, Long bookId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isPresent() && bookOpt.isPresent()) {
            User user = userOpt.get();
            Book book = bookOpt.get();
            user.getFavoriteBooks().add(book);
            userRepository.save(user);
            return "Book added to favorites.";
        }
        return "User or Book not found.";
    }

    public String removeBookFromFavorites(Long userId, Long bookId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isPresent() && bookOpt.isPresent()) {
            User user = userOpt.get();
            Book book = bookOpt.get();
            user.getFavoriteBooks().remove(book);
            userRepository.save(user);
            return "Book removed from favorites.";
        }
        return "User or Book not found.";
    }
}
