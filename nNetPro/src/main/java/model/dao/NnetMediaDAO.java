package model.dao;

import java.util.ArrayList;

import model.domain.MediaDTO;

import org.apache.ibatis.session.SqlSession;

import exception.DuplicateException;
import exception.FileNotFoundException;
import util.DAOFactory;

public class NnetMediaDAO {

	public static void insert(MediaDTO media) throws DuplicateException{
		if(isExist(media.getMcode())){
			throw new DuplicateException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			session.insert("MediaXml.insertMedia", media);
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static void update (MediaDTO media) throws FileNotFoundException{
		if(!isExist(media.getMcode())){
			throw new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			 session.update("MediaXml.updateMedia", media);
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static boolean sellMedia(int mcode) throws FileNotFoundException{
		if(!isExist(mcode)){
			throw new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			 return (session.update("MediaXml.sellMedia", mcode) >=1)?true:false;
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static void delete(int mcode) throws FileNotFoundException{
		if(!isExist(mcode)){
			throw new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			session.delete("MediaXml.deleteMediaByMcode", mcode);
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static MediaDTO getMedia(int mcode) throws FileNotFoundException{
		if(!isExist(mcode)){
			throw new FileNotFoundException();
		}
		SqlSession session = DAOFactory.getSqlSession();
		MediaDTO product = null;
		try{
			product = session.selectOne("MediaXml.selectMediaByMcode", mcode);
		}finally{
			DAOFactory.closeSqlSession(session);
		}
		return product;
	}
	
	public static ArrayList<MediaDTO> getMediaAll() throws FileNotFoundException{
		SqlSession session = DAOFactory.getSqlSession();
		ArrayList<MediaDTO> list = null;
		try{
			list = (ArrayList)session.selectList("MediaXml.selectAllMedia");
		}finally{
			DAOFactory.closeSqlSession(session);
		}
		return list;
	}
	
	public static boolean deleteAll() {
		SqlSession session = DAOFactory.getSqlSession(true);
		try {
			return (session.delete("MediaXml.deleteAllMedia") >= 1) ? true:false;
		} finally{
			session.close();
		}
	}
	
	private static boolean isExist(int mcode){
		SqlSession session = DAOFactory.getSqlSession();
		try{
			return (session.selectOne("MediaXml.selectMediaByMcode", mcode) != null)?true:false;
		} finally {
			session.close();
		}
	}
}
