package kr.or.ddit.member.service;

import kr.or.ddit.file.vo.AttachFileVo;
import kr.or.ddit.member.vo.MemberVo;

public interface MemberService {
	
	public int insertMember(MemberVo member);
	
	public int getMaxFileNo();
	
	public int insertFile(AttachFileVo file);

	public int getMaxMemNo();

	public MemberVo getMember(int memNo);
	
	public AttachFileVo getFile(int fileNo);

	public MemberVo login(MemberVo member);
}
