package mx.grijob.mascota;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import mx.grijob.mascota.Mascota;
import mx.grijob.mascota.MascotaAdapter;
import mx.grijob.mascota.MyToolbar;
import mx.grijob.mascota.R;


public class FavoritosActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);



        // Configura la Toolbar con imagen personalizada
        int imageResourceId = R.drawable.paw_print; // Reemplaza con tu recurso de imagen
        boolean mostrarImagen = true; // Cambia a false si no quieres mostrar la imagen

        MyToolbar.show(this, "Favoritos", true, imageResourceId, mostrarImagen);



        // Configura la lista de mascotas
        listaMascotas = findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }


    public void inicializarAdaptador() {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Labrador", 3, R.mipmap.labrador_foreground));
        mascotas.add(new Mascota("Beagle", 4, R.mipmap.beagle_foreground));
        mascotas.add(new Mascota("Bulldog", 2, R.mipmap.bulldog_foreground));
        mascotas.add(new Mascota("Chihuahua", 5, R.mipmap.chihuahua_foreground));
        mascotas.add(new Mascota("Jack Russel", 1, R.mipmap.jack_russell_foreground));

        // Agrega más mascotas dummy si es necesario
    }
}
