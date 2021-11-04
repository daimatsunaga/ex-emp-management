package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Employee;

/**
 *　従業員用リポジトリ
 * @author matsunagadai
 *
 */
@Repository
public class EmployeeRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = new BeanPropertyRowMapper<>(Employee.class);
	
	/**
	 * idから従業員を検索（１件）
	 * @param id
	 * @return　従業員１件分の情報
	 */
	public Employee load(Integer id) {
		String loadSql = "SELECT * FROM employees WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Employee employee = template.queryForObject(loadSql, param, EMPLOYEE_ROW_MAPPER);
		return employee;
	}
	/**
	 * 全従業員を取得　入社日を降順
	 * @return　全従業員データ
	 */
	public List<Employee> findAll() {
		String sql = "SELECT * FROM employees ORDER BY hire_date DESC;";
		List<Employee> employeeList = template.query(sql, EMPLOYEE_ROW_MAPPER);
		return employeeList;
	}
	/**
	 * idが存在した場合更新、ない場合挿入
	 * @param employee
	 */
	public void update(Employee employee) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		System.out.println(employee);
//		if(employee.getId() == null) {
//			String insertSql = "INSERT INTO employees VALUES(:id,:name,:image,:gender,:hireDate,:mailAddress,:zipCode,:address,:telephone,:salary,:characteristic,:dependentsCount);";
//			template.update(insertSql, param);
//		} else {
			String updateSql = "UPDATE employees "
					+ "SET name=:name, image=:image, gender=:gender"
					+ ", hire_date=:hireDate, mail_address=:mailAddress"
					+ ", zip_code=:zipCode, address=:address, telephone=:telephone"
					+ ", salary=:salary, characteristics=:characteristics, dependents_count=:dependentsCount "
					+ "WHERE id=:id;";
			template.update(updateSql, param);
//		}
	}
}