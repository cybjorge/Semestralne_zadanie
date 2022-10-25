package com.example.semestralne_zadanie.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.semestralne_zadanie.ListOfPubs
import com.example.semestralne_zadanie.ListOfPubsDirections
import com.example.semestralne_zadanie.R
import com.example.semestralne_zadanie.model.Pub

class ItemAdapter(private val context: ListOfPubs, private val dataset: List<Pub>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(getAdapterPosition(), getItemViewType())
        }
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_pub, parent, false)
        return ItemViewHolder(adapterLayout).listen { pos, type ->
            val detail = dataset[pos]
            var p_name=detail.tags.get("name")
            var web=detail.tags.get("website")
            var time=detail.tags.get("opening_hours")
            if (p_name == null){p_name="Tento podnik nema meno"}
            if (web == null){web="Neni web"}
            if (time == null){time="Tento podnik nema otvaracie hodiny"}
            val action = ListOfPubsDirections.actionListOfPubsToPubDetail2(p_name,
                iId = pos.toString(),time, web)



            adapterLayout.findNavController().navigate(action)

        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val pub_name=item.tags.get("name")
        holder.textView.text = pub_name

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}