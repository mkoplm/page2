package model.service;

import java.util.ArrayList;

import model.dao.NnetMediaDAO;
import model.domain.MediaDTO;
import exception.DuplicateException;
import exception.FileNotFoundException;

public class MediaManagementImpl implements MediaManagementIF{
	private static MediaManagementImpl instance = new MediaManagementImpl();
	private MediaManagementImpl(){}
	public static MediaManagementImpl getInstance(){
	return instance;
	}
	
	public  void insert(MediaDTO media) throws DuplicateException{
		NnetMediaDAO.insert(media);
	}
	public  void update (MediaDTO media) throws FileNotFoundException{
		NnetMediaDAO.update(media);
	}
	public  boolean sellMedia(int mcode) throws FileNotFoundException{
		return NnetMediaDAO.sellMedia(mcode);
	}
	public  void delete(int mcode) throws FileNotFoundException{
		NnetMediaDAO.delete(mcode);
	}
	public  MediaDTO getMedia(int mcode) throws FileNotFoundException{
		return NnetMediaDAO.getMedia(mcode);
	}
	public  ArrayList<MediaDTO> getMediaAll() throws FileNotFoundException{
		return NnetMediaDAO.getMediaAll();
	}
	public  boolean deleteAll(){
		return NnetMediaDAO.deleteAll();
	}

}
