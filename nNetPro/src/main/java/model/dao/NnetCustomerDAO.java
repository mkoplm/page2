package model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import exception.DuplicateException;
import exception.FileNotFoundException;
import model.domain.CustomerDTO;
import util.DAOFactory;

public class NnetCustomerDAO {
	
	public static ArrayList<CustomerDTO> selectAllCustomer() throws Exception {
		SqlSession session = DAOFactory.getSqlSession();
		ArrayList<CustomerDTO> selectAll = null;
		try {
			selectAll = (ArrayList)session.selectList("CustomerXml.selectAllCustomer");
		} finally{
			session.close();			
		}
		return selectAll;
	}
	
	public static CustomerDTO selectCustomerByCustId(String cusId) throws FileNotFoundException {
		if(!isExist(cusId)){
			new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession();
		CustomerDTO customer = null;
		try {
			customer = (CustomerDTO)session.selectOne("CustomerXml.selectCustomerByCusId", new String(cusId));
		} finally{
			session.close();			
		}
		return customer;
	}
	
	public static boolean insert(CustomerDTO customer) throws DuplicateException {
		if(isExist(customer.getCusId())){
			throw new DuplicateException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		try {
			return (session.insert("CustomerXml.insertCustomer", customer) >= 1)? true:false;
		} finally{
			DAOFactory.closeSqlSession(false, session);			
		}
	}
	
	public static boolean updateCustomer(String cusId, int cusMoney) throws FileNotFoundException {
		if(!isExist(cusId)){
			new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		CustomerDTO customer = new CustomerDTO(cusId, cusMoney);
		try {
			return  (session.update("CustomerXml.updateCustomer", customer) >= 1) ? true:false;
		} finally{
			DAOFactory.closeSqlSession(false, session);			
		}
	}
	
	public static void buyMedia(String cusId, int mcode) throws FileNotFoundException {
		if(!isExist(cusId)){
			new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		CustomerDTO customer = null;
		int price;
		try {
			price = NnetMediaDAO.getMedia(mcode).getMprice();
			customer = new CustomerDTO(cusId, price, mcode);
			session.update("CustomerXml.buyMedia", customer);
			NnetMediaDAO.sellMedia(mcode);			
		} finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static boolean delete(String cusId) throws FileNotFoundException {
		if(!isExist(cusId)){
			new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		try {
			return (session.delete("CustomerXml.deleteCustomerByCusId", new Integer(cusId)) >= 1) ? true:false;
		} finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static boolean deleteAll() throws Exception {
		SqlSession session = DAOFactory.getSqlSession(true);
		try {
			return (session.delete("CustomerXml.deleteCustomer") >= 1) ? true:false;
		} finally{
			session.close();
		}
	}
	
	private static boolean isExist (String cusId) {
		SqlSession session = DAOFactory.getSqlSession();
		try {
			return (session.selectOne("CustomerXml.selectCustomerByCusId", cusId) != null )?true:false;
		} finally {
			session.close();
		}
	}
}
