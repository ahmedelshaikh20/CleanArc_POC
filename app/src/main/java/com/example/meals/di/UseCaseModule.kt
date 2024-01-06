package com.example.meals.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImpl
import com.example.domain.repo.MealsRepo
import com.example.domain.usecase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

  @Provides
  fun provideMeals(repo: MealsRepo):GetMeals{
    return GetMeals(repo)
  }

}
