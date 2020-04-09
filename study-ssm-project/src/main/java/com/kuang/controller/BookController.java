package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Mark
 * @version 1.0
 * @date 2020/4/8 22:25
 * @description 书籍控制层
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        LOGGER.info("this is List<Books> [{}]", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        bookService.addBook(books);
        LOGGER.info("this is Books [{}]", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        LOGGER.info("this is Books [{}]", books);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        LOGGER.info("this is book [{}]", books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        LOGGER.info("this is book [{}]", id);
        return "redirect:/book/allBook";
    }
}