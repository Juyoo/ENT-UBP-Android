package com.ent_ubp_android.app.adapter.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ent_ubp_android.app.Interface.IRecyclerViewClickListener;
import com.ent_ubp_android.app.R;
import com.ent_ubp_android.app.model.teacher.*;
import com.ent_ubp_android.app.model.teacher.contact.adresse.Address;
import com.ent_ubp_android.app.model.teacher.contact.email.Email;
import com.ent_ubp_android.app.model.teacher.contact.phone.Phone;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RecyclerViewProfesseurAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static IRecyclerViewClickListener mListener;
    private List<Teacher> listTeacher;

    private class ViewHolderProfesseur extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nom;
        TextView type;

        public ViewHolderProfesseur(View itemView) {
            super(itemView);

            nom = (TextView) itemView.findViewById(R.id.professeur_nom);
            type = (TextView) itemView.findViewById(R.id.professeur_type);

            itemView.setOnClickListener(this);
        }

        public void bind(Teacher teacher) {
            nom.setText(teacher.getName().getFirstName() + " " + teacher.getName().getLastName());

            if(teacher.getType().toString().compareTo(TeacherType.UNIVERSITY_TEACHER.toString())==0){
                type.setText(R.string.professeur_type_university_string);
            }else{
                type.setText(R.string.professeur_type_outsider_string);
            }

          /*  Set<Email> emails = teacher.getContact().getEmails();
            Set<Phone> phones =  teacher.getContact().getPhones();

            mail.setText(emails.iterator().next().getDetails().getAddress());
            tel.setText(phones.iterator().next().getDetails().getNumber());*/

        }

        @Override
        public void onClick(View v) {
            mListener.onRecyclerViewItemClicked(v, getLayoutPosition());
        }
    }

    public RecyclerViewProfesseurAdapter(IRecyclerViewClickListener listener, List<Teacher> listTeacher){
        this.listTeacher = listTeacher;
        this.mListener = listener;
    }

    @Override
    public ViewHolderProfesseur onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.professeur_display_cell_card, parent, false);
        return new ViewHolderProfesseur(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderProfesseur) holder).bind(listTeacher.get(position));
    }

    @Override
    public int getItemCount() {
        return listTeacher.size();
    }
}
