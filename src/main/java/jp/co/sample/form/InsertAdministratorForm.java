package jp.co.sample.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 管理者用のフォームクラス
 * @author matsunagadai
 *
 */
public class InsertAdministratorForm {
	@NotBlank(message="氏名を入力してください")
	private String name;
	@NotBlank(message="メールアドレスを入力してください")
	@Email(message="正しいメールアドレスを入力してください")
	private String mailAddress;
	@Size(min=1, max=127, message="パスワードを入力してください")
	private String password;
	
	//ゲッターセッター
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
				+ "]";
	}
}