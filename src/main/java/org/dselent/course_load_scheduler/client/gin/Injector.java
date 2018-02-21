package org.dselent.course_load_scheduler.client.gin;

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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Interface required by gin due to lack of runtime reflections
 * Provide methods to get all objects that are to be injected
 * 
 * GinModules annotation: indicates what the module file is
 * 
 * @author dselent
 *
 */
@GinModules(InjectorModule.class)
public interface Injector extends Ginjector
{
	// GIN generator will instantiate this
	// GWT.create uses deferred bindings where many permutations are created but only one
	// is used at runtime (the one for the specific browser)
    public static final Injector INSTANCE = GWT.create(Injector.class);
 
    // event bus
    public SimpleEventBus getEventBus();
    
    // presenters
    public IndexPresenterImpl getIndexPresenter();
    public LoginPresenterImpl getLoginPresenter();
    public MenuTabsPresenterImpl getMenuTabsPresenterImpl();
    public AccountsPresenterImpl getAccountsPresenterImpl();
    public CoursesPresenterImpl getCoursesPresenterImpl();
    public HomePresenterImpl getHomePresenterImpl();
    public NotificationsPresenterImpl getNotificationsPresenterImpl();
    public ProfilePresenterImpl getProfilePresenterImpl();
    public ScheduleGeneratorPresenterImpl getScheduleGeneratorPresenterImpl();
    public WishlistPresenterImpl getWishlistPresenterImpl();
    public ExamplePresenterImpl getExamplePresenter();
     
    //views
    public IndexViewImpl getIndexView();
    public LoginViewImpl getLoginView();
    public MenuTabsImpl getMenuTabsView();
    public AccountsViewImpl getAccountsView();
    public CoursesViewImpl getCoursesView();
    public HomeViewImpl getHomeView();
    public NotificationsViewImpl getNotificationsView();
    public ProfileViewImpl getProfileView();
    public ScheduleGeneratorViewImpl getScheduleGeneratorView();
    public WishlistViewImpl getWishlistView();
    
    // services
    public UserServiceImpl getUserService();
}
