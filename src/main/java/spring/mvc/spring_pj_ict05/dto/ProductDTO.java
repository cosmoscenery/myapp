package spring.mvc.spring_pj_ict05.dto;

import java.sql.Date;

public class ProductDTO {

	private int pdNo;			// 상품번호
	private String pdName;  	// 상품명
	private String pdBrand;		// 상품브랜드
	private String pdImg;		// 상품이미지
	private String pdCategory;	// 상품카테고리
	private String pdContent;	// 상품설명
	private int pdPrice;		// 상품가격
	private int pdQuantity;		// 상품등록 수량
	private String pdStatus;	// 상품상태코드
	private Date pdIndate;		// 상품등록일
	
	public ProductDTO() {}

	public ProductDTO(int pdNo, String pdName, String pdBrand, String pdImg, String pdCategory, String pdContent,
			int pdPrice, int pdQuantity, String pdStatus, Date pdIndate) {
		this.pdNo = pdNo;
		this.pdName = pdName;
		this.pdBrand = pdBrand;
		this.pdImg = pdImg;
		this.pdCategory = pdCategory;
		this.pdContent = pdContent;
		this.pdPrice = pdPrice;
		this.pdQuantity = pdQuantity;
		this.pdStatus = pdStatus;
		this.pdIndate = pdIndate;
	}

	public int getPdNo() {
		return pdNo;
	}

	public void setPdNo(int pdNo) {
		this.pdNo = pdNo;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public String getPdBrand() {
		return pdBrand;
	}

	public void setPdBrand(String pdBrand) {
		this.pdBrand = pdBrand;
	}

	public String getPdImg() {
		return pdImg;
	}

	public void setPdImg(String pdImg) {
		this.pdImg = pdImg;
	}

	public String getPdCategory() {
		return pdCategory;
	}

	public void setPdCategory(String pdCategory) {
		this.pdCategory = pdCategory;
	}

	public String getPdContent() {
		return pdContent;
	}

	public void setPdContent(String pdContent) {
		this.pdContent = pdContent;
	}

	public int getPdPrice() {
		return pdPrice;
	}

	public void setPdPrice(int pdPrice) {
		this.pdPrice = pdPrice;
	}

	public int getPdQuantity() {
		return pdQuantity;
	}

	public void setPdQuantity(int pdQuantity) {
		this.pdQuantity = pdQuantity;
	}

	public String getPdStatus() {
		return pdStatus;
	}

	public void setPdStatus(String pdStatus) {
		this.pdStatus = pdStatus;
	}

	public Date getPdIndate() {
		return pdIndate;
	}

	public void setPdIndate(Date pdIndate) {
		this.pdIndate = pdIndate;
	}

	@Override
	public String toString() {
		return "ProductDTO [pdNo=" + pdNo + ", pdName=" + pdName + ", pdBrand=" + pdBrand + ", pdImg=" + pdImg
				+ ", pdCategory=" + pdCategory + ", pdContent=" + pdContent + ", pdPrice=" + pdPrice + ", pdQuantity="
				+ pdQuantity + ", pdStatus=" + pdStatus + ", pdIndate=" + pdIndate + "]";
	}
	
}
