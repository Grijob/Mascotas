package mx.grijob.mascota;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    private ArrayList<Mascota> mascotas;
    private Context context;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);

        // Log para depurar el recurso de imagen que se va a establecer
        Log.d("MascotaAdapter", "Setting image resource: " + mascota.getFoto());

        // Establece el recurso de imagen en el ImageView
        holder.imgFoto.setImageResource(mascota.getFoto());

        // Establece el nombre de la mascota
        holder.tvNombre.setText(mascota.getNombre());

        // Establece el rating de la mascota
        holder.tvRating.setText(String.valueOf(mascota.getRating()));

        // Configura el evento de clic para incrementar el rating
        holder.imgHuesoBlanco.setOnClickListener(v -> {
            mascota.setRating(mascota.getRating() + 1);
            holder.tvRating.setText(String.valueOf(mascota.getRating()));
        });
    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }





    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRating;
        private ImageView imgHuesoBlanco;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRating = itemView.findViewById(R.id.tvRating);
            imgHuesoBlanco = itemView.findViewById(R.id.imgHuesoBlanco);
        }
    }
}
