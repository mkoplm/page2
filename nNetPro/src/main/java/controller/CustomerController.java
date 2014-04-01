package controller;

import view.FailView;
import view.SuccessView;
import exception.DuplicateException;
import exception.FileNotFoundException;
import model.dao.NnetCustomerDAO;
import model.dao.NnetMediaDAO;
import model.domain.CustomerDTO;
import model.service.CustomerManagementImpl;

public class CustomerController {
	private static CustomerManagementImpl cust = CustomerManagementImpl.getInstance();
	
	public static void insert (CustomerDTO customer) {
		try {
			cust.insert(customer);
				SuccessView.successMsg("회원가입이 완료되었습니다.");
		} catch (DuplicateException e){
			FailView.failMsg("중복되는 아이디 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("회원가입 실패");
		}
	}
	
	public static void selectAllCustomer () {
		try {
			SuccessView.printAllCustomer(cust.selectAllCustomer());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}
	
	public static void getCustomer (String cusId) {
		try {
			SuccessView.printCustomer(cust.selectCustomerByCustId(cusId));
		} catch (FileNotFoundException f){
			FailView.failMsg("고객정보가 존재하지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}
	
	public static void updateCustomer (String cusId, int cusMoney) {
		try {
			cust.updateCustomer(cusId, cusMoney);
			SuccessView.successMsg("고객정보 수정 완료");
		} catch (FileNotFoundException f){
			FailView.failMsg("고객정보가 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			FailView.failMsg("수정 실패. 관리자에게 문의하세요.");
		}
	}
	
	public static void buyMedia (String cusId, int mcode) {
		try {
			cust.buyMedia(cusId, mcode);
			SuccessView.successMsg("구매 완료");
		} catch (FileNotFoundException f){
			FailView.failMsg("음원이 존재하지 않습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			FailView.failMsg("구매 실패 다시 시도하세요");
		}
	}
	
	public static void deleteAll() {
		try {
			cust.deleteAll();
			SuccessView.successMsg("음원정보 삭제 성공");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("삭제 실패 다시 시도하세요");
		}
	}
}
