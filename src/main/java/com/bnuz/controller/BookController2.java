package com.bnuz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bnuz.controller.util.R;
import com.bnuz.domain.Book;
import com.bnuz.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true, bookService.list(), null);
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException{
        boolean flag = bookService.saveBook(book);
        return new R(flag, null, flag ? "添加成功" : "添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book), null, null);
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id), null, null);
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, bookService.getById(id), null);
    }

//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if (currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(), pageSize);
//        }
//        return new R(true, page, null);
//    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R(true, page, null);
    }

}
