package com.nyeong;

import com.nyeong.entity.Participants;
import com.nyeong.entity.Pin;
import com.nyeong.entity.Plan;
import com.nyeong.entity.Route;
import com.nyeong.enums.ParticipantAuthorizationType;
import com.nyeong.enums.PinStatus;
import com.nyeong.enums.PlanType;
import com.nyeong.enums.Transportation;
import com.nyeong.mapper.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.plugin2.message.transport.Transport;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration

public class NyeongjinApplicationTests {

	@Test
	public void contextLoads() {

	}

//	@Autowired
//	private  ParticipantMapper participantMapper;
//
//	@Test
//	public void testParticipantMapper(){
//		Participants participants=new Participants(1,1,ParticipantAuthorizationType.CREATE);
//		int result=participantMapper.insert(participants);
//		Assert.assertEquals(1,result);
//
//		Participants participants1=new Participants(1);
//		List<Participants> participants2=participantMapper.getByPlanId(participants1);
//		Assert.assertEquals(1,participants2.size());
//
//		Participants participants3=new Participants(1,1);
//		Participants participants4=participantMapper.getByPlanIdAndParticipantId(participants3);
//		Assert.assertEquals(participants4.getPlanID(),1);
//
//		int PlanID=participantMapper.getPlanIDByuserID(1);
//		Assert.assertEquals(1,PlanID);
//
//		int results=participantMapper.updateParticipants(new Participants(2,1));
//		Assert.assertEquals(1,results);
//	}
//

//	@Autowired
//	PlanMapper planMapper;
//
//	@Test
//	public void testPlanMapper(){
//		Plan plan=new Plan("hello",PlanType.PUBLIC,new Date(),new Date(), Transportation.WALK);
//		planMapper.insert(plan);
//
//		Plan plan=planMapper.getByPlanIds(11);
//		Assert.assertEquals(plan.getPlanID(),11);
//
//		Plan plan1=new Plan(11,"hellos",PlanType.PUBLIC,new Date(),new Date(), Transportation.WALK);
//		planMapper.update(plan1);
//
//		List<Route> routes=planMapper.getAllRouteByPlanID(1);
//		Assert.assertEquals(routes.size(),2);
//	}

//	@Autowired
//	PlatMapper platMapper;
//
//	@Test
//	public void testPlatMapper(){
//
//	}

//	@Autowired
//	RouteMapper routeMapper;
//
//	@Test
//	public void testRouteMapper(){

		//routeMapper.insert(route);
//		Route route=new Route(1);
//		List<Route> routes=routeMapper.getRoutesByPlanId(route);
//		Assert.assertEquals(3,routes.size());
//		Route route=new Route(4,1,0,3,Transportation.WALK,100,true,false);
//		routeMapper.updateByRouteId(route);
//		Route route=new Route(0,0,0,3,Transportation.WALK,100,true,false);
//		Route route1=routeMapper.getRouteByOriginAndDestination(route);
//		Assert.assertEquals(5,route1.getRouteID());
//	}

	@Autowired PinMapper pinMapper;

	@Test
	public void testPinMapper(){
		Pin pin=new Pin(1,31.14,120.5,"东方明珠",new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),PinStatus.WANTED,"");
		pinMapper.insert(pin);
	}
}
