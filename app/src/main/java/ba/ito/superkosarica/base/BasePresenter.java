package ba.ito.superkosarica.base;

/**
 * Created by korisnik on 12.3.2018..
 */

public interface BasePresenter<T> {
    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    void takeView(T view);

    /**
     * Drops the reference to the view when destroyed
     */
    void dropView();
}
