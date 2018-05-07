package bkonecsni.plsocers;

import javax.inject.Singleton;

import bkonecsni.plsocers.interactor.InteractorModule;
import bkonecsni.plsocers.mock.MockNetworkModule;
import dagger.Component;
@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends PlScoresApplicationComponent {
}
