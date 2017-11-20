package cn.itcast.springboot.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.springboot.domain.Notice;
import cn.itcast.springboot.mapper.NoticeMapper;
import cn.itcast.springboot.service.NoticeService;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	//注入mapper
	@Autowired
	private NoticeMapper noticeMapper;
	
	/** 查询所有公告 */
	@Override
	public List<Notice> findAll() {
		
		return noticeMapper.findAll();
	}

	/** 分页查询公告 */
	@Override
	public Map<String, Object> findByPage(Integer page, Integer rows) {
		
		/** 创建Map集合封装响应数据 */
		Map<String,Object> data = new HashMap<String,Object>();
		
		/** 统计查询 */
		Long count = noticeMapper.count();
		data.put("total", count);
		
		/** 分页查询 */
		List<Notice> notices = noticeMapper.findByPage(page, rows);
		data.put("rows", notices);
		
		return data;
	}

}
