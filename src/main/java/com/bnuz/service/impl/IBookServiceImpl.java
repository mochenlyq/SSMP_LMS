package com.bnuz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bnuz.dao.BookDao;
import com.bnuz.domain.Book;
import com.bnuz.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int cur, int pagesize) {
        IPage page = new Page(cur, pagesize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int cur, int pagesize, Book book) {
        IPage page = new Page(cur, pagesize);
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        page = bookDao.selectPage(page, lambdaQueryWrapper);
        return page;
    }

}
