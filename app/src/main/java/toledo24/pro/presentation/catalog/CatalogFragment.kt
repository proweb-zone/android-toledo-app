package toledo24.pro.presentation.catalog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import toledo24.pro.databinding.FragmentCatalogBinding
import toledo24.pro.domain.adapters.CatalogAdapter


class CatalogFragment : Fragment() {

    private lateinit var binding: FragmentCatalogBinding
    private val viewModel by viewModel<CatalogFragmentViewModel>()
    private val adapter by lazy { CatalogAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCatalogBinding.inflate(inflater)
        binding.rcView.layoutManager = GridLayoutManager(context, 2)
        binding.rcView.adapter = adapter

        // перебираем все потоки FLOW из collector и
        // проверяем нет ли там новых данных о категориях
        lifecycleScope.launchWhenStarted {
                viewModel.categoriesList.onEach { value ->
                    value.forEach {
                        adapter.addCatalog(it)
                    }
                }.collect()
        }

        adapter.setOnItemClickListener(
            object : CatalogAdapter.ClickListener {
            override fun onItemClick(v: View, position: Int) {
                viewModel.clickCategoriesItem(adapter.getItem(position))

                lifecycleScope.launchWhenStarted {
                    viewModel.stateClickItem.onEach { value ->
                        if(value) {
                            Log.d("TAG", "показываю категории ")
                        } else {
                            Log.d("TAG", " перехожу в каталог ${adapter.getItem(position)?.id.toString()} ")

                        }
                    }.collect()
                }

            }
        })


        return binding.root
    }

}

