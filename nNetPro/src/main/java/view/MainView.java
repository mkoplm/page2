package view;

import controller.Controller;
import model.domain.CustomerDTO;
import model.domain.MediaDTO;

public class MainView {
	
	public static void main(String[] args) {
		
		System.out.println("*** 이전 테이블 내용 삭제");
		Controller.deleteAll();
		
		System.out.println("********************** 테이블 추가 **********************");
		Controller.insert(new MediaDTO(1000,"야생화","박효신",1,500,19));
		Controller.insert(new MediaDTO(1001,"그런 남자","Bro",1,300,19));
		Controller.insert(new MediaDTO(1002,"썸(Feat.릴보이 Of 긱스)","소유,정기고",1,600,19));
//		Controller.insert(new MediaDTO(1003,"흔한 노래","임창정",1,500,19));
//		Controller.insert(new MediaDTO(1004,"Come Back Home","2NE1",1,300,19));
//		Controller.insert(new MediaDTO(1005,"까탈레나(Catallena)","오렌지 캬라멜",1,400,19));
//		Controller.insert(new MediaDTO(1006,"감아(Feat, Crush","로꼬",1,500,19));
//		Controller.insert(new MediaDTO(1007,"벚꽃 엔딩","버스커 버스커",1,500,19));
//		Controller.insert(new MediaDTO(1008,"Mr.Mr","소녀시대",1,600,19));
//		Controller.insert(new MediaDTO(1009,"그중에 그대를 만나","이선희",1,300,19));
		
		Controller.insert(new CustomerDTO("custemer00","김세윤",24,7000,2000));
		Controller.insert(new CustomerDTO("custemer01","김유리",24,9000,2001));
		Controller.insert(new CustomerDTO("custemer02","김의태",28,2000,2002));
//		Controller.insert(new CustomerDTO("custemer03","이규혁",29,6000,2003));
//		Controller.insert(new CustomerDTO("custemer04","김정환",30,8000,2004));
//		Controller.insert(new CustomerDTO("custemer05","김현수",28,10000,2005));
//		Controller.insert(new CustomerDTO("custemer06","남궁준",24,12000,2006));
//		Controller.insert(new CustomerDTO("custemer07","배은지",25,7000,2007));
//		Controller.insert(new CustomerDTO("custemer08","여인률",27,5000,2008));
//		Controller.insert(new CustomerDTO("custemer09","유병찬",27,1000,2009));
		 
		System.out.println("********************** 전체목록 조회 **********************");
		Controller.getMediaAll();
		System.out.println();
		Controller.selectAllCustomer();
		
		System.out.println("**************** 고객 정보 조회(custemer02) *****************");
		Controller.getCustomer("custemer02");
		
		System.out.println("**************** 고객 정보 변경(custemer02) / 검색 *****************");
		Controller.updateCustomer("custemer02", 300000);
		Controller.getCustomer("custemer02");
		
		System.out.println("************************ 음원 구매 ************************");
		Controller.buyMedia("custemer02", 300, 1002);
		System.out.println("**************** 음원 구매 후 고객정보 및 음원정보 조회 ***************");
		Controller.getCustomer("custemer02");
		Controller.getMedia(1002);
		
		System.out.println("******************** 음원 정보 삭제 후 조회(1001) ********************");
		Controller.delete(1001);
		Controller.getMediaAll();
	}
}
