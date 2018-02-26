package org.dselent.course_load_scheduler.client.service.impl;

import org.dselent.course_load_scheduler.client.action.SendGenerateAction;
import org.dselent.course_load_scheduler.client.action.SendHomeAction;
import org.dselent.course_load_scheduler.client.action.SendWishlistForUserAction;
import org.dselent.course_load_scheduler.client.callback.SendGenerateCallback;
import org.dselent.course_load_scheduler.client.callback.SendHomeCallback;
import org.dselent.course_load_scheduler.client.callback.SendWishlistForUserCallback;
import org.dselent.course_load_scheduler.client.event.SendGenerateEvent;
import org.dselent.course_load_scheduler.client.event.SendHomeEvent;
import org.dselent.course_load_scheduler.client.event.SendWishlistForUserEvent;
import org.dselent.course_load_scheduler.client.network.NetworkRequest;
import org.dselent.course_load_scheduler.client.network.NetworkRequestStrings;
import org.dselent.course_load_scheduler.client.service.GeneratorService;
import org.dselent.course_load_scheduler.client.translator.impl.SendGenerateActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendHomeActionTranslatorImpl;
import org.dselent.course_load_scheduler.client.translator.impl.SendWishlistForUserActionTranslatorImpl;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.json.client.JSONObject;

public class GeneratorServiceImpl extends BaseServiceImpl implements GeneratorService{
	public GeneratorServiceImpl() {}
	
	@Override
	public void init() {
		bind();
	}
	
	@Override
	public void bind() {
		HandlerRegistration homeRegistration;
		homeRegistration = eventBus.addHandler(SendHomeEvent.TYPE, this);
		eventBusRegistration.put(SendHomeEvent.TYPE, homeRegistration);
		
		HandlerRegistration generateRegistration;
		generateRegistration = eventBus.addHandler(SendGenerateEvent.TYPE, this);
		eventBusRegistration.put(SendGenerateEvent.TYPE, generateRegistration);
		
		HandlerRegistration wishlistUserRegistration;
		wishlistUserRegistration = eventBus.addHandler(SendWishlistForUserEvent.TYPE, this);
		eventBusRegistration.put(SendWishlistForUserEvent.TYPE, wishlistUserRegistration);
		
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
	public void onSendGenerate(SendGenerateEvent evt) {
		SendGenerateAction act = evt.getAction();
		SendGenerateActionTranslatorImpl generateActionTranslator = new SendGenerateActionTranslatorImpl();
		JSONObject json = generateActionTranslator.translateToJson(act);
		SendGenerateCallback generateCallback = new SendGenerateCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.CREATE_SCHEDULE_SET_INSTRUCTOR, generateCallback, json);
		request.send();
	}
	
	@Override
	public void onSendWishlistForUser(SendWishlistForUserEvent evt) {
		SendWishlistForUserAction act = evt.getAction();
		SendWishlistForUserActionTranslatorImpl generateWishlistTranslator = new SendWishlistForUserActionTranslatorImpl();
		JSONObject json = generateWishlistTranslator.translateToJson(act);
		SendWishlistForUserCallback wishlistCallback = new SendWishlistForUserCallback(eventBus, evt.getContainer());
		
		NetworkRequest request = new NetworkRequest(NetworkRequestStrings.GET_ALL_WISHLIST_SECTIONS_FOR_USER, wishlistCallback, json);
		request.send();
	}
}
