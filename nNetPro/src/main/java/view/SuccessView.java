package view;

import java.util.ArrayList;

import model.domain.MediaDTO;

public class SuccessView {

	public static void successMsg(String msg) {
		System.out.println(msg);
	}
	
	public static void printAll(ArrayList<MediaDTO> all) {
		int count = all.size();
		if(count != 0){
			for(int i = 0; i < count; i++){
				System.out.println(all.get(i));
			}
		}else{
			System.out.println("선택된 음료가 없습니다.");
		}
	}
	
	public static void printProduct(MediaDTO media) {
		if(media != null){
			System.out.println(media);
		}else{
			System.out.println("검색하고자 하는 음료가 없습니다.");
		}
	}

	
}
