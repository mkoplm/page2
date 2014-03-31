package model.service;

import java.util.ArrayList;

import model.domain.MediaDTO;
import exception.DuplicateException;
import exception.FileNotFoundException;

public interface MediaManagementIF {

	public  void insert(MediaDTO media) throws DuplicateException;
	public  void update (MediaDTO media) throws FileNotFoundException;
	public  boolean sellMedia(int mcode) throws FileNotFoundException;
	public  void delete(int mcode) throws FileNotFoundException;
	public  MediaDTO getMedia(int mcode) throws FileNotFoundException;
	public  ArrayList<MediaDTO> getMediaAll() throws FileNotFoundException;
	public  boolean deleteAll();
}
