package com.gjy.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjy.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

@SpringBootTest
class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据");
        book.setName("测试数据");
        book.setDescription("测试数据");
        bookDao.insert(book);
    }
    @Test
    void testUpdata() {
        Book book = new Book();
        book.setId(5);
        book.setType("测试pp");
        book.setName("测试数据");
        book.setDescription("测试数据");
        bookDao.updateById(book);

    }
    @Test
    void testGetPage() {
        IPage page=new Page(2,5);
        IPage iPage = bookDao.selectPage(page, null);//alt+enter


    }
    @Test
    void testGet() {
        String name="JVM原理";
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(name!=null,Book::getName,name);
        bookDao.selectList(qw);

    }
//    @Test
//    void test() {
//        System.out.println(bookDao.selectById(1));
//
//    }
//    @Test
//    void test() {
//        System.out.println(bookDao.selectById(1));
//
//    }
}
