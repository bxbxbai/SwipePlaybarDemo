package io.bxbxbai.swipeplaybar;

import android.app.Application;


/**
 *
 * @author bxbxbai
 */
public class App extends Application {


    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application instance(){
        return instance;
    }
}
