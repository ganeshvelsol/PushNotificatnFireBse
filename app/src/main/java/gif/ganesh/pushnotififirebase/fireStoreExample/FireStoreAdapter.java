package gif.ganesh.pushnotififirebase.fireStoreExample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gif.ganesh.pushnotififirebase.R;

public class FireStoreAdapter extends RecyclerView.Adapter<FireStoreAdapter.ViewHolds>
{
    Context context;
    List<FireStoreModels> mlist;

    public FireStoreAdapter(Context context, List<FireStoreModels> mlist)
    {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public FireStoreAdapter.ViewHolds onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new ViewHolds(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FireStoreAdapter.ViewHolds viewHolds, int i)
    {
        viewHolds.mtext1.setText(mlist.get(i).getModelName());
        viewHolds.mtext2.setText(mlist.get(i).getModelEmail());
    }

    @Override
    public int getItemCount()
    {
        return mlist.size();
    }

    public class ViewHolds extends RecyclerView.ViewHolder
    {
        TextView mtext1,mtext2;
        public ViewHolds(@NonNull View itemView)
        {
            super(itemView);
            mtext1=itemView.findViewById(R.id.mtext1);
            mtext2=itemView.findViewById(R.id.mtext2);
        }
    }

}
