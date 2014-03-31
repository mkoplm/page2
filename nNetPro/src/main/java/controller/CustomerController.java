package controller;

import exception.DuplicateException;
import exception.FileNotFoundException;
import model.dao.NnetCustomerDAO;
import model.dao.NnetMediaDAO;
import model.domain.CustomerDTO;
import model.domain.MediaDTO;
import view.FailView;
import view.SuccessView;

public class CustomerController {
	
	public static void insert (CustomerDTO customer) {
		try {
			NnetCustomerDAO.insert(customer);
				SuccessView.successMsg("회원가입이 완료되었습니다.");
		} catch (DuplicateException e) {
			e.printStackTrace();
			FailView.failMsg("회원가입 실패");
		}catch (Exception e) {
			e.printStackTrace(); 
			FailView.failMsg("회원가입 실패");
		}
	}

	
	public static void selectAllCustomer () {
		try {
			SuccessView.printAllCustomer(NnetCustomerDAO.selectAllCustomer());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("모든 검색 실패");
		}
	}

	
	public static void getCustomer (String cusId) {
		try {
			SuccessView.printCustomer(NnetCustomerDAO.selectCustomerByCustId(cusId));
		} catch (Exception e) {
			e.printStackTrace();
			FailView.failMsg("검색 실패");
		}
	}

	
	public static void updateCustomer (String cusId, int cusMoney) {
		try {
			NnetCustomerDAO.updateCustomer(cusId, cusMoney);
			SuccessView.successMsg("고객정보 수정 완료");
		} catch(Exception e) {
			e.printStackTrace();
			FailView.failMsg("수정 실패. 관리자에게 문의하세요.");
		}
	}
	

}

