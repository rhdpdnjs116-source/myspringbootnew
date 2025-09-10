package lx.edu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lx.edu.springboot.vo.AddrBookVO;
import lx.edu.springboot.dao.AddrBookDAO;

@RestController
public class AddrBookRestController {
	@Autowired
	AddrBookDAO dao;
	//id를 전달받아서 해당 방명록을 Json으로 리턴
	@RequestMapping("/addrbooks/{id}")
	public AddrBookVO getAddrBook(@PathVariable("id") int id) throws Exception {
		//id로 dao 메서드호출해서 방명록 정보를 조회한다.
		AddrBookVO vo = dao.getDB(id);
		return vo;
	}
	
}
