package the.movees.app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class FirstSplash extends AppCompatActivity {

    TextView upperText;
    TextView lowerText;
    TextView presentsText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_splash);
        upperText = (TextView) findViewById(R.id.top_text);
        lowerText = (TextView) findViewById(R.id.bottom_text);
        presentsText = (TextView) findViewById(R.id.presents);
        fadeInLowerText();
        moveToSecondSplash();

    }
    public void fadeInLowerText(){
        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);
        lowerText.startAnimation(in);
        presentsText.startAnimation(in);

    }
    public void moveToSecondSplash()
    {
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                Intent intent = new Intent(FirstSplash.this,SecondSplash.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        };
        handler.postDelayed(r, 3000);
    }
    public void finishSplash(){
        finish();
    }
}
