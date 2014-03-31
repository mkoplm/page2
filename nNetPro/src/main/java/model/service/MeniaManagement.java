package model.service;

import java.util.ArrayList;

import model.domain.MediaDTO;

public interface MeniaManagement {

	public MediaDTO getMedia(int mcode) throws Exception;

	public ArrayList<MediaDTO> getMediaAll() throws Exception;

	public boolean insert(MediaDTO media) throws Exception;

	public boolean delete(int mcode) throws Exception;

	public boolean deleteAll() throws Exception;

	public boolean update(MediaDTO media) throws Exception;

	public boolean sellMedia(int mcode) throws Exception;
}
