package controller;

import exception.DuplicateException;
import exception.FileNotFoundException;
import model.dao.NnetCustomerDAO;
import model.dao.NnetMediaDAO;
import model.domain.CustomerDTO;
import model.domain.MediaDTO;
import view.FailView;
import view.SuccessView;

public class Controller {
	
	NnetMediaDAO mediadao = new NnetMediaDAO();
	
	public static void insert (MediaDTO media) {
		try {
			NnetMediaDAO.insert(media);
			SuccessView.successMsg("음악이 추가되었습니다.");
		} catch (DuplicateException e){
			new DuplicateException("중복되는 음원번호입니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("추가 실패");
		}
	}
	
	public static void insert (CustomerDTO customer) {
		try {
			NnetCustomerDAO.insert(customer);
				SuccessView.successMsg("회원가입이 완료되었습니다.");
		} catch (DuplicateException e){
			new DuplicateException("중복되는 아이디 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("회원가입 실패");
		}
	}
	
	public static void getMediaAll () {
		try {
			SuccessView.printAllMedia(NnetMediaDAO.getMediaAll());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}
	
	public static void selectAllCustomer () {
		try {
			SuccessView.printAllCustomer(NnetCustomerDAO.selectAllCustomer());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}

	public static void getMedia (int mcode) {
		try {
			SuccessView.printMedia(NnetMediaDAO.getMedia(mcode));
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}
	
	public static void getCustomer (String cusId) {
		try {
			SuccessView.printCustomer(NnetCustomerDAO.selectCustomerByCustId(cusId));
		} catch (FileNotFoundException f){
			new FileNotFoundException("고객정보가 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}
	
	public static void delete (int mcode) {
		try {
			NnetMediaDAO.delete(mcode);
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
			NnetMediaDAO.update(media);
			SuccessView.successMsg("수정 성공");
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch (Exception e) {
			FailView.failMsg("수정 실패 다시 시도하세요");
		}
	}
	
	public static void updateCustomer (String cusId, int cusMoney) {
		try {
			NnetCustomerDAO.updateCustomer(cusId, cusMoney);
			SuccessView.successMsg("고객정보 수정 완료");
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			FailView.failMsg("수정 실패. 관리자에게 문의하세요.");
		}
	}
	
	public static void buyMedia (String cusId, int cusMoney, int mcode) {
		try {
			NnetCustomerDAO.buyMedia(cusId, cusMoney, mcode);
			SuccessView.successMsg("구매 완료");
		} catch (FileNotFoundException f){
			new FileNotFoundException("음원이 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			FailView.failMsg("구매 실패 다시 시도하세요");
		}
	}
	
	public static void deleteAll() {
		try {
			NnetCustomerDAO.deleteAll();
			NnetMediaDAO.deleteAll();
			SuccessView.successMsg("삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요");
		}
	}
}

