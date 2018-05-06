package bkonecsni.plsocers.interactor.common;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Response;

public class CommonNetworkInteractor {

    protected void throwExceptionIfNecessary(Response<?> response) throws Exception {
        if (response.code() != 200) {
            throw new Exception("Result code is not 200");
        }
    }

    protected void createAndPostErrorEvent(CommonEvent event, Exception e) {
        event.setThrowable(e);
        EventBus.getDefault().post(event);
    }

    protected void creaateAndPostEvent(CommonEvent event, Response<?> response, List items) {
        event.setCode(response.code());
        event.setItems(items);
        EventBus.getDefault().post(event);
    }
}
