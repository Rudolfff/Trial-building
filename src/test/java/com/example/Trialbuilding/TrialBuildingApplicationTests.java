package com.example.Trialbuilding;

import com.example.Trialbuilding.DAO.GoodsDAO;
import com.example.Trialbuilding.DAO.GoodsDAOTest;
import com.example.Trialbuilding.DAO.OrderDAOTest;
import com.example.Trialbuilding.controller.GoodsControllerTest;
import com.example.Trialbuilding.controller.OrderControllerTest;
import com.example.Trialbuilding.service.GoodsService;
import com.example.Trialbuilding.service.GoodsServiceTest;
import com.example.Trialbuilding.service.OrderServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrialBuildingApplicationTests {

	OrderDAOTest orderDAOTest;
	GoodsDAOTest goodsDAOTest;
	OrderServiceTest orderServiceTest;
	GoodsServiceTest goodsServiceTest;
	OrderControllerTest orderControllerTest;
	GoodsControllerTest goodsControllerTest;
	public TrialBuildingApplicationTests() {
		OrderDAOTest orderDAOTest = new OrderDAOTest();
		GoodsDAOTest goodsDAOTest = new GoodsDAOTest();
		OrderServiceTest orderServiceTest = new OrderServiceTest();
		GoodsServiceTest goodsServiceTest = new GoodsServiceTest();
		OrderControllerTest orderControllerTest = new OrderControllerTest();
		GoodsControllerTest goodsControllerTest = new GoodsControllerTest();
	}
	@Test
	public void allTests() {
	}

}
