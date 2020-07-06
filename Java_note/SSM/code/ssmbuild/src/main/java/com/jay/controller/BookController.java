package com.jay.controller;

import com.jay.pojo.Books;
import com.jay.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    // controller invoke service
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    // query all books, jump to a jsp
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list", books);
        return "allBook";
    }

    // jumpt to add book page
    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Books book, Model model) {
        bookService.addBook(book);

        // jump to list method: query all books after add a book
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdatePage")
    public String toUpdatePage(int id, Model model) {
        Books book = bookService.queryBookById(id);

        model.addAttribute("QBook", book);
        return "updateBook";
    }

    @PostMapping("/updateBook")
    public String updateBook(Books book, Model model) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);

        return "redirect:/book/allBook";
    }


    @RequestMapping("/deleteBook/{bookID}")
    public String deleteBook(@PathVariable("bookID") int id) {
        System.out.println("bookID: " + id);
        bookService.deleteBookById(id);

        return "redirect:/book/allBook";
    }
}
