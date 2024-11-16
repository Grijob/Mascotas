package mx.grijob.mascota;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Configura la Toolbar con imagen personalizada
        int imageResourceId = R.drawable.paw_print; // Reemplaza con tu recurso de imagen
        boolean mostrarImagen = true; // Cambia a false si no quieres mostrar la imagen

        MyToolbar.show(this, "Macotas", false, imageResourceId, mostrarImagen);

        listaMascotas = findViewById(R.id.rvMascotas);
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
        // Crear lista de datos
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Golden Retriever", 3, R.mipmap.golden_retriever_foreground));
        mascotas.add(new Mascota("Poodle", 2, R.mipmap.poodle_foreground));
        mascotas.add(new Mascota("Pastor alemán", 5, R.mipmap.pastor_aleman_foreground));
        mascotas.add(new Mascota("Bulldog", 7, R.mipmap.bulldog_foreground));
        mascotas.add(new Mascota("Labrador retriever", 1, R.mipmap.labrador_foreground));
        mascotas.add(new Mascota("Chihuahua", 4, R.mipmap.chihuahua_foreground));
        mascotas.add(new Mascota("Beagle", 6, R.mipmap.beagle_foreground));
        mascotas.add(new Mascota("Jack Russell", 8, R.mipmap.jack_russell_foreground));
        mascotas.add(new Mascota("West Highland White Terrier", 9, R.mipmap.west_highland_foreground));
        // Agrega más mascotas según sea necesario
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favoritos) {
            Intent intent = new Intent(this, FavoritosActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
