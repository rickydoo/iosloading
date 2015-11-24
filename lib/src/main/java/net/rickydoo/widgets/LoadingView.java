package net.rickydoo.widgets;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.rickydoo.widgets.iosloading.R;

/**
 * Created by Ricky DOO on Nov. 24, 2015.
 */
public class LoadingView extends RelativeLayout {
	private static final String TAG = LoadingView.class.getSimpleName();

	public LoadingView(Context context) {
		this(context, null, 0);
	}

	public LoadingView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	private TextView loadingMessage;

	public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		// Add view
		View loadingView = View.inflate(getContext(), R.layout.loading_view, null);
		if (loadingView != null) {
			addView(loadingView, new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT));
			loadingMessage = (TextView) loadingView.findViewById(R.id.loading_title);
		}
		setClickable(false);
	}

	public void setLoadingMessage(String message) {
		if (message == null)
			loadingMessage.setVisibility(View.GONE);
		try {
			loadingMessage.setText(message);
			loadingMessage.setVisibility(View.VISIBLE);
		} catch (Exception e) {
			e.printStackTrace();
			loadingMessage.setVisibility(View.GONE);
		}
	}

	public void setLoadingMessage(@StringRes int stringRes) {
		if (stringRes == 0)
			loadingMessage.setVisibility(View.GONE);
		try {
			loadingMessage.setText(stringRes);
			loadingMessage.setVisibility(View.VISIBLE);
		} catch (Exception e) {
			e.printStackTrace();
			loadingMessage.setVisibility(View.GONE);
		}
	}
}
