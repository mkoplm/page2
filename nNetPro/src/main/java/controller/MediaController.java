package controller;

import exception.DuplicateException;
import exception.FileNotFoundException;
import model.dao.NnetCustomerDAO;
import model.dao.NnetMediaDAO;
import model.domain.CustomerDTO;
import model.domain.MediaDTO;
import model.service.MediaManagementImpl;
import view.FailView;
import view.SuccessView;

public class MediaController {
	private static MediaManagementImpl menager = MediaManagementImpl.getInstance();
	
	public static void insert (MediaDTO media) {
		try {
			menager.insert(media);
			SuccessView.successMsg("음악이 추가되었습니다.");
		} catch (DuplicateException e){
			new DuplicateException("중복되는 음원번호입니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("추가 실패");
		}
	}
	
	public static void getMediaAll () {
		try {
			SuccessView.printAllMedia(menager.getMediaAll());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}

	public static void getMedia (int mcode) {
		try {
			SuccessView.printMedia(menager.getMedia(mcode));
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}
	
	public static void delete (int mcode) {
		try {
			menager.delete(mcode);
			SuccessView.successMsg("삭제 성공");
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요.");
		}
	}
	
	public static void update (MediaDTO media) {
		try {
			menager.update(media);
			SuccessView.successMsg("수정 성공");
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			FailView.failMsg("수정 실패 다시 시도하세요");
		}
	}
	
	public static void deleteAll() {
		try {
			menager.deleteAll();
			SuccessView.successMsg("삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요");
		}
	}
}

