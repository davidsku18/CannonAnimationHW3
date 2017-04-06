package edu.up.cannonanimationhw3a;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * CannonMainActivity
 * 
 * This is the activity for the cannon animation. It creates a AnimationCanvas
 * containing a particular Animator object
 * 
 * @author Andrew Nuxoll
 * @version September 2012
 * 
 */
public class CannonMainActivity extends Activity {

	private double cannonAngle;
	private SeekBar cannonAngleSeekBar;
    private CannonAnimator testAnim;
    private Button fire;
    private TextView currentAngle;
	protected final int MAX_ANGLE = 90;

	/**
	 * creates an AnimationCanvas containing a TestAnimator.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cannon_main);


        fire = (Button) findViewById(R.id.fire);
        currentAngle = (TextView) findViewById(R.id.currentAngle);
		cannonAngleSeekBar = (SeekBar) findViewById(R.id.cannonAngleSeekBar);
		cannonAngleSeekBar.setMax(MAX_ANGLE);

        fire.setOnClickListener(new fireOnListener());
		cannonAngleSeekBar.setOnSeekBarChangeListener(new cannonAngleSeekBarListener());

		// Create an animation canvas and place it in the main layout
		testAnim = new CannonAnimator();
		AnimationCanvas myCanvas = new AnimationCanvas(this, testAnim);
		LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.topLevelLayout);
		mainLayout.addView(myCanvas);
	}

	public class cannonAngleSeekBarListener implements SeekBar.OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			cannonAngle = progress;
            currentAngle.setText(""+cannonAngle);
            testAnim.setAngle(Math.toRadians(cannonAngle));
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {

		}
	}

	public class fireOnListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v.getId() == fire.getId()) {
                testAnim.fireCannon();
            }
        }
    }

	/**
	 * This is the default behavior (empty cannon_main.xml)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cannon_main, menu);
		return true;
	}
}
