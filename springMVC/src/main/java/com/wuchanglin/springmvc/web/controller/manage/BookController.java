package com.wuchanglin.springmvc.web.controller.manage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wuchanglin.springmvc.service.BookService;
import com.wuchanglin.springmvc.entity.Book;

@RequestMapping("/manage/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	private Long maxUploadSize;
	private String sizeTip;
	private List<String> contentTypes;
	private String typeTip;
	private String success;
	
	@RequestMapping("/mgr")
	public String mgr(){
		return "manage/bookmgr";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<Book> list(){
		return bookService.getBookList();
	}
	@RequestMapping("/save")
	public String save(MultipartFile pic,Book book,HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("save...");
		if(pic.isEmpty()){
			System.out.println("没有上传图片");
			System.out.println(book);
			return "forward:/manage/book/mgr";
		}else if(pic.getSize()>maxUploadSize){
			request.setAttribute("tip", sizeTip);
			return "forward:/manage/book/mgr";
		}else if(!contentTypes.contains(pic.getContentType())){
			request.setAttribute("tip", typeTip);
			return "forward:/manage/book/mgr";
		}
			String realPath = request.getServletContext().getRealPath("/photo")+"/"+ pic.getOriginalFilename();
			System.out.println(realPath);
			pic.transferTo(new File(realPath));
			request.setAttribute("tip", success);
			return "forward:/manage/book/mgr";
		
	}
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public Long getMaxUploadSize() {
		return maxUploadSize;
	}

	public void setMaxUploadSize(Long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}

	public String getSizeTip() {
		return sizeTip;
	}

	public void setSizeTip(String sizeTip) {
		this.sizeTip = sizeTip;
	}

	public List<String> getContentTypes() {
		return contentTypes;
	}

	public void setContentTypes(List<String> contentTypes) {
		this.contentTypes = contentTypes;
	}

	public String getTypeTip() {
		return typeTip;
	}

	public void setTypeTip(String typeTip) {
		this.typeTip = typeTip;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	
	
	
}
