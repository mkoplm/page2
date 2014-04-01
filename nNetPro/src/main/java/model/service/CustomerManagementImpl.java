package model.service;

import java.util.ArrayList;

import model.dao.NnetCustomerDAO;
import model.domain.CustomerDTO;
import exception.DuplicateException;
import exception.FileNotFoundException;

public class CustomerManagementImpl implements CustomerManagemetIF{
	private static CustomerManagementImpl instance = new CustomerManagementImpl();
	private CustomerManagementImpl(){}
	public static CustomerManagementImpl getInstance(){
		return instance;
	}
	
	public  ArrayList<CustomerDTO> selectAllCustomer() throws Exception{
		return NnetCustomerDAO.selectAllCustomer();
	}
	public  CustomerDTO selectCustomerByCustId(String cusId) throws FileNotFoundException{
		return NnetCustomerDAO.selectCustomerByCustId(cusId);
	}
	public  boolean insert(CustomerDTO customer) throws DuplicateException {
		return NnetCustomerDAO.insert(customer);
	}
	public  boolean updateCustomer(String cusId, int cusMoney) throws FileNotFoundException {
		return NnetCustomerDAO.updateCustomer(cusId, cusMoney);
	}
	public  void buyMedia(String cusId, int mcode) throws FileNotFoundException{
		NnetCustomerDAO.buyMedia(cusId, mcode);
	}
	public  boolean delete(String cusId) throws FileNotFoundException{
		return NnetCustomerDAO.delete(cusId);
	}
	public  boolean deleteAll() throws Exception {
		return NnetCustomerDAO.deleteAll();
	}
}
