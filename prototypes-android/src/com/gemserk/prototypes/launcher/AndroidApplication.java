package com.gemserk.prototypes.launcher;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.gemserk.commons.gdx.Game;
import com.gemserk.commons.utils.BrowserUtilsAndroidImpl;
import com.gemserk.commons.utils.FacebookUtilsAndroidImpl;
import com.gemserk.commons.utils.MailUtilsAndroidImpl;
import com.gemserk.prototypes.Launcher;
import com.gemserk.prototypes.Utils;

public class AndroidApplication extends com.badlogic.gdx.backends.android.AndroidApplication {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		RelativeLayout layout = new RelativeLayout(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.useGL20 = false;
		config.useAccelerometer = true;
		config.useCompass = true;
		config.useWakelock = true;
		
		Utils.mailUtils = new MailUtilsAndroidImpl(this);
		Utils.facebookUtils = new FacebookUtilsAndroidImpl(this);
		Utils.browserUtils = new BrowserUtilsAndroidImpl(this);

		Game game = new Launcher();

		View gameView = initializeForView(game, config);

		layout.addView(gameView);

		setContentView(layout);
	}

}