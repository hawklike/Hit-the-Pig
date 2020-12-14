package cz.cvut.fit.miadp.mvcgame.memento_singleton;

import java.util.ArrayList;
import java.util.List;

public class CannonCareTaker {

    private static class SingletonHolder {
        private static final CannonCareTaker INSTANCE = new CannonCareTaker();
    }

    public static CannonCareTaker getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private CannonCareTaker() {
    }

    private List<Object> mementos = new ArrayList<>();

    public void saveState(Object state) {
        mementos.add(state);
    }

    public Object restoreLast() {
        return mementos.get(mementos.size() - 1);
    }

    public Object restore(int index) {
        return mementos.get(index);
    }
}
