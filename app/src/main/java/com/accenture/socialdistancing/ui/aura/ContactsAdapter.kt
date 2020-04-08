package com.accenture.socialdistancing.ui.aura

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.accenture.socialdistancing.R
import com.accenture.socialdistancing.model.Contact

class ContactsAdapter(private val context: Context, private val contacts: List<Contact>): RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>()  {

    class ContactViewHolder(val layout: LinearLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
       return ContactViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_cell, parent, false) as LinearLayout)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val tvDeviceName = holder.layout.findViewById(R.id.tvDeviceName) as TextView
        val tvDeviceMac = holder.layout.findViewById(R.id.tvDeviceMac) as TextView
        val tvDeviceRisk = holder.layout.findViewById(R.id.tvDeviceRisk) as TextView
        val tvDeviceTime = holder.layout.findViewById(R.id.tvDeviceTime) as TextView

        tvDeviceName.text = contacts[position].deviceName
        tvDeviceMac.text = contacts[position].deviceMac
        tvDeviceRisk.text = getTextWithRisk(contacts[position].risk)
        tvDeviceRisk.setTextColor(getColorWithRisk(contacts[position].risk))
        tvDeviceTime.text = contacts[position].timestamp
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    private fun getColorWithRisk(risk: Int): Int {
        return when(risk) {
            0 -> ContextCompat.getColor(context, R.color.colorPrimaryDark)
            1 -> ContextCompat.getColor(context, R.color.orange)
            else -> ContextCompat.getColor(context, R.color.red)
        }
    }

    private fun getTextWithRisk(risk: Int): String {
        return when(risk) {
            0 -> context.getString(R.string.low_risk)
            1 -> context.getString(R.string.moderate_risk)
            else -> context.getString(R.string.high_risk)
        }
    }
}