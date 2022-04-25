package com.bnuz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnuz.dao.BookDao;
import com.bnuz.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("计算机理论");
        book.setName("疯狂SpringBoot终极讲义");
        book.setDescription("一本只需要读懂前三章就可以入门SpringBoot的书");
        bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(15);
        book.setType("计算机理论");
        book.setName("疯狂SpringBoot终极讲义");
        book.setDescription("一本教你各种各样技术整合的书");
        bookService.updateById(book);
    }

    @Test
    void testDeleteById(){
        bookService.removeById(14);
    }

    @Test
    void testGetAll(){
        System.out.println(bookService.list());
    }

    @Test
    void testPageHelper(){
        IPage page = new Page(2, 5);
        bookService.page(page);
        System.out.println(page.getRecords());
    }

//    @Test
//    void testGetByQuery(){
////        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
////        queryWrapper.like("name", "Spring");
////        System.out.println(bookDao.selectList(queryWrapper));
//
//        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        String name = "boot";
//        lambdaQueryWrapper.like(name!=null, Book::getName, name);
//        System.out.println(bookDao.selectList(lambdaQueryWrapper));
//    }


}
