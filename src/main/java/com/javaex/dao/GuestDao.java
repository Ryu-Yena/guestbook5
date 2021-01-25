package com.javaex.dao;




import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;


@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//방명록 가져오기
	public List<GuestVo> getGuestList(){
		System.out.println("dao:getGuestList()");
		List<GuestVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		System.out.println(guestList);
		return guestList;
	}
	
	
	//방명록 등록
	public void addGuest(GuestVo guestVo) {
		System.out.println(guestVo.toString());
		sqlSession.insert("guestbook.insert", guestVo);
		
	}
	
	//방명록 삭제
	public int deleteGuest(GuestVo guestVo) {
		System.out.println("dao: deleteGuest(): " + guestVo);
		
		int count = sqlSession.delete("guestbook.delete", guestVo);
		System.out.println("dao: count = " + count);
		return count;
		
	}
	
	
}

