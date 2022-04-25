package com.bnuz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bnuz.domain.Book;

public interface IBookService extends IService<Book> {

    Boolean saveBook(Book book);
    Boolean modify(Book book);
    Boolean delete(Integer id);

    IPage<Book> getPage(int cur, int pagesize);
    IPage<Book> getPage(int cur, int pagesize, Book book);
}
