package ihsanbal.com.wiv;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ihsanbal.wiv.MediaView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> medias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MediaView mediaView = (MediaView) findViewById(R.id.media_view);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        medias.add("http://datalook.io/app/uploads/NY.jpg");
        medias.add("https://wallpaperbrowse.com/media/images/High-Definition-Ultra-HD-Wallpaper.jpg");
        medias.add("https://static.pexels.com/photos/17679/pexels-photo.jpg");
        mediaView.setOnMediaClickListener(new MediaView.OnMediaClickListener() {
            @Override
            public void onMediaClick(View view, int index) {
                Snackbar.make(view, "onClickIndex :" + index, Snackbar.LENGTH_LONG).show();
            }
        });
        mediaView.setMedias(medias);
    }

}
