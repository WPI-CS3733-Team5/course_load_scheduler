package org.dselent.course_load_scheduler.client;

import org.dselent.course_load_scheduler.client.gin.Injector;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CoursesPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ExamplePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.HomePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.NotificationsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ProfilePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleGeneratorPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.TabTestPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.WishlistPresenterImpl;
import org.dselent.course_load_scheduler.client.view.HomeView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.examples.ExamplesPanel;
import org.dselent.course_load_scheduler.client.view.impl.MenuTabsImpl;
import org.dselent.course_load_scheduler.client.view.impl.TabTest;

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
		RootLayoutPanel root = RootLayoutPanel.get();
		
		//SimplePanelExample simplePanelExample = new SimplePanelExample();
		//root.add(simplePanelExample);
		
		//SimplePanelExample2 simplePanelExample2 = new SimplePanelExample2();
		//root.add(simplePanelExample2);
		
		//HTMLPanelExample htmlPanelExample = new HTMLPanelExample();
		//root.add(htmlPanelExample);
		
		//FlowPanelExample flowPanelExample = new FlowPanelExample();
		//root.add(flowPanelExample);
		
		//VerticalPanelExample verticalPanelExample = new VerticalPanelExample();
		//root.add(verticalPanelExample);
		
		//HorizontalPanelExample horizontalPanelExample = new HorizontalPanelExample();
		//root.add(horizontalPanelExample);
		
		//DockLayoutPanelExample dockLayoutPanelExample = new DockLayoutPanelExample();
		//root.add(dockLayoutPanelExample);
		
		//GridExample gridExample = new GridExample();
		//root.add(gridExample);

		//TabLayoutPanelExample tabLayoutPanelExample = new TabLayoutPanelExample();
		//root.add(tabLayoutPanelExample);
		
		//ExamplesPanel examplesPanel = new ExamplesPanel();
		//root.add(examplesPanel);

		// Get the injector, which injected objects can be retrieved from
		final Injector injector = Injector.INSTANCE;
		
		IndexPresenterImpl indexPresenter = injector.getIndexPresenter(); // on-demand injection
		indexPresenter.init();
		IndexView indexView = indexPresenter.getView();	
		
//		HomePresenterImpl homePresenter = injector.getHomePresenterImpl();
//		homePresenter.init();
//		
//		CoursesPresenterImpl coursePresenter = injector.getCoursesPresenterImpl();
//		coursePresenter.init();
//		
//		WishlistPresenterImpl wishlistPresenter = injector.getWishlistPresenterImpl();
//		wishlistPresenter.init();
//		
//		ScheduleGeneratorPresenterImpl schedulerGeneratorPresenter = injector.getScheduleGeneratorPresenterImpl();
//		schedulerGeneratorPresenter.init();
//		
//		AccountsPresenterImpl accountsPresenter = injector.getAccountsPresenterImpl();
//		accountsPresenter.init();
//		
//		MenuTabsPresenterImpl menuTabs = injector.getMenuTabsPresenterImpl();
//		menuTabs.init();
//		
//		NotificationsPresenterImpl notificationPresenter = injector.getNotificationsPresenterImpl();
//		notificationPresenter.init();
//		
//		ProfilePresenterImpl profilePresenter = injector.getProfilePresenterImpl();
//		profilePresenter.init();
//				
//		LoginPresenterImpl loginPresenter = injector.getLoginPresenter();
//		loginPresenter.init();
//		loginPresenter.go(indexView.getViewRootPanel());
//		
//		//TabTestPresenterImpl tabTestPresenter = injector.getTestTabPresenter();
//		//tabTestPresenter.init();
//		
//		//LoginView loginView = loginPresenter.getView();	
//		
//		//ExamplePresenterImpl examplePresenter = injector.getExamplePresenter();
//		//examplePresenter.init();
//		
//		UserServiceImpl userService = injector.getUserService();
//		userService.init();
		
		indexPresenter.go(root);
		//MenuTabsPresenter.go(indexView.getViewRootPanel());
		
		//MenuTabsPresenterImpl menuTabs = injector.getMenuTabsPresenter();
		//menuTabs.init();
		//menuTabs.go(indexView.getViewRootPanel());
		
		TabTest tt = new TabTest();
		root.add(tt);
	}
}
