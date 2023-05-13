package com.gjy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gjy.controller.utils.R;
import com.gjy.domain.Book;
import com.gjy.manager.IBookService;
import com.gjy.service.AaaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;
    @Autowired
    private AaaService aaaService;

    @GetMapping
    public R getAll() {
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功" : "添加失败");
    }

    @PostMapping("/aaa")
    public String saveAaa(@RequestBody Book book) throws IOException {
        aaaService.aaa();
        return "aaa";
    }

    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id) {
        System.out.println("getting...");
        return new R(true, bookService.getById(id));
    }

    @GetMapping("{curp}/{size}")
    public R getPage(@PathVariable int curp, @PathVariable int size, Book book) {
        System.out.println("参数=>" + book);
        IPage<Book> page = bookService.getPage(curp, size, book);
        if (curp > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), size, book);
        }
        return new R(null != page, page);
    }
}
