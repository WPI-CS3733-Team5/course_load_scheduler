package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendAccountsAction;
import org.dselent.course_load_scheduler.client.action.SendCoursesAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendProfileAction;
import org.dselent.course_load_scheduler.client.action.SendSchedulesAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistAction;
import org.dselent.course_load_scheduler.client.callback.SendAccountsCallback;
import org.dselent.course_load_scheduler.client.callback.SendCoursesCallback;
import org.dselent.course_load_scheduler.client.callback.SendHomeCallback;
import org.dselent.course_load_scheduler.client.callback.SendProfileCallback;
import org.dselent.course_load_scheduler.client.callback.SendSchedulesCallback;
import org.dselent.course_load_scheduler.client.callback.SendWishlistCallback;
import org.dselent.course_load_scheduler.client.event.SendAccountsEvent;
import org.dselent.course_load_scheduler.client.event.SendCoursesEvent;
import org.dselent.course_load_scheduler.client.event.SendFetchListEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendProfileEvent;
import org.dselent.course_load_scheduler.client.event.SendSchedulesEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.MenuService;
import org.dselent.course_load_scheduler.client.translator.impl.SendAccountsActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendCoursesActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendHomeActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendProfileActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendSchedulesActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendWishlistActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class MenuServiceImpl extends BaseServiceImpl implements MenuService
{
	public MenuServiceImpl()
	{
		
	}
	
	@Override
	public void init()
	{
		bind();
	}

	@Override
	public void bind()
	{	
		HandlerRegistration homeRegistration;
		homeRegistration = eventBus.addHandler(SendHomeEvent.TYPE, this);
		eventBusRegistration.put(SendHomeEvent.TYPE, homeRegistration);

		HandlerRegistration profileRegistration;
		profileRegistration = eventBus.addHandler(SendProfileEvent.TYPE, this);
		eventBusRegistration.put(SendProfileEvent.TYPE, profileRegistration);
		
		HandlerRegistration notificationsRegistration;
		notificationsRegistration = eventBus.addHandler(SendFetchListEvent.TYPE, this);
		eventBusRegistration.put(SendFetchListEvent.TYPE, notificationsRegistration);
		
		HandlerRegistration wishlistRegistration;
		wishlistRegistration = eventBus.addHandler(SendWishlistEvent.TYPE, this);
		eventBusRegistration.put(SendWishlistEvent.TYPE, wishlistRegistration);
		
		HandlerRegistration coursesRegistration;
		coursesRegistration = eventBus.addHandler(SendCoursesEvent.TYPE, this);
		eventBusRegistration.put(SendCoursesEvent.TYPE, coursesRegistration);
		
		HandlerRegistration accountsRegistration;
		accountsRegistration = eventBus.addHandler(SendAccountsEvent.TYPE, this);
		eventBusRegistration.put(SendAccountsEvent.TYPE, accountsRegistration);
		
		HandlerRegistration schedulesRegistration;
		schedulesRegistration = eventBus.addHandler(SendSchedulesEvent.TYPE, this);
		eventBusRegistration.put(SendSchedulesEvent.TYPE, schedulesRegistration);
	}
	
	@Override
	public void onSendHome(SendHomeEvent evt) {
		SendHomeAction action = evt.getAction();
		SendHomeActionTranslatorImpl homeActionTranslator = new SendHomeActionTranslatorImpl();
		JSONObject json = homeActionTranslator.translateToJson(action);
		SendHomeCallback homeCallback = new SendHomeCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ALL_USER_INSTRUCTOR_COURSE_SECTION_LAB_CALENDAR_SCHEDULE_INFO, homeCallback, json);
		request.send();
	}
	
	@Override
	public void onSendProfile(SendProfileEvent evt) {
		SendProfileAction action = evt.getAction();
		SendProfileActionTranslatorImpl profileActionTranslator = new SendProfileActionTranslatorImpl();
		JSONObject json = profileActionTranslator.translateToJson(action);
		SendProfileCallback profileCallback = new SendProfileCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ONE_USER_AND_INSTRUCTOR_INFO, profileCallback, json);
		request.send();
	}
	
	@Override
	public void onSendWishlist(SendWishlistEvent evt) {
		SendWishlistAction action = evt.getAction();
		SendWishlistActionTranslatorImpl wishlistActionTranslator = new SendWishlistActionTranslatorImpl();
		JSONObject json = wishlistActionTranslator.translateToJson(action);
		SendWishlistCallback wishlistCallback = new SendWishlistCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ALL_COURSE_SECTION_LAB_CALENDAR_INFO, wishlistCallback, json);
		request.send();
	}
	
	@Override
	public void onSendCourses(SendCoursesEvent evt) {
		SendCoursesAction action = evt.getAction();
		SendCoursesActionTranslatorImpl coursesActionTranslator = new SendCoursesActionTranslatorImpl();
		JSONObject json = coursesActionTranslator.translateToJson(action);
		SendCoursesCallback coursesCallback = new SendCoursesCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ALL_COURSE_SECTION_LAB_CALENDAR_INFO, coursesCallback, json);
		request.send();
	}
	
	@Override
	public void onSendAccounts(SendAccountsEvent evt) {
		SendAccountsAction action = evt.getAction();
		SendAccountsActionTranslatorImpl accountsActionTranslator = new SendAccountsActionTranslatorImpl();
		JSONObject json = accountsActionTranslator.translateToJson(action);
		SendAccountsCallback accountsCallback = new SendAccountsCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ALL_USER_AND_INSTRUCTOR_INFO, accountsCallback, json);
		request.send();
	}
	
	@Override
	public void onSendSchedules(SendSchedulesEvent evt) {
		SendSchedulesAction action = evt.getAction();
		SendSchedulesActionTranslatorImpl schedulesActionTranslator = new SendSchedulesActionTranslatorImpl();
		JSONObject json = schedulesActionTranslator.translateToJson(action);
		
		SendSchedulesCallback schedulesCallback = new SendSchedulesCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ALL_USER_INSTRUCTOR_COURSE_SECTION_LAB_CALENDAR_SCHEDULE_INFO, schedulesCallback, json);

		request.send();
	}
}