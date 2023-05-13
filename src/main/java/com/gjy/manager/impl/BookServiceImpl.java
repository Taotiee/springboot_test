package com.gjy.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gjy.dao.BookDao;
import com.gjy.domain.Book;
import com.gjy.manager.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page=new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(!book.getType().isEmpty(),Book::getType,book.getType());
        lqw.like(!book.getName().isEmpty(),Book::getName,book.getName());
        lqw.like(!book.getDescription().isEmpty(),Book::getDescription,book.getDescription());

        IPage page=new Page(currentPage,pageSize);

        return bookDao.selectPage(page,lqw);//传入分页及查询条件
    }
}
