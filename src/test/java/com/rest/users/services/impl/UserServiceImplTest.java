package com.rest.users.services.impl;

import com.rest.users.models.User;
import com.rest.users.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    UserServiceCheck serviceCheck;

    @Mock
    UserRepository repository;

    @Mock
    UserServiceImpl service;

    private User user;

    @Before
    public void populateTests() {
        user = new User();
        user.setId(1L);
        user.setName("Test");
        user.setBirthday(new Date());
    }

    @Test
    public void testGetByIdUser() {
        when(repository.findOne(anyLong())).thenReturn(user);

        User userResp = serviceCheck.getById(1L);

        verify(repository, atLeastOnce()).findOne(anyLong());
        assertThat(userResp.getName(), equalTo("Test"));
    }

    @Test
    public void testSaveUser() {
        when(repository.save(user)).thenReturn(user);

        serviceCheck.save(user);
        service.checkSave(user);

        verify(repository, times(1)).save(user);
        verify(service, times(1)).checkSave(user);
    }

    @Test
    public void testSaveUserReturnNull() {
        when(repository.save(user)).thenReturn(null);

        serviceCheck.save(user);
        service.checkSave(user);

        verify(repository, times(1)).save(user);
        verify(service, times(1)).checkSave(user);
    }

}