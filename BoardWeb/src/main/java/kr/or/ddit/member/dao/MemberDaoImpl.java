package kr.or.ddit.member.dao;

import kr.or.ddit.file.vo.AttachFileVo;
import kr.or.ddit.member.vo.MemberVo;
import kr.or.ddit.mybatis.MyBatisDao;

public class MemberDaoImpl extends MyBatisDao implements MemberDao{

	private static MemberDaoImpl instance;
	
	private MemberDaoImpl() {
		
	}
	
	public static MemberDao getInstacne() {
		if(instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int insertMember(MemberVo member) {
		return insert("member.insertMember",member);
	}

	@Override
	public int insertFile(AttachFileVo file) {
		return insert("member.insertFile", file);
	}
	
	@Override
	public int getMaxFileNo() {
		return selectOne("member.getMaxFileNo");
	}


	@Override
	public int getMaxMemNo() {
		return selectOne("member.getMaxMemNo");
	}

	@Override
	public MemberVo getMember(int memNo) {
		return selectOne("member.getMember",memNo);
	}

	@Override
	public AttachFileVo getFile(int fileNo) {
		return selectOne("member.getFile",fileNo);
	}

	@Override
	public MemberVo login(MemberVo member) {
		return selectOne("member.login", member);
	}



}
