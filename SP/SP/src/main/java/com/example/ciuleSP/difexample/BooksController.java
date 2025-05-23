package com.example.ciuleSP.difexample;
import com.example.ciuleSP.Book.Book;
import com.example.ciuleSP.Serv.BookService;
import com.example.ciuleSP.Serv.CommandInvoker;
import com.example.ciuleSP.obs.AllBooksSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ciuleSP.repos.BooksRepository;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final CommandInvoker commandInvoker;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
        this.commandInvoker = new CommandInvoker();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
//        Command command = new GetBookByIdCommand(bookService, id);
//        commandInvoker.addCommand(command);
//        commandInvoker.executeCommands();
        return booksRepository.getReferenceById(id);
    }

    @PostMapping("/add")
    public void createBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book book) {
        bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }

    @Autowired
    private BooksRepository booksRepository;

    private AllBooksSubject allBooksSubject;

    @PostMapping("/new")
    public String newBook(@RequestBody Book newBookRequest) {
        Book book = booksRepository.save(newBookRequest);
        allBooksSubject.notifyObservers(book);
        return "Book saved [" + book.getId() + "] " + book.getTitle();
    }

}
