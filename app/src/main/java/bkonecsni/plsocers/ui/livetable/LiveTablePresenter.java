package bkonecsni.plsocers.ui.livetable;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import bkonecsni.plsocers.PlScoresApplication;
import bkonecsni.plsocers.di.Network;
import bkonecsni.plsocers.interactor.livetable.GetLiveTableEvent;
import bkonecsni.plsocers.interactor.livetable.LiveTableInteractor;
import bkonecsni.plsocers.ui.common.CommonPresenter;

public class LiveTablePresenter extends CommonPresenter<LiveTableScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    LiveTableInteractor liveTableInteractor;

    @Override
    public void attachScreen(LiveTableScreen screen) {
        super.attachScreen(screen);
        PlScoresApplication.injector.inject(this);
    }

    public void refreshTable() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                liveTableInteractor.getLiveTable();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetLiveTableEvent event) {
        if (event.getThrowable() != null) {
            handleNetworkError(event);
        } else {
            if (screen != null) {
                screen.showLiveTable(event.getItems());
            }
        }
    }


}
