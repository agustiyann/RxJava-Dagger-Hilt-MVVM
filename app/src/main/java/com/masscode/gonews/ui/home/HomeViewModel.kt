package com.masscode.gonews.ui.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.masscode.gonews.domain.usecase.UserUseCase

class HomeViewModel(userUseCase: UserUseCase) : ViewModel() {
    val articles = LiveDataReactiveStreams.fromPublisher(userUseCase.getAllArticles())
}