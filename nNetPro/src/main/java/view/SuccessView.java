package view;

import java.util.ArrayList;

import model.domain.CustomerDTO;
import model.domain.MediaDTO;

public class SuccessView {

	public static void successMsg(String msg) {
		System.out.println(msg);
	}
	
	public static void printAllMedia(ArrayList<MediaDTO> all) {
		System.out.println("음원번호\t|\t음원명\t| 가수\t|다운로드수| 가격\t| 연령제한");
		System.out.println("-------------------------------------------------");
		int count = all.size();
		if(count != 0){
			for(int i = 0; i < count; i++){
				System.out.println(all.get(i));
			}
		}else{
			System.out.println("선택된 음악이 없습니다.");
		}
		System.out.println("-------------------------------------------------");
	}
	
	public static void printAllCustomer(ArrayList<CustomerDTO> all) {
		System.out.println("고객번호\t\t| 성명\t| 나이\t| 보유금액\t| 보유음원");
		System.out.println("-------------------------------------------------");
		int count = all.size();
		if(count != 0){
			for(int i = 0; i < count; i++){
				System.out.println(all.get(i));
			}
		}else{
			System.out.println("고객 정보가 존재하지 않습니다.");
		}
		System.out.println("-------------------------------------------------");
	}
	
	public static void printMedia(MediaDTO media) {
		System.out.println("음원번호\t|\t 음원명\t| 가수\t|다운로드수| 가격\t| 연령제한");
		System.out.println("-------------------------------------------------");
		if(media != null){
			System.out.println(media);
		}else{
			System.out.println("검색하고자 하는 음료가 없습니다.");
		}
		System.out.println("-------------------------------------------------");
	}

	public static void printCustomer(CustomerDTO customer) {
		System.out.println("고객번호\t\t| 성명\t| 나이\t| 보유금액\t| 보유음원");
		System.out.println("-------------------------------------------------");
		if(customer != null){
			System.out.println(customer);
		}else{
			System.out.println("검색하고자 하는 음료가 없습니다.");
		}
		System.out.println("-------------------------------------------------");
	}
	
}
