package view;

import java.util.ArrayList;

import model.domain.CustomerDTO;
import model.domain.MediaDTO;

public class SuccessView {

	public static void successMsg(String msg) {
		System.out.println(msg);
	}
	
	public static void printAllMedia(ArrayList<MediaDTO> all) {
		int count = all.size();
		if(count != 0){
			for(int i = 0; i < count; i++){
				System.out.println(all.get(i));
			}
		}else{
			System.out.println("선택된 음악이 없습니다.");
		}
	}
	
	public static void printAllCustomer(ArrayList<CustomerDTO> all) {
		int count = all.size();
		if(count != 0){
			for(int i = 0; i < count; i++){
				System.out.println(all.get(i));
			}
		}else{
			System.out.println("고객 정보가 존재하지 않습니다.");
		}
	}
	
	public static void printMedia(MediaDTO media) {
		if(media != null){
			System.out.println(media);
		}else{
			System.out.println("검색하고자 하는 음료가 없습니다.");
		}
	}

	public static void printCustomer(CustomerDTO customer) {
		if(customer != null){
			System.out.println(customer);
		}else{
			System.out.println("검색하고자 하는 음료가 없습니다.");
		}
	}
	
}
