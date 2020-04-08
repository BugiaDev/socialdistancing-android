package com.accenture.socialdistancing.ui.aura

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.accenture.socialdistancing.R
import com.accenture.socialdistancing.model.Contact


class AuraFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_aura, container, false)

        viewManager = LinearLayoutManager(activity)
        viewAdapter = ContactsAdapter(context!!, getSampleContacts())

        recyclerView = root.findViewById<RecyclerView>(R.id.rvContacts).apply {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return root
    }

    private fun getSampleContacts(): List<Contact> {
        return listOf(
            Contact(2, "Xiaomi smartBand 3", "00:32:jh:10:l2:gh", "15:45"),
            Contact(0, "LG smart TV", "64:re:12:jj:m9:0j", "16:10"),
            Contact(1, "Antonella's phone", "44:32:kk:m4:20:ng", "17:33")
        )
    }
}