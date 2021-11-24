package com.edu.spring.model;

/*
 * data 가공과 관련있는 레이어
 * 주로 Service Layer에서 트랜잭션 처리를 한다.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.spring.domain.MyProduct;

@Service
@Transactional
public class MyProductServiceImpl implements MyProductService{
	
	@Autowired
	private MyProductDAO myproductDAO;

	@Transactional
	@Override
	public int addProduct(MyProduct vo) throws Exception {
		int result=myproductDAO.addProduct(vo);
		return result;
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return myproductDAO.findProducts();
	}

	@Override
	public List<MyProduct> findProductByName(String name) throws Exception {
		return myproductDAO.findProductByName(name);
	}

	@Override
	public List<MyProduct> findProductByMaker(String maker) throws Exception {
		return myproductDAO.findProductByMaker(maker);
	}

}
