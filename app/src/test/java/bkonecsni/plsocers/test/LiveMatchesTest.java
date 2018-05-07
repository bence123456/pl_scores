package bkonecsni.plsocers.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import bkonecsni.plsocers.BuildConfig;
import bkonecsni.plsocers.ui.livematches.LiveMatchesPresenter;
import bkonecsni.plsocers.ui.livematches.LiveMatchesScreen;

import static bkonecsni.plsocers.TestHelper.setTestInjector;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class LiveMatchesTest {

    private LiveMatchesPresenter liveMatchesPresenter;
    private LiveMatchesScreen liveMatchesScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        liveMatchesScreen = mock(LiveMatchesScreen.class);
        liveMatchesPresenter = new LiveMatchesPresenter();
        liveMatchesPresenter.attachScreen(liveMatchesScreen);
    }

    @Test
    public void testShowLiveMatches() {
        liveMatchesPresenter.refreshMatches();

        ArgumentCaptor<List> matchCaptor = ArgumentCaptor.forClass(List.class);
        verify(liveMatchesScreen).showLiveMatches(matchCaptor.capture());

        assertTrue(matchCaptor.getValue().size() > 0);
    }


    @After
    public void tearDown() {
        liveMatchesPresenter.detachScreen();
    }
}
