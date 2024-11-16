package mx.grijob.mascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MyToolbar {
    public static void show(AppCompatActivity activity, String title, boolean upButton) {
        show(activity, title, upButton, null, false);
    }

    public static void show(AppCompatActivity activity, String title, boolean upButton, Integer imageResId, boolean showImage) {
        Toolbar mToolbar = activity.findViewById(R.id.toolbar);
        if (mToolbar != null) {
            activity.setSupportActionBar(mToolbar);
            if (activity.getSupportActionBar() != null) {
                activity.getSupportActionBar().setTitle(title);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
            }

            // Manejar la imagen personalizada
            ImageView imageView = mToolbar.findViewById(R.id.custom_image);
            if (imageView != null) {
                if (showImage && imageResId != null) {
                    imageView.setImageResource(imageResId);
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }
        }
    }
}
