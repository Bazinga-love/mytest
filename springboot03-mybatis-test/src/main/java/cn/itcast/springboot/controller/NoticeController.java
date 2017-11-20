package cn.itcast.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	/** 查询所有公告 */
	@GetMapping("/findAll")
	@ResponseBody
	public List<Notice> findAll(){
		
		return noticeService.findAll();
		
	}
	
	/** 跳转分页查询公告页面 */
	@GetMapping("/show")
	public String show(){
		
		return "/html/notice.html";
	}
	
	/** 分页查询公告 */
	@ResponseBody
	@PostMapping("/findByPage")
	public Map<String,Object> findByPage(
			@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="rows",defaultValue="1")Integer rows){
		
		return noticeService.findByPage((page-1)*rows, rows);
		
	}
	
}
