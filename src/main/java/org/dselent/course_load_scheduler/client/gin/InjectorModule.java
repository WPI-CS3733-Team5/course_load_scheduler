package org.dselent.course_load_scheduler.client.gin;

import org.dselent.course_load_scheduler.client.model.GlobalData;
import org.dselent.course_load_scheduler.client.presenter.AccountsPresenter;
import org.dselent.course_load_scheduler.client.presenter.CoursesPresenter;
import org.dselent.course_load_scheduler.client.presenter.HomePresenter;
import org.dselent.course_load_scheduler.client.presenter.IndexPresenter;
import org.dselent.course_load_scheduler.client.presenter.LoginPresenter;
import org.dselent.course_load_scheduler.client.presenter.MenuTabsPresenter;
import org.dselent.course_load_scheduler.client.presenter.NotificationsPresenter;
import org.dselent.course_load_scheduler.client.presenter.ProfilePresenter;
import org.dselent.course_load_scheduler.client.presenter.ScheduleGeneratorPresenter;
import org.dselent.course_load_scheduler.client.presenter.WishlistPresenter;
import org.dselent.course_load_scheduler.client.presenter.impl.AccountsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.CoursesPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.HomePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.IndexPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.LoginPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.MenuTabsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.NotificationsPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ProfilePresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.ScheduleGeneratorPresenterImpl;
import org.dselent.course_load_scheduler.client.presenter.impl.WishlistPresenterImpl;
import org.dselent.course_load_scheduler.client.service.GeneratorService;
import org.dselent.course_load_scheduler.client.service.MenuService;
import org.dselent.course_load_scheduler.client.service.UserService;
import org.dselent.course_load_scheduler.client.service.impl.GeneratorServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.MenuServiceImpl;
import org.dselent.course_load_scheduler.client.service.impl.UserServiceImpl;
import org.dselent.course_load_scheduler.client.view.AccountsView;
import org.dselent.course_load_scheduler.client.view.CoursesView;
import org.dselent.course_load_scheduler.client.view.HomeView;
import org.dselent.course_load_scheduler.client.view.IndexView;
import org.dselent.course_load_scheduler.client.view.LoginView;
import org.dselent.course_load_scheduler.client.view.MenuTabs;
import org.dselent.course_load_scheduler.client.view.NotificationsView;
import org.dselent.course_load_scheduler.client.view.ProfileView;
import org.dselent.course_load_scheduler.client.view.ScheduleGeneratorView;
import org.dselent.course_load_scheduler.client.view.WishlistView;
import org.dselent.course_load_scheduler.client.view.impl.AccountsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.CoursesViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.HomeViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.IndexViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.LoginViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.MenuTabsImpl;
import org.dselent.course_load_scheduler.client.view.impl.NotificationsViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ProfileViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.ScheduleGeneratorViewImpl;
import org.dselent.course_load_scheduler.client.view.impl.WishlistViewImpl;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Module where all to-be-injected dependencies are defined
 * 
 * @author dselent
 *
 */
public class InjectorModule extends AbstractGinModule
{
	@Override
    protected void configure()
    {
		// event bus
        bind(SimpleEventBus.class).in(Singleton.class);
        
        // presenters
        bind(IndexPresenter.class).to(IndexPresenterImpl.class).in(Singleton.class);
        bind(LoginPresenter.class).to(LoginPresenterImpl.class).in(Singleton.class);
        bind(AccountsPresenter.class).to(AccountsPresenterImpl.class).in(Singleton.class);
        bind(CoursesPresenter.class).to(CoursesPresenterImpl.class).in(Singleton.class);
        bind(HomePresenter.class).to(HomePresenterImpl.class).in(Singleton.class);
        bind(MenuTabsPresenter.class).to(MenuTabsPresenterImpl.class).in(Singleton.class);
        bind(NotificationsPresenter.class).to(NotificationsPresenterImpl.class).in(Singleton.class);
        bind(ProfilePresenter.class).to(ProfilePresenterImpl.class).in(Singleton.class);
        bind(ScheduleGeneratorPresenter.class).to(ScheduleGeneratorPresenterImpl.class).in(Singleton.class);
        bind(WishlistPresenter.class).to(WishlistPresenterImpl.class).in(Singleton.class);

        // views
        bind(IndexView.class).to(IndexViewImpl.class).in(Singleton.class);
        bind(LoginView.class).to(LoginViewImpl.class).in(Singleton.class);
        bind(AccountsView.class).to(AccountsViewImpl.class).in(Singleton.class);
        bind(CoursesView.class).to(CoursesViewImpl.class).in(Singleton.class);
        bind(HomeView.class).to(HomeViewImpl.class).in(Singleton.class);
        bind(MenuTabs.class).to(MenuTabsImpl.class).in(Singleton.class);
        bind(NotificationsView.class).to(NotificationsViewImpl.class).in(Singleton.class);
        bind(ProfileView.class).to(ProfileViewImpl.class).in(Singleton.class);
        bind(ScheduleGeneratorView.class).to(ScheduleGeneratorViewImpl.class).in(Singleton.class);
        bind(WishlistView.class).to(WishlistViewImpl.class).in(Singleton.class);

        
		// services
        bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);
        bind(MenuService.class).to(MenuServiceImpl.class).in(Singleton.class);
        bind(GeneratorService.class).to(GeneratorServiceImpl.class).in(Singleton.class);
        
        // global data
        bind(GlobalData.class).in(Singleton.class);

    }
	
	/*
	 * Tried playing with this but had unresolved issues
	@Provides @Singleton @Inject
	public LoginPresenter provideLoginPresenter(IndexPresenter parentPresenter)
	{
	    return new LoginPresenter(parentPresenter);
	}
	*/
	

}