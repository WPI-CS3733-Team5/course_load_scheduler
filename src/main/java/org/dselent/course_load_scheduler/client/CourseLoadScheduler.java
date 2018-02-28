package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CoursesPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.HomePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.service.impl.GeneratorServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.MenuServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.NotificationsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ProfilePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleGeneratorPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.WishlistPresenterImpl;
import org.dselent.course_load_scheduler.client.view.IndexView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CourseLoadScheduler implements EntryPoint
{

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		// Get the injector, which injected objects can be retrieved from
		final Injector injector = Injector.INSTANCE;
		
		RootLayoutPanel root = RootLayoutPanel.get();
		
		
		UserServiceImpl userService = injector.getUserService();
		userService.init();
		
		MenuServiceImpl menuService = injector.getMenuService();
		menuService.init();
	
		GeneratorServiceImpl generatorService = injector.getGeneratorService();
		generatorService.init();

		
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter();
		indexPresenter.init();
		IndexView indexView = indexPresenter.getView();	
		
		MenuTabsPresenterImpl menuTabsPresenter = injector.getMenuTabsPresenterImpl();
		menuTabsPresenter.init();
		menuTabsPresenter.setParentPresenter(indexPresenter);
		
		LoginPresenterImpl loginPresenter = injector.getLoginPresenter();
		loginPresenter.init();
		loginPresenter.setParentPresenter(indexPresenter);
		
		HomePresenterImpl homePresenter = injector.getHomePresenterImpl();
		homePresenter.init();
		homePresenter.setParentPresenter(indexPresenter);
		
		CoursesPresenterImpl coursePresenter = injector.getCoursesPresenterImpl();
		coursePresenter.init();
		coursePresenter.setParentPresenter(indexPresenter);
		
		WishlistPresenterImpl wishlistPresenter = injector.getWishlistPresenterImpl();
		wishlistPresenter.init();
		wishlistPresenter.setParentPresenter(indexPresenter);
		
		ScheduleGeneratorPresenterImpl schedulerGeneratorPresenter = injector.getScheduleGeneratorPresenterImpl();
		schedulerGeneratorPresenter.init();
		schedulerGeneratorPresenter.setParentPresenter(indexPresenter);
		
		AccountsPresenterImpl accountsPresenter = injector.getAccountsPresenterImpl();
		accountsPresenter.init();
		accountsPresenter.setParentPresenter(indexPresenter);	
		
		NotificationsPresenterImpl notificationPresenter = injector.getNotificationsPresenterImpl();
		notificationPresenter.init();
		notificationPresenter.setParentPresenter(indexPresenter);
		
		ProfilePresenterImpl profilePresenter = injector.getProfilePresenterImpl();
		profilePresenter.init();
		profilePresenter.setParentPresenter(indexPresenter);
		
		
		
		indexPresenter.go(root);
		menuTabsPresenter.go(indexView.getMenuTabsPanel());
		loginPresenter.go(indexView.getMainPanel());

	}
}
