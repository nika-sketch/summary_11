package ge.nlatsabidze.summary_11.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ge.nlatsabidze.summary_11.R
import ge.nlatsabidze.summary_11.databinding.UserItemBinding
import ge.nlatsabidze.summary_11.model.UserInformation

class InformationAdapter(): RecyclerView.Adapter<InformationAdapter.UserItemViewHolder>() {

    var user: List<UserInformation> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class UserItemViewHolder(val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        private lateinit var userItem: UserInformation


        @SuppressLint("SetTextI18n")
        fun onBind() {
            userItem = user[bindingAdapterPosition]
            with(binding) {
                with(userItem) {
                    tvNameAndSurname.text = firstName.toString() + lastName.toString()
                    if (firstName != "Michael" && firstName != "Byron") {
                        imageView.visibility = View.INVISIBLE
                    }
                    imageView.text = unreaMessage.toString()

                    Glide.with(root.context).load(avatar).apply(RequestOptions().override(60, 60)).into(ivUser);

                    if (userItem.messageType == "attachment") {
                        ivAttachment.visibility = View.VISIBLE
                        tvEmail.text = "Sent an Attachment"
                        ivAttachment.setImageResource(R.drawable.ic_attachment)
                    } else if (messageType == "voice") {
                        tvEmail.text = "Sent a voice message"
                        ivAttachment.visibility = View.VISIBLE
                        ivAttachment.setImageResource(R.drawable.ic_recorder)
                    } else {
                        tvEmail.text = email.toString()
                    }

                    tvTime.text = "4:20 PM"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = user.size
}