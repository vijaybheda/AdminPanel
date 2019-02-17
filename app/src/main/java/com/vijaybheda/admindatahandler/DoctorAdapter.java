package com.vijaybheda.admindatahandler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class DoctorAdapter extends FirestoreRecyclerAdapter<Doctor, DoctorAdapter.NoteHolder> {

    private OnItemClickListener listener;
    public DoctorAdapter(@NonNull FirestoreRecyclerOptions<Doctor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DoctorAdapter.NoteHolder holder, int position, @NonNull Doctor model) {
        holder.textViewDrName.setText(model.getDrName());
        holder.textViewDrCode.setText(String.valueOf(model.getDrCode()));

    }

    @NonNull
    @Override
    public DoctorAdapter.NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dr_detail, parent, false);
        return new DoctorAdapter.NoteHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView textViewDrName, textViewDrCode;

//        TextView textViewPriority;

        public NoteHolder(View itemView) {
            super(itemView);
            textViewDrName = itemView.findViewById(R.id.text_view_drname);
            textViewDrCode = itemView.findViewById(R.id.text_view_DrCode);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    public void setOnItemClickListener(DoctorAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }

}
