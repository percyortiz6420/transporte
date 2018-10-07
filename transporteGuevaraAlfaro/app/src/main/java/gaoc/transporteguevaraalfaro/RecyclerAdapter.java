package gaoc.transporteguevaraalfaro;

/**
 * Created by Shade on 5/9/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;

    public RecyclerAdapter(Context context){
        this.context = context;
    }

    private String[] titles = {"Mis viajes",
            "Combustible",
            "Agregar viaje",
            "Devoluciones"

            };



    private int[] images = { R.drawable.camion,
            R.drawable.agregar,
            R.drawable.nuevo,
            R.drawable.gas
             };

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);


           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int position = getAdapterPosition();


                   switch (position){
                       case 0:
                           Intent act2 = new Intent(context, misViajes.class);
                           context.startActivity(act2);

                           break;

                       case 1:

                           Intent info_doble = new Intent(context, agregarViaje.class);
                           context.startActivity(info_doble);
                           break;

                       case 2:
                           Intent act4 = new Intent(context, devolucion.class);
                           context.startActivity(act4);
                           break;

                       case 3:
                           Intent gass = new Intent(context, gas.class);
                           context.startActivity(gass);
                            break;




                       default:

                           break;
                   }

               }
           });








               /*     Snackbar.make(v, "Ha seleccionado: " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);

        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}