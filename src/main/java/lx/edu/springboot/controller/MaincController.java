package lx.edu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MaincController {

    @GetMapping("login_form.do")
    public String loginForm() {
        return "login"; 
    }
    @PostMapping("loginaction.do")
    public String loginAction(HttpServletRequest req,@RequestParam("id") String id,
    		@RequestParam("pw") String pw, HttpSession session) {
    	//리퀘스트파람으로 매개변수로 이것을 할거라고 정하면 된다.
    	//클라이언트가 아이디와 그리고 패스워드를 추출해야한다
    	//아이디 비번을 dao에서 가지고 오던가 여기서 처리하던가 해야한다
    	System.out.println("id=" + id + ", pw =" + pw);
    	if(id.equals(pw)) { //로그인 한 것으로 처리함
    		session.setAttribute("userId",id);
    		return "redirect:addrbook_list.do";
    	
    	}
    	return "redirect:login_form.do";
    }
}
