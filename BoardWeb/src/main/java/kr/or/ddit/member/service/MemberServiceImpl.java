package kr.or.ddit.member.service;

import kr.or.ddit.file.vo.AttachFileVo;
import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVo;

public class MemberServiceImpl implements MemberService {
	
	private static MemberServiceImpl instance;
	
	private MemberServiceImpl() {

	}
	
	public static MemberServiceImpl getInstacne() {
		if(instance == null) {
				instance = new MemberServiceImpl();
		}
		return instance;
	}
	
	MemberDao memberDao = MemberDaoImpl.getInstacne();
	
	@Override
	public int insertMember(MemberVo member) {
		return memberDao.insertMember(member);
	}

	@Override
	public int insertFile(AttachFileVo file) {
		return memberDao.insertFile(file);
	}

	@Override
	public int getMaxFileNo() {
		return memberDao.getMaxFileNo();
	}

	@Override
	public int getMaxMemNo() {
		return memberDao.getMaxMemNo();
	}

	@Override
	public MemberVo getMember(int memNo) {
		return memberDao.getMember(memNo);
	}

	@Override
	public AttachFileVo getFile(int fileNo) {
		return memberDao.getFile(fileNo);
	}

	@Override
	public MemberVo login(MemberVo member) {
		return memberDao.login(member);
	} 
	
}
