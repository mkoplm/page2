package controller;

import model.domain.MediaDTO;
import model.service.MediaManagementImpl;
import view.FailView;
import view.SuccessView;
import exception.DuplicateException;
import exception.FileNotFoundException;

public class MediaController {
	private static MediaManagementImpl manager = MediaManagementImpl.getInstance();
	
	public static void insert (MediaDTO media) {
		try {
			manager.insert(media);
			SuccessView.successMsg("음악이 추가되었습니다.");
		} catch (DuplicateException e){
			FailView.failMsg("중복되는 음원번호입니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("추가 실패");
		}
	}
	
	public static void getMediaAll () {
		try {
			SuccessView.printAllMedia(manager.getMediaAll());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}

	public static void getMedia (int mcode) {
		try {
			SuccessView.printMedia(manager.getMedia(mcode));
		} catch (FileNotFoundException f){
			FailView.failMsg("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}
	
	public static void delete (int mcode) {
		try {
			manager.delete(mcode);
			SuccessView.successMsg("삭제 성공");
		} catch (FileNotFoundException f){
			FailView.failMsg("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요.");
		}
	}
	
	public static void update (MediaDTO media) {
		try {
			manager.update(media);
			SuccessView.successMsg("수정 성공");
		} catch (FileNotFoundException f){
			FailView.failMsg("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("수정 실패 다시 시도하세요");
		}
	}
	
	public static void deleteAll() {
		try {
			manager.deleteAll();
			SuccessView.successMsg("고객정보 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요");
		}
	}
}

