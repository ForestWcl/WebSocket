package com.wuchanglin.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wuchanglin.springmvc.entity.Book;
import com.wuchanglin.springmvc.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public List<Book> getBookList(){
		Book b = new Book(1,"三国演义","罗贯中",55.5,"清华出版社");
		Book b2 = new Book(1,"水浒传","施耐庵",55.5,"北京大学出版社");
		Book b3 = new Book(1,"西游记","吴承恩",55.5,"中华出版社");
		Book b4 = new Book(1,"红楼梦","曹雪芹",55.5,"博为峰");
		List<Book> bookList = new ArrayList<>();
		bookList.add(b);
		bookList.add(b2);
		bookList.add(b3);
		bookList.add(b4);
		return bookList;
	}

}
