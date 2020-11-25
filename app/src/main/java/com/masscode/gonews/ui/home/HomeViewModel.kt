package com.masscode.gonews.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.masscode.gonews.domain.usecase.UserUseCase

class HomeViewModel @ViewModelInject constructor(userUseCase: UserUseCase) : ViewModel() {
    val articles = LiveDataReactiveStreams.fromPublisher(userUseCase.getAllArticles())
}