package com.example.userregistration.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userregistration.R
import com.example.userregistration.databinding.ChildBinding
import com.example.userregistration.databinding.ParentBinding
import com.example.userregistration.model.UserDataSubListItem
import com.example.userregistration.model.UserResponse

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private val parents = mutableListOf<UserResponse>()

    private var viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ParentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    @SuppressLint("WrongConstant")
    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(holder.recyclerView.context, LinearLayout.VERTICAL, false)
            adapter = UserChildAdapter()
            viewPool = recycledViewPool

            holder.recyclerView

        }
    }

    override fun getItemCount() = parents.size

    fun setData(parents: MutableList<UserResponse>) {
        this.parents.addAll(parents)
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: ParentBinding) : RecyclerView.ViewHolder(binding.root) {
        val recyclerView: RecyclerView = itemView.findViewById(R.id.rvChild)
    }


    /**Child Adapter**/

    inner class UserChildAdapter
        : RecyclerView.Adapter<UserChildAdapter.ViewHolder>() {

        private val children = mutableListOf<UserDataSubListItem>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ChildBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

        override fun onBindViewHolder(holder: UserChildAdapter.ViewHolder, position: Int) {
            val child = children[position]
            holder.textView.hint = child.hint
            // holder.textView.inputType = child.field_type
        }

        override fun getItemCount() = children.size

        fun setDataTochild(children: MutableList<UserDataSubListItem>) {
            this.children.addAll(children)
            notifyDataSetChanged()
        }

        inner class ViewHolder(binding: ChildBinding) : RecyclerView.ViewHolder(binding.root) {

            val textView: EditText = itemView.findViewById(R.id.childEditText)

        }
    }
}