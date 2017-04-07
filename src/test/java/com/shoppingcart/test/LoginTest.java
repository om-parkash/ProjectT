package com.shoppingcart.test;

import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.shoppingcart.domain.UserMaster;
import com.shoppingcart.exception.ServiceException;
import com.shoppingcart.service.UserMasterService;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

	@Mock
	UserMasterService masterService;

	@Before
	public void setUp() throws Exception {
		UserMaster user = new UserMaster();
		user.setFirstName("naresh");
		when(masterService.fetchUserMasterByUserNamePassword("naresh", "1234")).thenReturn(user);
	}

	@Test
	public void testLogin() throws ServiceException {
		Assert.assertEquals(masterService.fetchUserMasterByUserNamePassword("naresh", "1234").getFirstName(), "naresh");
	}

}
