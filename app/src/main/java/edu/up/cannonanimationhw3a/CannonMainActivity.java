package edu.up.cannonanimationhw3a;

import android.app.Activity;
import android.media.MediaPlayer;
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
 * PART B IMPLEMENTATIONS:
 * - ARBITRARY NUMBER OF BALLS IN THE AIR AT ONE
 * - ALLOW THE USER TO CHANGE THE GRAVITY
 * - SOUND AT APPROPRIATE TIME: WHEN THE CANNON IS FIRED
 * 
 * @author Kurtis Davidson
 * @version April 5, 2017
 * 
 */
public class CannonMainActivity extends Activity {

	private double cannonAngle;
	private double gravity;
	private SeekBar cannonAngleSeekBar;
	private SeekBar gravitySeekBar;
    private CannonAnimator animate;
    private Button fire;
    private TextView currentAngle;
	private TextView currentGravity;
	protected final int MAX_ANGLE = 90;
	protected final int MAX_GRAVITY = 30;

	/**
	 * Creates an AnimationCanvas containing a CannonAnimator.
     *
     * External Citation
     * Date: 9 April 2017
     * Problem: Didn't know how to implement sound correctly
     * Resource:
     * http://stackoverflow.com/questions/18459122/play-sound-on-button-click-android
     * Solution: I used the example code from this post.
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cannon_main);


        fire = (Button) findViewById(R.id.fire);
        currentAngle = (TextView) findViewById(R.id.currentAngle);
		currentGravity = (TextView) findViewById(R.id.currentGravity);
		cannonAngleSeekBar = (SeekBar) findViewById(R.id.cannonAngleSeekBar);
		gravitySeekBar = (SeekBar) findViewById(R.id.gravitySeekbar);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.cannon);

        //setting max values for seekBars
		cannonAngleSeekBar.setMax(MAX_ANGLE);
		gravitySeekBar.setMax(MAX_GRAVITY);

        //sets the fire listener and calls fireCannon when pressed and plays a sound
        fire.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                animate.fireCannon();
                mp.start();
            }
        });

		//setting listeners
		cannonAngleSeekBar.setOnSeekBarChangeListener(new cannonAngleSeekBarListener());
		gravitySeekBar.setOnSeekBarChangeListener(new gravitySeekBarListener());

		// Create an animation canvas and place it in the main layout
		animate = new CannonAnimator();
		AnimationCanvas myCanvas = new AnimationCanvas(this, animate);
		LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.topLevelLayout);
		mainLayout.addView(myCanvas);
	}

	public class cannonAngleSeekBarListener implements SeekBar.OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			cannonAngle = progress;
            currentAngle.setText(""+cannonAngle);
            animate.setAngle(Math.toRadians(cannonAngle));
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {

		}
	}

	public class gravitySeekBarListener implements SeekBar.OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			gravity = progress;
			currentGravity.setText(""+gravity);
			animate.setGravity(gravity);
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cannon_main, menu);
		return true;
	}
}