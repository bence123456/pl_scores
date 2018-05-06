package bkonecsni.plsocers.ui.common;

import org.greenrobot.eventbus.EventBus;

import bkonecsni.plsocers.interactor.common.CommonEvent;
import bkonecsni.plsocers.ui.Presenter;

public class CommonPresenter<S extends CommonScreen> extends Presenter<S> {

    @Override
    public void attachScreen(S screen) {
        super.attachScreen(screen);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    protected void handleNetworkError(CommonEvent event) {
        event.getThrowable().printStackTrace();
        if (screen != null) {
            screen.showNetworkError(event.getThrowable().getMessage());
        }
    }
}
