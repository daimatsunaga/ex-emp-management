package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;
/**
 * 管理者用のリポジトリ
 * @author matsunagadai
 *
 */
@Repository
public class AdministratorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER
	= (rs, i) -> {
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mail_address"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	
	/**
	 * 管理者を登録する。idに重複がある場合は更新
	 * @param administrator
	 */
	public void insert(Administrator administrator) {
		if(administrator.getId() == null) {
			String insertSql = "INSERT INTO administrators(name, mail_address, password)VALUES(:name, :mailAdress, :password)";
			SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", administrator.getName())
				.addValue("mailAdress", administrator.getMailAddress())
				.addValue("password", administrator.getPassword());
			template.update(insertSql, param);
		} else {
			String updateSql = "UPDATE administrators SET name = :name, mail_address = :mailAdress, password = :password WHERE id = :id";
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("name", administrator.getName())
					.addValue("mailAdress", administrator.getMailAddress())
					.addValue("password", administrator.getPassword());
			template.update(updateSql, param);
				
		}
	}
	
	/**
	 * 管理者じょうほうをメールアドレスとパスワードから検索
	 * @param mailAddress
	 * @param password
	 * @return 管理者情報１件
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		String sql = "SELECT * FROM administrators WHERE mail_address = :mailAddress AND password = :password";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("mailAddress", mailAddress)
				.addValue("password", password);
		
		List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		if(administratorList.size() == 0) {
			return null;
		}
		return administratorList.get(0);
	}
}
