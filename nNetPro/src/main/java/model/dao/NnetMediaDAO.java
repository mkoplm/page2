package model.dao;

import java.util.ArrayList;

import model.domain.MediaDTO;

import org.apache.ibatis.session.SqlSession;

import util.DAOFactory;

public class NnetMediaDAO {

	public static void insert(MediaDTO media){
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			session.insert("MediaXml.insertMediaDTO", media);
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static void update(int mcode){
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			 session.update("MediaXml.updateMediaDTO", mcode);
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static void delete(int mcode){
		SqlSession session = DAOFactory.getSqlSession(true);
		try{
			session.delete("MediaXml.deleteMediaDTOByMcode", mcode);
		}finally{
			DAOFactory.closeSqlSession(false, session);
		}
	}
	
	public static MediaDTO getMedia(int mcode){
		SqlSession session = DAOFactory.getSqlSession();
		MediaDTO product = null;
		try{
			product = session.selectOne("MediaXml.selectMediaDTOByMcode", mcode);
		}finally{
			DAOFactory.closeSqlSession(session);
		}
		return product;
	}
	
	public static ArrayList<MediaDTO> getMediaAll(){
		SqlSession session = DAOFactory.getSqlSession();
		ArrayList<MediaDTO> list = null;
		try{
			list = (ArrayList)session.selectList("MediaXml.selectAllMediaDTO");
		}finally{
			DAOFactory.closeSqlSession(session);
		}
		return list;
	}
	
}
