package jp.co.sample.domain;

import java.sql.Date;

/**
 * 従業員情報を表すドメイン
 * @author matsunagadai
 *
 */
public class Employee {
	private Integer id;
	private String name;
	private String image;
	private String gender;
	//入社日
	private Date hireDate;
	private String mailAddress;
	//郵便番号
	private String zipCord;
	private String address;
	private String telephone;
	private Integer salary;
	//特性
	private String characteristics;
	//扶養人数
	private Integer dependentsCount;
	
	//コンストラクタ
	public Employee() {}

	public Employee(Integer id, String name, String image, String gender, Date hireDate, String mailAddress,
			String zipCord, String address, String telephone, Integer salary, String characteristics,
			Integer dependentsCount) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.gender = gender;
		this.hireDate = hireDate;
		this.mailAddress = mailAddress;
		this.zipCord = zipCord;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		this.characteristics = characteristics;
		this.dependentsCount = dependentsCount;
	}

	//ゲッターセッター
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCord() {
		return zipCord;
	}

	public void setZipCord(String zipCord) {
		this.zipCord = zipCord;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Integer getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	//toStringのオーバーライド
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hireDate="
				+ hireDate + ", mailAddress=" + mailAddress + ", zipCord=" + zipCord + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}	
}
