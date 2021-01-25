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
		System.out.println("dao:addGuest()");
		List<GuestVo> guestList = sqlSession.selectList("guestbook.selectList");
		
		System.out.println(guestList);
		return guestList;
	}
	
	/*
	//방명록 등록
	public int addGuest(GuestVo guestVo) {
		int count = 0;
		getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " insert into guestbook ";
			query += " vlaues (seq_no.nextval, ?, ?, ?, sysdate) ";
			// System.out.println(query);

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setString(1, guestVo.getName()); 
			pstmt.setString(2, guestVo.getPassword());
			pstmt.setString(3, guestVo.getContent());

			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return count;
	}
	
	//방명록 리스트
	public List<GuestVo> getGuestList(){
		List<GuestVo> guestList = new ArrayList<GuestVo>();
		
		getConnection();
		
		try {
				// 3. SQL문 준비 / 바인딩 / 실행 --> 완성된 sql문을 가져와서 작성할것
				String query = "";
				query += " select  no, ";
				query += "         name, ";
				query += "         content, ";
				query += "         to_char(reg_date, 'yy-mm-dd hh24:mi') ";
				query += " from guestbook";
				
				pstmt = conn.prepareStatement(query);
				
				
				rs = pstmt.executeQuery();

				// 4.결과처리
				while (rs.next()) {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String content = rs.getString("content");
					String date = rs.getString("reg_date");

					GuestVo GuestVo = new GuestVo(no, name, password, content, date);
					guestList.add(GuestVo);
				}

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

			close();

			return guestList;

	}
	
	// 사람 삭제
	public int guestDelete(GuestVo guestVo) {
		
		int count = 0;
		
		getConnection();

		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " delete from gusetbook ";
			query += " where no = ? ";
			query += " and password = ? ";
			
			
			pstmt = conn.prepareStatement(query); // 쿼리로 만들기

			pstmt.setInt(1, guestVo.getNo());
			pstmt.setString(2, guestVo.getPassword());
	

			count = pstmt.executeUpdate(); // 쿼리문 실행

			// 4.결과처리
			System.out.println(count + "건 삭제");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		close();
		return count;
	}
	
	//방명록 하나 가져오기
	public GuestVo getGuest(int num) {
		GuestVo guestVo = null;
		
		getConnection();
		try {
			// 3. SQL문 준비 / 바인딩 / 실행 --> 완성된 sql문을 가져와서 작성할것
			String query= "";
			query += " select  no, ";
			query += "         name, ";
			query += "         password, ";
			query += "         content ";
			query += " from guestbook ";
			query += " where no = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			
			// 4.결과처리
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				
				guestVo = new GuestVo(no, name, password, content);
			}
			
		}catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
		close();
		return guestVo;
	}
	*/
	
}

