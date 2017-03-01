package news.feicui.edu.myapplications;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
/**
 * 
 * @author 
 *
 */
public class LoadingImageView extends ImageView {
	private AnimationDrawable mAnimationDrawable;

	public LoadingImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setBackgroundResource(R.drawable.loading);
		mAnimationDrawable = (AnimationDrawable) getBackground();
		mAnimationDrawable.start();
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {

		super.onVisibilityChanged(changedView, visibility);
		if (visibility == View.GONE) {
			mAnimationDrawable.stop();
		}
	}
}
