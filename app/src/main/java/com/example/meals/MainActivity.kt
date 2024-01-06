package com.example.meals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.meals.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
  private val viewModel : MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val rv:RecyclerView = findViewById(R.id.category_rv)
      viewModel.getMeals()
      val mealsAdapter = MealsAdapter()
      lifecycleScope.launch {
        viewModel.categories.collect{
mealsAdapter.submitList(it?.categories)
          rv.adapter=mealsAdapter

        }
      }
    }
}
