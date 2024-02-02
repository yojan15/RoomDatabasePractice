package com.example.roomdatabasepractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasepractice.data.Notes
import org.w3c.dom.Text

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    private var notes = emptyList<Notes>()
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.notes,parent,false))
    }

    override fun getItemCount(): Int {
     return notes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentNote = notes[position]
        holder.itemView.findViewById<TextView>(R.id.noteTitle).text = currentNote.title.toString()
        holder.itemView.findViewById<TextView>(R.id.noteText).text = currentNote.note.toString()
    }

    fun setData(notes: List<Notes>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}