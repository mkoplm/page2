package controller;

import model.dao.NnetMediaDAO;
import model.domain.MediaDTO;
import view.FailView;
import view.SuccessView;

public class Controller {
	
NnetMediaDAO mediadao = new NnetMediaDAO();
	
	public static void insert(MediaDTO media) {
		try {
			NnetMediaDAO.insert(media);
				SuccessView.successMsg("음악이 추가되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("추가 실패");
		}
	}
	
	public static void getProductAll() {
		try {
			SuccessView.printAll(NnetMediaDAO.getMediaAll());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}

	public static void getProduct(int mcode) {
		try {
			SuccessView.printProduct(NnetMediaDAO.getMedia(mcode));
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}
	
	public static void delete(int mcode) {
		try {
			NnetMediaDAO.delete(mcode);
				SuccessView.successMsg("삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요");
		}
	}
	
	public static void update(int mcode) {
		try {
			NnetMediaDAO.update(mcode);
				SuccessView.successMsg("수정 성공");
		} catch(Exception e) {
			e.printStackTrace();
			FailView.failMsg("수정 실패 다시 시도하세요");
		}
	}
	
}

