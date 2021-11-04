package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;
/**
 * 従業員情報に関するサービスクラス
 * @author matsunagadai
 *
 */
@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository enEmployeeRepository;
	
	/**
	 * 従業員情報を全件取得する。
	 * @return
	 */
	public List<Employee> showLits() {
		return enEmployeeRepository.findAll();
	}
}
