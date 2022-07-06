package toledo24.pro.domain.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import toledo24.pro.R
import toledo24.pro.databinding.CatalogItemBinding
import toledo24.pro.data.network.CatalogModel


class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogHolder>() {

    val catalogList = ArrayList<CatalogModel>()
    private var clickListener: ClickListener? = null

    // adapter (шаблон по которому будет происходить заполнение данных)
   inner class CatalogHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener {
        val binding = CatalogItemBinding.bind(item)

        init {
            if (clickListener != null) {
                itemView.setOnClickListener(this)
            }
        }

        fun bind(catalogModel: CatalogModel) = with(binding) {
            CatalogTextView.text = catalogModel.name
            Picasso.get()
                .load(catalogModel.picture)
                .resize(150, 150)
                .centerCrop()
                .placeholder(R.drawable.welcome_logo)
                .error(R.drawable.welcome_logo)
                .into(CatalogimageView)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                clickListener?.onItemClick(view,adapterPosition)
            }
        }

    }

    /**
     * Создается элемент списка
     * надувает view и загружает его в память
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.catalog_item, parent, false)
        return CatalogHolder(view)
    }

    /**
     * Заполняется элемент списка
     */
    override fun onBindViewHolder(holder: CatalogHolder, position: Int) {
        holder.bind(catalogList[position])
    }

    override fun getItemCount(): Int {
        return catalogList.size
    }

    fun getItem(position: Int): CatalogModel? {
        return catalogList?.get(position)
    }

    fun addCatalog(catalogModel: CatalogModel) {
        catalogList.add(catalogModel)
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onItemClick(v: View,position: Int)
    }


}