package model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import exception.FileNotFoundException;
import model.domain.CustomerDTO;
import util.DAOFactory;

public class NnetCustomerDAO {
	
	public static ArrayList<CustomerDTO> selectAllCustomer() throws FileNotFoundException {
		SqlSession session = DAOFactory.getSqlSession();
		ArrayList<CustomerDTO> selectAll = null;
		try {
			selectAll = (ArrayList)session.selectList("CustomerXml.selectAllCustomer");
		} finally{
			session.close();			
		}
		return selectAll;
	}
	
	public static CustomerDTO selectCustomerByCustId(String cusId) throws Exception {
		SqlSession session = DAOFactory.getSqlSession();
		CustomerDTO customer = null;
		try {
			customer = (CustomerDTO)session.selectOne("CustomerXml.selectCustomerByCusId", new String(cusId));
		} finally{
			session.close();			
		}
		return customer;
	}
	
	public static boolean insert(CustomerDTO customer) throws Exception {
		SqlSession session = DAOFactory.getSqlSession(true);
		try {
			return (session.insert("CustomerXml.insertCustomer", customer) >= 1)? true:false;
		} finally{
			session.close();			
		}
	}
	
	public static boolean updateCustomer(String cusId, int cusMoney) throws Exception {
		SqlSession session = DAOFactory.getSqlSession(true);
		CustomerDTO customer = new CustomerDTO(cusId, cusMoney);
		try {
			return  (session.update("CustomerXml.updateCustomer", customer) >= 1) ? true:false;
		} finally{
			session.close();			
		}
	}
	
	public static void buyMedia(String cusId, int cusMoney, int mcode) throws Exception {
		SqlSession session = DAOFactory.getSqlSession(true);
		CustomerDTO customer = new CustomerDTO(cusId, cusMoney, mcode);
		try {
			session.update("CustomerXml.buyMedia", customer);
			customer = session.selectOne("CustomerXml.selectCustomerByCusId", cusId);
			NnetMediaDAO.sellMedia(customer.getMcode());
		} finally{
			session.close();
		}
	}
	
	public static boolean delete(String cusId) throws Exception {
		SqlSession session = DAOFactory.getSqlSession(true);
		try {
			return (session.delete("CustomerXml.deleteCustomerByCusId", new Integer(cusId)) >= 1) ? true:false;
		} finally{
			session.close();
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
	
}
