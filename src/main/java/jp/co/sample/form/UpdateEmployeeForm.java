package jp.co.sample.form;
/**
 * 従業員情報の更新のためのフォームクラス
 * @author matsunagadai
 *
 */
public class UpdateEmployeeForm {
	
	private String id;
	//扶養人数
	private String dependentsCount;
	
	//ゲッターセッター
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentsCount() {
		return dependentsCount;
	}
	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}
	
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
	}
}
