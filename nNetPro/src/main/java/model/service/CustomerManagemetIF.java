package model.service;

import java.util.ArrayList;

import exception.DuplicateException;
import exception.FileNotFoundException;
import model.domain.CustomerDTO;

public interface CustomerManagemetIF {

	public  ArrayList<CustomerDTO> selectAllCustomer() throws Exception;
	public  CustomerDTO selectCustomerByCustId(String cusId) throws FileNotFoundException;
	public  boolean insert(CustomerDTO customer) throws DuplicateException ;
	public  boolean updateCustomer(String cusId, int cusMoney) throws FileNotFoundException ;
	public  void buyMedia(String cusId, int cusMoney, int mcode) throws FileNotFoundException;
	public  boolean delete(String cusId) throws FileNotFoundException;
	public  boolean deleteAll() throws Exception ;
	
}
