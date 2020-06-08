package br.com.branch.testes.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import br.com.branch.testes.R;

public class InfoAdapter  implements GoogleMap.InfoWindowAdapter
{
    Context ctx;

    public InfoAdapter(Context ctx)
    {
        this.ctx=ctx;

    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker)
    {

        View view = ((Activity)ctx).getLayoutInflater()
                .inflate(R.layout.layout_info, null);

        //int imageId = ctx.getResources().getIdentifier(R.drawable.ic_launcher_background,
         //       "drawable", ctx.getPackageName());

        TextView txtinfo1 = view.findViewById(R.id.txtinfo1);
        TextView txtinfo2 = view.findViewById(R.id.txtinfo2);
        TextView txtinfo3 = view.findViewById(R.id.txtinfo3);
        ImageView imginfo = view.findViewById(R.id.imginfo);

        txtinfo1.setText("Feiras dos Testes de Cleiton");
        txtinfo2.setText("Rua Teste de Olivera Ferraz");
        txtinfo3.setText("Bairro Jardim dos Testes");
       imginfo.setImageResource(R.mipmap.ic_mensagem);

        return view;
    }
}
