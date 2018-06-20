package com.nyeong;

import com.nyeong.entity.Participants;
import com.nyeong.entity.Pin;
import com.nyeong.entity.Plan;
import com.nyeong.entity.Route;
import com.nyeong.enums.ParticipantAuthorizationType;
import com.nyeong.enums.PinStatus;
import com.nyeong.enums.PlanType;
import com.nyeong.enums.Transportation;
import com.nyeong.mapper.ParticipantMapper;
import com.nyeong.mapper.PinMapper;
import com.nyeong.mapper.PlanMapper;
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


}
