package com.bnuz.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bnuz.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("计算机理论");
        book.setName("疯狂SpringBoot终极讲义");
        book.setDescription("一本只需要读懂前三章就可以入门SpringBoot的书");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(13);
        book.setType("计算机理论");
        book.setName("疯狂SpringBoot终极讲义");
        book.setDescription("一本教你各种各样技术整合的书");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        Book book = new Book();
        book.setId(13);
        book.setType("计算机理论");
        book.setName("疯狂SpringBoot终极讲义");
        book.setDescription("一本教你各种各样技术整合的书");
        bookDao.deleteById(book);
    }

    @Test
    void testGetAll(){
        List<Book> list = bookDao.selectList(null);
        for (Book book : list){
            System.out.println(book);
        }
    }

    @Test
    void testPageHelper(){
        IPage page = new Page(2, 5);
        System.out.println(bookDao.selectPage(page, null));
        System.out.println(page.getRecords());
    }

    @Test
    void testGetByQuery(){
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "Spring");
//        System.out.println(bookDao.selectList(queryWrapper));

        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = "boot";
        lambdaQueryWrapper.like(name!=null, Book::getName, name);
        System.out.println(bookDao.selectList(lambdaQueryWrapper));
    }


}
